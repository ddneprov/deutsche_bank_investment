package org.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.test.dto.ClientDto;
import org.test.dto.LoginDto;
import org.test.entity.Client;
import org.test.orchestration.ClientOrchestration;
import org.test.repository.ClientRepository;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    @Autowired
    private  ClientRepository clientRepository;

    @Autowired
    private ClientOrchestration clientOrchestration;


    /**
     * Возвращаем объект клиента, если он есть
     * @param loginDto
     * @return
     */
    @GetMapping("/login")
    public ClientDto login(@RequestBody LoginDto loginDto){
        return clientOrchestration.login(loginDto);
    }

    @PostMapping("/registration")
    public void registrationClient(@RequestBody LoginDto loginDto){

    }
}
