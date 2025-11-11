package dev.uniamerica.car_api.service;

import dev.uniamerica.car_api.model.dtos.UsuarioRequest;
import dev.uniamerica.car_api.model.dtos.UsuarioResponse;
import dev.uniamerica.car_api.model.entities.Usuario;
import dev.uniamerica.car_api.repository.LoginRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    private final LoginRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuariosService(LoginRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<UsuarioResponse> findAll() {
     return repository.findAll()
             .stream()
             .map(Usuario::toResponse)
             .toList();
    }

    public UsuarioResponse createUsuario(UsuarioRequest usuario) {
        Optional<Usuario> usuarioDB = repository.findByUsername(usuario.username());

        if (usuarioDB.isPresent()) {
            throw new IllegalArgumentException("Usuario ja cadastrado");
        }

        Usuario novoUsuario = usuario.toEntity();

        novoUsuario.setPassword(passwordEncoder.encode(usuario.password()));

        return repository.save(novoUsuario)
                .toResponse();

    }

    public UsuarioResponse findById(Long id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new)
                .toResponse();
    }
}
