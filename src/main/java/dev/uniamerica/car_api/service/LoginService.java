package dev.uniamerica.car_api.service;

import dev.uniamerica.car_api.config.JwtServiceGenerator;
import dev.uniamerica.car_api.model.dtos.Login;
import dev.uniamerica.car_api.model.entities.Usuario;
import dev.uniamerica.car_api.repository.LoginRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtServiceGenerator jwtService;

    public LoginService(LoginRepository loginRepository, AuthenticationManager authenticationManager,
                        JwtServiceGenerator jwtService) {
        this.loginRepository = loginRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    public String logar(Login login) {

        String token = this.gerarToken(login);
        return token;

    }

    public String gerarToken(Login login) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.username(),
                        login.password()
                )
        );
        Usuario user = loginRepository.findByUsername(login.username()).get();
        String jwtToken = jwtService.generateToken(user);
        return jwtToken;
    }
}
