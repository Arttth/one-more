package org.arta.onemore.service;

import org.arta.onemore.OneMoreApplication;
import org.arta.onemore.OneMoreApplicationTests;
import org.arta.onemore.database.entity.Role;
import org.arta.onemore.dto.UserCreateEditDto;
import org.arta.onemore.dto.UserReadDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SqlGroup(
        {
                @Sql(value = "classpath:/init/init-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
        }
)
@SpringBootTest(classes = {OneMoreApplication.class, OneMoreApplicationTests.class})
public class UserServiceIT {
    @Autowired
    private UserService userService;
    @Test
    void findById() {
        UserReadDto expectUser = UserReadDto.builder()
                .id(1)
                .firstname("Артур")
                .lastname("Абубакиров")
                .nickname("home12")
                .email("myemail@gmail.com")
                .role(Role.ADMIN)
                .birthday(LocalDate.of(2002, 11, 22))
                .respect(0)
                .build();
        UserReadDto user = userService.findById(1).get();
        assertNotNull(user);
        assertEquals(expectUser, user);
    }

    @Test
    void findAll() {
        List<UserReadDto> users = userService.findAll();
        assertEquals(users.size(), 5);
    }

    @Test
    void create() {
        UserReadDto expectUser = UserReadDto.builder()
                .id(1)
                .firstname("Test")
                .lastname("Testov")
                .nickname("test")
                .email("test@gmail.com")
                .role(Role.ADMIN)
                .birthday(LocalDate.of(2002, 11, 22))
                .respect(0)
                .build();

        UserCreateEditDto userCreateEditDto = UserCreateEditDto.builder()
                .firstname("Test")
                .lastname("Testov")
                .nickname("test")
                .email("test@gmail.com")
                .role(Role.ADMIN)
                .birthday(LocalDate.of(2002, 11, 22))
                .respect(0)
                .password("qwer")
                .build();

        System.out.println(userCreateEditDto);
        UserReadDto actual = userService.create(userCreateEditDto);

        assertEquals(expectUser.getFirstname(), actual.getFirstname());
        assertEquals(expectUser.getLastname(), actual.getLastname());
        assertEquals(expectUser.getNickname(), actual.getNickname());
        assertEquals(expectUser.getBirthday(), actual.getBirthday());
        assertEquals(expectUser.getRespect(), actual.getRespect());
        assertSame(expectUser.getRole(), actual.getRole());
    }


    @Test
    void delete() {
        assertTrue(userService.delete(2));
        assertFalse(userService.delete(-12));
    }

    @Test
    void update() {
        UserCreateEditDto userCreateEditDto = UserCreateEditDto.builder()
                .id(3)
                .firstname("Достоевский")
                .lastname("Федор")
                .nickname("dostoiniy")
                .email("net@mail.com")
                .password("0000")
                .role(Role.ADMIN)
                .birthday(LocalDate.of(2002, 11,1))
                .respect(0)
                .build();
        var userReadDto = userService.update(userCreateEditDto.getId(), userCreateEditDto);
        assertTrue(userReadDto.isPresent());
        userReadDto.ifPresent(user -> {
            assertEquals(userCreateEditDto.getFirstname(), user.getFirstname());
            assertEquals(userCreateEditDto.getLastname(), user.getLastname());
            assertEquals(userCreateEditDto.getNickname(), user.getNickname());
            assertEquals(userCreateEditDto.getBirthday(), user.getBirthday());
            assertEquals(userCreateEditDto.getRespect(), user.getRespect());
            assertSame(userCreateEditDto.getRole(), user.getRole());
        });
    }
}
