package dev.uniamerica.car_api.controller;

import dev.uniamerica.car_api.model.dtos.Login;
import dev.uniamerica.car_api.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@CrossOrigin("*")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping
    public ResponseEntity<String> logar(@RequestBody Login login) {
        String token = loginService.logar(login);
        return new ResponseEntity<>(token, HttpStatus.OK);

    }


}
