package com.diary.noteToSelf.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateUserDto {
    private Long id;
    private String newValue;
    private String attribute;
}
