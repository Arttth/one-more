package org.arta.onemore.dto;

import lombok.Builder;
import lombok.Value;
import org.arta.onemore.database.entity.Role;

import java.time.LocalDate;

@Builder
@Value
public class UserCreateEditDto {
    Integer id;
    String firstname;
    String lastname;
    String nickname;
    String email;
    String password;
    Role role;
    LocalDate birthday;
    Integer respect;
}
