package com.diary.noteToSelf.controllers;

import com.diary.noteToSelf.domain.dtos.LoginDto;
import com.diary.noteToSelf.domain.dtos.PersonDto;
import com.diary.noteToSelf.domain.dtos.RegisterDto;
import com.diary.noteToSelf.domain.entities.Person;
import com.diary.noteToSelf.mapper.Mapper;
import com.diary.noteToSelf.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
@Log
@RequiredArgsConstructor
@RestController()
@RequestMapping("/authentication")
public class AuthController {

    private final UserService userService;
    private final Mapper<Person, RegisterDto> registrationMapper;
    private final Mapper<Person, PersonDto> personMapper;

    @GetMapping()
    public String testAuth() {
        return "up and running!";
    }

    @PostMapping("/register")
    public ResponseEntity<?> createProfile(@RequestBody RegisterDto personDto) {
        if (!userService.userExists(personDto.getUsername())) {
            Person personEntity = registrationMapper.mapToEntity(personDto);
            Person personSaved = userService.saveUser(personEntity);
            return new ResponseEntity<>(personMapper.mapToDto(personSaved), HttpStatus.CREATED);
            // mapper will not return any sensitive data back to the user
        } else {
            return new ResponseEntity<>("Username already Exists", HttpStatus.CONFLICT);
        }
    }


    /*
      I know that we don't do things like this.
      this project isn't heavily focused on spring-security...
     */
    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody LoginDto loginDto) {
        Optional<Person> userOptional = userService.findByUsername(loginDto.getUsername());
        return userOptional.map(u -> {
            if (Objects.equals(u.getPassword(), loginDto.getPassword())) {
                loginDto.setIsLoggedIn(true);
                loginDto.setId(u.getId());
            } else {
                loginDto.setIsLoggedIn(false);
            }
            loginDto.setPassword(null);
            return new ResponseEntity<>(loginDto, HttpStatus.OK);

        }).orElse(ResponseEntity.notFound().build());
    }


    /*
     TODO LATER:
     -> add correct Authentication/Authorization
     -> implement refresh token
        @PostMapping(path = "/refresh-me")
        public String refreshAuthToken() {
            return null;
        }
     */
}
