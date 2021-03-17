package org.test.orchestration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import org.test.dto.ClientDto;
import org.test.dto.LoginDto;
import org.test.entity.Client;
import org.test.entity.Stock;
import org.test.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Slf4j
@Component
public class ClientOrchestration {

    @Autowired
    private ClientRepository clientRepository;

    public boolean isLoginCorrect(@RequestBody LoginDto loginDto){
        log.info(String.format("isLoginCorrect with username -> %s and password -> %s", loginDto.getUsername(),loginDto.getPassword()));
        Optional<Client> client = clientRepository.findByUsername(loginDto.getUsername());
        return client.map(value -> value.getPassword().equals(loginDto.getPassword())).orElse(false);
    }

    public ClientDto login(LoginDto loginDto){
        if(isLoginCorrect(loginDto)){
            Optional<Client> client = clientRepository.findByUsername(loginDto.getUsername());

            List<Stock> stockList = new ArrayList<>();
            Stock stockExample = new Stock();

            stockExample.setId(1);
            stockExample.setTicket("UAL");
            stockExample.setCurrentCost("100");
            stockList.add(stockExample);

            return ClientDto.builder()
                    .id(client.get().getId())
                    .stockList(stockList)
                    .username(client.get().getUsername()) // можно брать без проверки, тк уже уверены, что пользователь существует
                    .build();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }
}
