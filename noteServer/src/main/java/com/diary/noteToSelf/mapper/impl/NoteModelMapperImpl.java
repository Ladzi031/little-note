package com.diary.noteToSelf.mapper.impl;

import com.diary.noteToSelf.domain.dtos.NoteDto;
import com.diary.noteToSelf.domain.entities.Note;
import com.diary.noteToSelf.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NoteModelMapperImpl implements Mapper<Note, NoteDto> {
    private final ModelMapper modelMapper;

    public NoteModelMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Note mapToEntity(NoteDto dto) {
        return modelMapper.map(dto, Note.class);
    }

    @Override
    public NoteDto mapToDto(Note entity) {
        return modelMapper.map(entity, NoteDto.class);
    }
}
