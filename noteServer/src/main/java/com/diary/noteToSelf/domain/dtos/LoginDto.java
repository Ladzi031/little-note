package com.diary.noteToSelf.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginDto {
    private Long id;
    private String username;
    private String password;
    private Boolean isLoggedIn = false; // things should not be done like this
}
