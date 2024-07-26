package com.diary.noteToSelf.services;

import com.diary.noteToSelf.domain.entities.Note;

public interface NotesService {
    public Note saveNote(Note note);

    public void deleteNote(Long noteId);

    public Boolean noteExists(Long noteId);

}
