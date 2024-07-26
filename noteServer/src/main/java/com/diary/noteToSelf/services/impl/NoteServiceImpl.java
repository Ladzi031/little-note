package com.diary.noteToSelf.services.impl;

import com.diary.noteToSelf.domain.entities.Note;
import com.diary.noteToSelf.repositories.NotesRepository;
import com.diary.noteToSelf.services.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NotesService {

    private final NotesRepository notesRepository;

    @Override
    public Note saveNote(Note note) {
        return notesRepository.save(note);
    }


    @Override
    public void deleteNote(Long noteId) {
        notesRepository.deleteById(noteId);
    }

    @Override
    public Boolean noteExists(Long noteId) {
        return notesRepository.existsById(noteId);


        /*
            found some articles on the internet that discourage using this method:'existsById()'
                because as being too "Computationally Expensive"
            when profiled, I found it to be true as well, but this is just a pet-project of mine just learning stuff along the way :)
            so use with caution in serious applications!.
        */

    }

}
