package com.diary.noteToSelf.services;

import com.diary.noteToSelf.domain.entities.Note;

public interface NotesService {
    public String createNote(Note note);

    public String updateNote(Note note);

    public String deleteNote(String noteId);
    public String deleteNote(Note note);
}
