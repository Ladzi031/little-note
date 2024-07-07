package com.diary.noteToSelf.services;

import com.diary.noteToSelf.domain.entities.Note;
import com.diary.noteToSelf.domain.entities.Person;

public interface UserService {

    public String createUser(Person person);


    public String getUser(String userId);

    public String updateUser(Person person);

    public String deleteUser(Person person);

    public String deleteUser(Long personId);

}
