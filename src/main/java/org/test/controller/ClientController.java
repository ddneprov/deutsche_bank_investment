package org.test.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.entity.Client;
import org.test.repository.ClientRepository;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientRepository clientRepository;


    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("/createClient")
    public void createClient(){
        Client client = new Client();
        client.setPassword("password");
        client.setUsername("username");
        clientRepository.save(client);
    }

}
