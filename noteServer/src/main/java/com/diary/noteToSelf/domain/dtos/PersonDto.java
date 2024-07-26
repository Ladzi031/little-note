package com.diary.noteToSelf.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonDto {
    private Long id;
    private String username;
    private String name;
    private String email;
    private String password;
    private List<NoteDto> notes;
}
