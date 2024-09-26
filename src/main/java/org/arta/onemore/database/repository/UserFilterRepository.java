package org.arta.onemore.database.repository;

import org.arta.onemore.database.entity.User;
import org.arta.onemore.dto.UserFilter;

import java.util.List;

public interface UserFilterRepository {
    List<User> findAllByFilter(UserFilter userFilter);
}
