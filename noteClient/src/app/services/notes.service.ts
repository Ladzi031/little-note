import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NoteDto } from '../model/notes';
import { NOTES_URL } from '../config/api';
import { catchError, map, Observable, Subject, tap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class NotesService {
  images: string[] = [
    '../../../assets/images/book.png',
    '../../../assets/images/pen.png',
  ];
  private listOfNotes: NoteDto[] = [];
  note!: NoteDto;
  constructor(private http: HttpClient) { }

  public getNote(noteId: number): NoteDto {
    return this.listOfNotes.filter((n) => n.noteId == noteId)[0];
  }

  public addNote(note: NoteDto): Observable<NoteDto> {
    const payload = {
      userId: note.userId,
      title: note.title,
      content: note.content,
    };
    return this.http.post<NoteDto>(NOTES_URL, payload).pipe(
      catchError((err) => {
        return throwError(() => err);
      }),
    );
  }
  public getAllNotes(id: number): Observable<NoteDto[]> {
    return this.http.get<NoteDto[]>(`${NOTES_URL}/${id}`).pipe(
      tap((n) => {
        n.forEach((n) => {
          n.image = this.images[Math.floor(Math.random() * 2)];
        });
        this.listOfNotes = n;
      }),
      catchError((err) => {
        return throwError(() => err);
      }),
    );
  }

  public deleteNote(id: number, noteId: number) {
    return this.http.delete(`${NOTES_URL}/${id}/${noteId}`).pipe(
      catchError((err) => {
        return throwError(() => err);
      }),
    );
  }
}
