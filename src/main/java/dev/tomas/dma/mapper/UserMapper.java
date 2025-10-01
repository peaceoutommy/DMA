package dev.tomas.dma.mapper;

import dev.tomas.dma.model.User;
import dev.tomas.dma.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity convertToModel(User user);
    User convertToModel(UserEntity userEntity);
}