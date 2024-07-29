package com.diary.noteToSelf.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long noteId;
    private String title;
	@Column(length = 6144)
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
}

