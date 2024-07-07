package com.diary.noteToSelf.controllers;

import com.diary.noteToSelf.domain.dtos.NoteDto;
import com.diary.noteToSelf.domain.dtos.PersonDto;
import com.diary.noteToSelf.domain.entities.Note;
import com.diary.noteToSelf.domain.entities.Person;
import com.diary.noteToSelf.mapper.Mapper;
import com.diary.noteToSelf.services.NotesService;
import com.diary.noteToSelf.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController()
public class NoteController {


    private final UserService userService;
    private final NotesService notesService;
    private final Mapper<Person, PersonDto> personMapper;
    private final Mapper<Note, NoteDto> noteMapper;

    @GetMapping("/notes")
    public String testNotes() {
        return "noted!";
    }
    @GetMapping("/notes/{userId}")
    public String getAllNotes(@PathVariable String userId) {
        // get by personService;
        return null;
    }

    @PostMapping("/notes")
    public String createNotes(NoteDto noteDto) {
        // personService or noteService will see
        return null;
    }

    @PutMapping("/notes")
    public String updateNote(NoteDto noteDto) {
        // same here i can update via the personService or the noteService, will decide...
        return null;
    }

    @DeleteMapping("/notes/{userId}/{id}")
    public String deleteNote(@PathVariable("userId") String userId, @PathVariable String id) {
        // same story here
        return null;
    }
}
