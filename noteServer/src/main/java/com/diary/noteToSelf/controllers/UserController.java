package com.diary.noteToSelf.controllers;

import com.diary.noteToSelf.domain.dtos.PersonDto;
import com.diary.noteToSelf.domain.dtos.UpdateUserDto;
import com.diary.noteToSelf.domain.entities.Person;
import com.diary.noteToSelf.mapper.Mapper;
import com.diary.noteToSelf.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final Mapper<Person, PersonDto> personMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getProfile(@PathVariable() Long id) {
        Optional<Person> person = userService.getUser(id);
        return person.map(value -> {
                    PersonDto personDto = personMapper.mapToDto(value);
                    return new ResponseEntity<>(personDto, HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<PersonDto> updateDetails(@RequestBody UpdateUserDto userDto) {
        Optional<Person> person = userService.getUser(userDto.getId());
        return person.map(p -> {
					if ("Name".equals(userDto.getAttribute())) {
                        p.setName(userDto.getNewValue());
                    } else if ("Email".equals(userDto.getAttribute())) {
                        p.setEmail(userDto.getNewValue());
                    }
                    Person updatedPerson = userService.saveUser(p);
                    return new ResponseEntity<>(personMapper.mapToDto(updatedPerson), HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
