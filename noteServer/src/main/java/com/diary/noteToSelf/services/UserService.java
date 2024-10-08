package com.diary.noteToSelf.services;

import com.diary.noteToSelf.domain.entities.Person;

import java.util.Optional;

public interface UserService {

    public Person saveUser(Person person);


    public Optional<Person> getUser(Long userId);


    public void deleteUser(Long userId);

    public Boolean userExists(String username);

    public Optional<Person> findByUsername(String username);


}
