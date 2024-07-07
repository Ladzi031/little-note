package com.diary.noteToSelf.controllers;

import com.diary.noteToSelf.domain.dtos.NoteDto;
import com.diary.noteToSelf.domain.dtos.PersonDto;
import com.diary.noteToSelf.domain.dtos.UpdateUserDto;
import com.diary.noteToSelf.domain.entities.Note;
import com.diary.noteToSelf.domain.entities.Person;
import com.diary.noteToSelf.mapper.Mapper;
import com.diary.noteToSelf.services.NotesService;
import com.diary.noteToSelf.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController()
public class UserController {

    private final UserService userService;
    private final NotesService notesService;
    private final Mapper<Person, PersonDto> personMapper;
    private final Mapper<Note, NoteDto> noteMapper;


    @GetMapping("/users")
    public String testUser() {
        return "user!";
    }
    @GetMapping("/users/{id}")
    public String getProfile(@PathVariable() String id) {
        // no account will have the same username
        return null;
    }

    @PutMapping("/users")
    public String updateDetails(UpdateUserDto updateUserDto) {
        return null;
    }

    @DeleteMapping("/users/{id}")
    public String deleteProfile(@PathVariable() String id) {
        return null;
    }

}
