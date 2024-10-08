package org.arta.onemore.database.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.arta.onemore.database.entity.User;
import org.arta.onemore.dto.QPredicate;
import org.arta.onemore.dto.UserFilter;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.arta.onemore.database.entity.QUser.user;

@RequiredArgsConstructor
@Component
public class UserFilterRepositoryImpl implements UserFilterRepository{
    private final EntityManager entityManager;
    @Override
    public List<User> findAllByFilter(UserFilter userFilter) {
        Predicate predicate = QPredicate.builder()
                .add(userFilter.nickname(), user.nickname::containsIgnoreCase)
                .add(userFilter.lastname(), user.lastname::containsIgnoreCase)
                .add(userFilter.firstname(), user.firstname::containsIgnoreCase)
                .add(userFilter.email(), user.email::containsIgnoreCase)
                .buildAnd();
        return new JPAQuery<User>(entityManager)
                .select(user)
                .from(user)
                .where(predicate)
                .fetch();
    }
}
