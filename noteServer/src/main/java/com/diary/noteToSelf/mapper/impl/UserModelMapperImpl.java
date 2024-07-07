package com.diary.noteToSelf.mapper.impl;
import com.diary.noteToSelf.domain.dtos.PersonDto;
import com.diary.noteToSelf.domain.entities.Person;
import com.diary.noteToSelf.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapperImpl implements Mapper<Person, PersonDto> {
    private final ModelMapper modelMapper;

    public UserModelMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Person mapToEntity(PersonDto dto) {
        return modelMapper.map(dto, Person.class);
    }

    @Override
    public PersonDto mapToDto(Person entity) {
        return modelMapper.map(entity, PersonDto.class);
    }
}
