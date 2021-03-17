package org.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.test.dto.ClientDto;
import org.test.dto.LoginDto;
import org.test.orchestration.ClientOrchestration;
import org.test.repository.ClientRepository;


@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    @Autowired
    private ClientOrchestration clientOrchestration;

    /**
     * Возвращаем dto объект клиента, если он есть
     * @param loginDto
     * @return
     */
    @GetMapping("/login")
    public ClientDto login(@RequestBody LoginDto loginDto){
        return clientOrchestration.login(loginDto);
    }

    /**
     * Возвращаем dto объект клиента, если пользователь уже не зарегестирован
     * @param loginDto
     * @return
     */
    @PostMapping("/registration")
    public ClientDto registrationClient(@RequestBody LoginDto loginDto){
        return clientOrchestration.register(loginDto);
    }
}
