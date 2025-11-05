package dev.uniamerica.car_api.config;

import dev.uniamerica.car_api.model.entities.Usuario;
import dev.uniamerica.car_api.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadUser {

    private static final Logger LOG = LoggerFactory.getLogger(LoadUser.class);

    @Bean
    CommandLineRunner commandLineRunner(LoginRepository loginRepository) {
        return args -> {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword("$2a$12$BsWHaBszyWe9mvhbgAuh1uyq5j7b1FhJlJ/VTGqvfyUL2wY3uTgDq");
            admin.setRole("ADMIN");

            LOG.info("Criando usuario admin");

            loginRepository.save(admin);
        };
    }
}
