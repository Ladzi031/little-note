package com.diary.noteToSelf.utils.users;

import com.diary.noteToSelf.domain.entities.Note;
import com.diary.noteToSelf.domain.entities.Person;
import com.diary.noteToSelf.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class Users {
    private final UserRepository userRepository;
    @PostConstruct
    public void generateUsersAndNotes() {
        List<Note> notesPerson1 = generateNotesForPerson1();
        Person person1 = Person.builder()
                .name("Ladzani")
                .username("ladzi")
                .password("1234")
                .email("ladzi@gmail.com")
                .notes(notesPerson1)
                .build();
        List<Note> notesPerson2 = generateNotesForPerson2();
        Person person2 = Person.builder()
                .name("Fabian")
                .username("farooq")
                .password("1234")
                .email("fabian@gmail.com")
                .notes(notesPerson2)
                .build();
        userRepository.save(person1);
        userRepository.save(person2);

    }

    public List<Note> generateNotesForPerson1() {
        Note note1 = Note.builder()
                .title("You viewing this in the front-end")
                .content("This is the text you saved earlier on, remember?\n keep practicing your angular front-end skills")
                .creationDate(new Date())
                .build();
        Note note2 = Note.builder()
                .title("Generated from the back-end for the Front-end!")
                .content("Learning Angular is fun\n keep practicing your angular front-end skills")
                .creationDate(new Date())
                .build();
        Note note3 = Note.builder()
                .title("slick user-interface!")
                .content("Building an aesthetic UI requires A lot of skills\n keep practicing your angular front-end skills")
                .creationDate(new Date())
                .build();
        Note note4 = Note.builder()
                .title("Code-Dojo ?")
                .content("you very own coding-dojo? hmmm, I like the sound of that\n keep practicing your angular front-end skills")
                .creationDate(new Date())
                .build();
        Note note5 = Note.builder()
                .title("honing your skills")
                .content("Honing your skills requires time and effort\n this should be the longest text of them all to see how it behaves in the front-end buddy, so keep typing away to get the longest text of them all!\nkeep practicing your angular front-end skills")
                .creationDate(new Date())
                .build();
        List<Note> person1Notes = new ArrayList<>();
        person1Notes.add(note1);
        person1Notes.add(note2);
        person1Notes.add(note3);
        person1Notes.add(note4);
        person1Notes.add(note5);
        return person1Notes;
    }
    public List<Note> generateNotesForPerson2() {
        Note note1 = Note.builder()
                .title("You viewing this in the front-end")
                .content("This is the text you saved earlier on, remember?\n keep practicing your angular front-end skills")
                .creationDate(new Date())
                .build();
        Note note2 = Note.builder()
                .title("Generated from the back-end for the Front-end!")
                .content("Learning Angular is fun\n keep practicing your angular front-end skills")
                .creationDate(new Date())
                .build();
        Note note5 = Note.builder()
                .title("honing your skills")
                .content("Honing your skills requires time and effort\n this should be the longest text of them all to see how it behaves in the front-end buddy, so keep typing away to get the longest text of them all!\nkeep practicing your angular front-end skills")
                .creationDate(new Date())
                .build();
        List<Note> person1Notes = new ArrayList<>();
        person1Notes.add(note1);
        person1Notes.add(note2);
        person1Notes.add(note5);
        return person1Notes;
    }
}
