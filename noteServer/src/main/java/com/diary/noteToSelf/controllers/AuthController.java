package com.diary.noteToSelf.controllers;

import com.diary.noteToSelf.domain.dtos.LoginDto;
import com.diary.noteToSelf.domain.dtos.PersonDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AuthController {

    @GetMapping("/authentication")
    public String testAuth() {
        return "we up, son!";
    }

    @PostMapping("/authentication/register")
    public String register(@RequestBody PersonDto registrationDto) {
        return null;
    }

    @PostMapping("/authentication/login")
    public String login(@RequestBody LoginDto loginDto) {
        return null;
    }

    /*
     TODO LATER:
     -> implement refresh token
        @PostMapping(path = "/refresh-me")
        public String refreshAuthToken() {
            return null;
        }
       */

}
