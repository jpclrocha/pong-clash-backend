package com.jopezin.pongclash.config;

import com.jopezin.pongclash.domain.user.User;
import com.jopezin.pongclash.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.UUID;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(UUID.randomUUID(),
                           "Joao Pedro",
                           "de Castro Laranjeira Rocha",
                           "jpclrocha@gmail.com",
                           "senha123");

        User u2 = new User(UUID.randomUUID(),
                           "JoPe",
                           null,
                           "jope@gmail.com",
                           "senha123");

        userRepository.save(u1);
    }
}
