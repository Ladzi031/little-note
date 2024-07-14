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
        return userRepository.findById(userId);

    }
    @Override
    public void deleteUser(Long personId) {
        userRepository.deleteById(personId);
    }
}
