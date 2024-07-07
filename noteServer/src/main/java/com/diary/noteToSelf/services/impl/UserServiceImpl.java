package com.diary.noteToSelf.services.impl;

import com.diary.noteToSelf.domain.entities.Person;
import com.diary.noteToSelf.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String createUser(Person person) {
        return null;
    }

    @Override
    public String getUser(String userId) {
        return null;
    }

    @Override
    public String updateUser(Person person) {
        return null;
    }

    @Override
    public String deleteUser(Person person) {
        return null;
    }

    @Override
    public String deleteUser(Long personId) {
        return null;
    }
}
