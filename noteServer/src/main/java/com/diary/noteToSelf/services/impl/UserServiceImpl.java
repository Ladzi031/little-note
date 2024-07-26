package com.diary.noteToSelf.services.impl;

import com.diary.noteToSelf.domain.entities.Person;
import com.diary.noteToSelf.repositories.UserRepository;
import com.diary.noteToSelf.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Person saveUser(Person person) {
        return userRepository.save(person);
    }

    @Override
    public Optional<Person> getUser(Long userId) {
        Optional<Person> p = userRepository.findById(userId);
        Optional<Person> x = userRepository.findById(userId);
        Object test = x.map(u -> u.getNotes().size()).orElse(null);
        return p;

    }

    @Override
    public void deleteUser(Long personId) {
        userRepository.deleteById(personId);
    }

    @Override
    public Boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Optional<Person> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
