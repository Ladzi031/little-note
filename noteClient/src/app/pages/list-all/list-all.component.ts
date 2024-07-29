import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Notify } from 'notiflix';
import { Subscription } from 'rxjs';
import { NoteDto } from 'src/app/model/notes';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { NotesService } from 'src/app/services/notes.service';

@Component({
  selector: 'app-list-all',
  templateUrl: './list-all.component.html',
  styleUrls: ['./list-all.component.css'],
})
export class ListAllComponent implements OnInit, OnDestroy {
  message: string = "you don't have any notes";
  listOfNotes: NoteDto[] = [];

  noteSubscription !: Subscription;
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private notesService: NotesService,
    private route: ActivatedRoute,
  ) { }

  public ngOnInit(): void {
    const id = this.authenticationService.getUserId();
    if (id != null || id != undefined) {
      this.noteSubscription = this.notesService.getAllNotes(id).subscribe({
        next: (data) => {
          this.listOfNotes = data;
        },
        error: (err) => {
          Notify.failure('something went wrong');
          this.message = err.message;
          Notify.failure(err.message);
        },
      });
    }
  }

  public viewNote(noteId: number) {
    this.router.navigate([`../view/${noteId}`], { relativeTo: this.route });
  }
  public deleteNote(noteId: number) {
    const id = this.authenticationService.getUserId();
    if (id != null || id != undefined) {
      // a custom confirm modal ?
      if (confirm('are you sure you want to delete the note?')) {
        this.noteSubscription = this.notesService.deleteNote(id, noteId).subscribe({
          next: (data: any) => {
            if (data == null) {
              Notify.success('note deleted successfully');
              this.noteSubscription = this.notesService
                .getAllNotes(this.authenticationService.getUserId()!)
                .subscribe((d) => {
                  this.listOfNotes = d;
                });
            }
          },
          error: (err) => {
            Notify.failure('something went wrong');
            Notify.failure(err.message);
          },
        });
      }
    }
  }

  public ngOnDestroy(): void {
    this.noteSubscription.unsubscribe();
  }
}
