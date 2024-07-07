package com.diary.noteToSelf.repositories;

import com.diary.noteToSelf.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {
}
