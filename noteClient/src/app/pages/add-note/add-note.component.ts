import { Component, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { Notify } from 'notiflix';
import { Subscription } from 'rxjs';
import { NoteDto } from 'src/app/model/notes';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { NotesService } from 'src/app/services/notes.service';

@Component({
  selector: 'app-add-note',
  templateUrl: './add-note.component.html',
  styleUrls: ['./add-note.component.css'],
})
export class AddNoteComponent implements OnDestroy {
  content: string = "";
  title: string = "";
  noteServiceSubscription !: Subscription;
  constructor(
    private notesService: NotesService,
    private authenticationService: AuthenticationService,
  ) {

  }

  public addNote() {
    const id = this.authenticationService.getUserId();
    if (id != null || id != undefined) {
      if (this.content !== '' && this.title !== '') {
        const newNote: NoteDto = {
          title: this.title,
          content: this.content,
          userId: id,
        };
        this.noteServiceSubscription = this.notesService.addNote(newNote).subscribe({
          next: (data) => {
            Notify.success('note successfully created\n' + data.creationDate);
            (this.content = ''), (this.title = '');
          },
          error: (err) => {
            Notify.failure('something went wrong ');
            Notify.failure(err.message);
          },
        });

      } else {
        Notify.info('please fill the required fields');
      }
    }
  }

  public ngOnDestroy(): void {
    this.noteServiceSubscription.unsubscribe();
  }
}
