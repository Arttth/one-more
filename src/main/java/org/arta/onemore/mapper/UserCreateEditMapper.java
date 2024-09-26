package org.arta.onemore.mapper;

import org.arta.onemore.database.entity.User;
import org.arta.onemore.dto.UserCreateEditDto;
import org.springframework.stereotype.Component;

@Component
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User>{
    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        getUser(object, user);
        return user;
    }

    private User getUser(UserCreateEditDto object, User entity) {
        entity.setFirstname(object.getFirstname());
        entity.setLastname(object.getLastname());
        entity.setNickname(object.getNickname());
        entity.setEmail(object.getEmail());
        entity.setRespect(object.getRespect());
        entity.setBirthday(object.getBirthday());
        if (object.getPassword() != null)
            entity.setPassword(object.getPassword());
        entity.setRole(object.getRole());
        return entity;
    }

    @Override
    public User map(UserCreateEditDto user, User entity) {
        return getUser(user, entity);
    }
}
