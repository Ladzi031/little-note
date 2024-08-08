package com.diary.noteToSelf.controllers;

import com.diary.noteToSelf.domain.dtos.NoteDto;
import com.diary.noteToSelf.domain.dtos.UpdateNoteDto;
import com.diary.noteToSelf.domain.entities.Note;
import com.diary.noteToSelf.domain.entities.Person;
import com.diary.noteToSelf.mapper.Mapper;
import com.diary.noteToSelf.services.NotesService;
import com.diary.noteToSelf.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/notes")
public class NoteController {

    private final UserService userService;
    private final Mapper<Note, NoteDto> noteMapper;
    private final NotesService notesService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<NoteDto>> getAllNotes(@PathVariable Long userId) {
        List<NoteDto> listOfNotes = new ArrayList<>();
        Optional<Person> user = userService.getUser(userId);
        return user.map(u -> {
            u.getNotes().forEach(n -> listOfNotes.add(noteMapper.mapToDto(n)));
            return new ResponseEntity<>(listOfNotes, HttpStatus.OK);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NoteDto> createNotes(@RequestBody NoteDto noteDto) {
        Optional<Person> user = userService.getUser(noteDto.getUserId());
        return user.map(u -> {
            List<Note> userNotes = u.getNotes();
            userNotes.add(noteMapper.mapToEntity(noteDto));
            u.setNotes(userNotes);
            userService.saveUser(u);
            return new ResponseEntity<>(noteDto, HttpStatus.CREATED);
        }).orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping
    public ResponseEntity<UpdateNoteDto> updateNote(@RequestBody UpdateNoteDto noteDto) {
        Optional<Person> user = userService.getUser(noteDto.getUserId());
        return user.map(u -> {
            Optional<Note> noteOptional = u.getNotes().stream()
                    .filter(n -> n.getNoteId() == noteDto.getNoteId()).findFirst();
            return noteOptional.map(n -> {
                n.setTitle(noteDto.getTitle());
                n.setContent(noteDto.getContent());
                n.setLastModified(noteDto.getLastModified());
                userService.saveUser(u);
                return new ResponseEntity<>(noteDto, HttpStatus.OK);
            }).orElse(ResponseEntity.notFound().build());
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{userId}/{noteId}")
    public ResponseEntity<?> deleteNote(@PathVariable Long userId, @PathVariable Long noteId) {
		Optional<Person> user = userService.getUser(userId);
		return user.map(u -> {
            Optional<Note> note = u.getNotes().stream().filter(n -> Objects.equals(n.getNoteId(), noteId)).findFirst();
            note.ifPresent(value -> u.getNotes().remove(value));
            userService.saveUser(u);
            return ResponseEntity.noContent().build();
		}
		).orElse(ResponseEntity.notFound().build());
        
    }
}
