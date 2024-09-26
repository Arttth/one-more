package org.arta.onemore.mapper;

import org.arta.onemore.database.entity.User;
import org.arta.onemore.dto.UserReadDto;
import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements  Mapper<User, UserReadDto> {
    @Override
    public UserReadDto map(User object) {
        return UserReadDto.builder()
                .id(object.getId())
                .firstname(object.getFirstname())
                .lastname(object.getLastname())
                .email(object.getEmail())
                .birthday(object.getBirthday())
                .nickname(object.getNickname())
                .role(object.getRole())
                .respect(object.getRespect())
                .build();
    }
}
