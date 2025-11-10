package dev.uniamerica.car_api.service;

import dev.uniamerica.car_api.model.dtos.UsuarioResponse;
import dev.uniamerica.car_api.model.entities.Usuario;
import dev.uniamerica.car_api.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {

    private final LoginRepository repository;

    public UsuariosService(LoginRepository repository) {
        this.repository = repository;
    }


    public List<UsuarioResponse> findAll() {
     return repository.findAll()
             .stream()
             .map(Usuario::toResponse)
             .toList();
    }
}
