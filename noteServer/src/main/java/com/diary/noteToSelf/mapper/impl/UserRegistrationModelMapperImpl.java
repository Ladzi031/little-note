package com.diary.noteToSelf.mapper.impl;

import com.diary.noteToSelf.domain.dtos.RegisterDto;
import com.diary.noteToSelf.domain.entities.Person;
import com.diary.noteToSelf.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserRegistrationModelMapperImpl implements Mapper<Person, RegisterDto> {
    private final ModelMapper modelMapper;

    @Override
    public Person mapToEntity(RegisterDto dto) {
        return modelMapper.map(dto, Person.class);
    }

    @Override
    public RegisterDto mapToDto(Person entity) {
        RegisterDto registerDto = modelMapper.map(entity, RegisterDto.class);
        registerDto.setPassword(null);
        return registerDto;
    }
}
