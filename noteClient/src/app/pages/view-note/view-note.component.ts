import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NoteDto } from 'src/app/model/notes';
import { NotesService } from 'src/app/services/notes.service';

@Component({
  selector: 'app-view-note',
  templateUrl: './view-note.component.html',
  styleUrls: ['./view-note.component.css'],
})
export class ViewNoteComponent implements OnInit {
  note: NoteDto | null = null;
  noteId!: number;
  content: string | null | undefined = null;
  constructor(
    private activatedRoute: ActivatedRoute,
    private notesService: NotesService,
  ) { }

  public ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((p) => {
      this.noteId = Number(p.get('noteId'));
    });
    this.note = this.notesService.getNote(this.noteId);
    this.content = this.note?.content;
  }
}
