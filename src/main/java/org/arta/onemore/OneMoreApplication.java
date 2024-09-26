package org.arta.onemore;

import org.arta.onemore.database.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OneMoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneMoreApplication.class, args);
    }

}
