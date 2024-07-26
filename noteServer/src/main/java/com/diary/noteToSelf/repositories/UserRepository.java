package com.diary.noteToSelf.repositories;

import com.diary.noteToSelf.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {
    public Boolean existsByUsername(String username);

    public Optional<Person> findByUsername(String username);
}
