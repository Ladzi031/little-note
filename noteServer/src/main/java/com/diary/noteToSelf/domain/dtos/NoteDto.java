package com.diary.noteToSelf.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NoteDto {
    private Long userId;
    private Long noteId;
    private String title;
    private String content;
    private Date creationDate = new Date();
    private Date lastModified;
}
