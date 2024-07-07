package com.diary.noteToSelf.repositories;

import com.diary.noteToSelf.domain.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {
}
