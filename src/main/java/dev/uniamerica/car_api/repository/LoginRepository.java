package dev.uniamerica.car_api.repository;

import dev.uniamerica.car_api.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String login);

}
