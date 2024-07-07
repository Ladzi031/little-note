package com.diary.noteToSelf.mapper;

/**
 * A generic model-mapper for all entities...
 */
public interface Mapper<E,D> {
    E mapToEntity(D dto);
    D mapToDto(E entity);
}
