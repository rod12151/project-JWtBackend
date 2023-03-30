package com.rodmeljwt.backend.mappers;

import com.rodmeljwt.backend.dto.SingUpDto;
import com.rodmeljwt.backend.dto.UserDto;
import com.rodmeljwt.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user );
    @Mapping(target = "password",ignore = true)
    User signUpToUser(SingUpDto userDto);
}
