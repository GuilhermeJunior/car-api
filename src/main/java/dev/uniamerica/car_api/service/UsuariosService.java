package dev.uniamerica.car_api.service;

import dev.uniamerica.car_api.model.dtos.UsuarioRequest;
import dev.uniamerica.car_api.model.dtos.UsuarioResponse;
import dev.uniamerica.car_api.model.entities.Usuario;
import dev.uniamerica.car_api.repository.LoginRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {

    private final LoginRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuariosService(LoginRepository repository,
                           PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<UsuarioResponse> findAll() {
     return repository.findAll()
             .stream()
             .map(Usuario::toResponse)
             .toList();
    }

    public UsuarioResponse findById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new)
                .toResponse();
    }

    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        var usuarioDB = repository.findByUsername(usuarioRequest.username());
        if (usuarioDB.isPresent()) {
            throw new IllegalArgumentException("Usuario ja existe");
        }

        var usuario = usuarioRequest.toEntity();
        var senha = passwordEncoder.encode(usuarioRequest.password());
        usuario.setPassword(senha);

        return repository.save(usuario).toResponse();
    }
}
