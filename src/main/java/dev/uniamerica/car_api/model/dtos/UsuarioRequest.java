package dev.uniamerica.car_api.model.dtos;

import dev.uniamerica.car_api.model.entities.Usuario;

public record UsuarioRequest(String username, String password, String email, String role) {
 public Usuario toEntity() {
     var usuario = new Usuario();
     usuario.setUsername(username);
     usuario.setEmail(email);
     usuario.setRole("ROLE_"+ role);

     return usuario;
 }
}
