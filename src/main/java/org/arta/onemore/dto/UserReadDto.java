package org.arta.onemore.dto;

import lombok.Builder;
import lombok.Value;
import org.arta.onemore.database.entity.Role;

import java.time.LocalDate;

@Builder
@Value
public class UserReadDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String nickname;
    private String email;
    private Role role;
    private LocalDate birthday;
    private Integer respect;
}
