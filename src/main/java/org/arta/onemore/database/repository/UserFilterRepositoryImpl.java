package org.arta.onemore.database.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.arta.onemore.database.entity.User;
import org.arta.onemore.dto.QPredicate;
import org.arta.onemore.dto.UserFilter;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.arta.onemore.database.entity.QUser.user;

@AllArgsConstructor
@Component
public class UserFilterRepositoryImpl implements UserFilterRepository{
    private EntityManager entityManager;
    @Override
    public List<User> findAllByFilter(UserFilter filter) {
        Predicate predicate = QPredicate.builder()
                .add(filter.firstname(), user.firstname::containsIgnoreCase)
                .add(filter.lastname(), user.lastname::containsIgnoreCase)
                .add(filter.nickname(), user.nickname::containsIgnoreCase)
                .add(filter.respect(), user.respect::goe)
                .buildAnd();

        return new JPAQuery<User>(entityManager)
                .select(user)
                .from(user)
                .where(predicate)
                .fetch();
    }
}
