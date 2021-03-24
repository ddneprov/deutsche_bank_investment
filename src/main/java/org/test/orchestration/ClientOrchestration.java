package org.test.orchestration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.test.dto.ClientDto;
import org.test.dto.LoginDto;
import org.test.dto.StockDto;
import org.test.entity.Client;
import org.test.entity.Stock;
import org.test.repository.ClientRepository;
import org.test.repository.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Сервисный слой клиента
 */
@Slf4j
@Component
public class ClientOrchestration {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private StockRepository stockRepository;

    /**
     * Авторизация нового пользователя
     * @param loginDto
     * @return возвращаем Dto - без пароля
     */
    public ClientDto login(LoginDto loginDto){
        log.info("Start login");
        if(isClientExistWithPassword(loginDto)){
            Optional<Client> client = clientRepository.findByUsername(loginDto.getUsername());

            String listStocks = client.get().getStocksIdNumbers();
            String stocksAmount = client.get().getStocksAmount();
            String[] stocksStr = listStocks.split(",");
            String[] stockAmountStr = stocksAmount.split(",");

            List<StockDto> stocks = new ArrayList<>();

            for(int i = 0; i < stocksStr.length; i++){
                Stock stock = stockRepository.findFirstById(Integer.valueOf(stocksStr[i]));
                stocks.add(StockDto.builder()
                        .fullName(stock.getFullName())
                        .currentCost(stock.getCurrentCost())
                        .ticket(stock.getTicket())
                        .stockCount(Integer.valueOf(stockAmountStr[i]))
                        .build());
            }


            return ClientDto.builder()
                    .id(client.get().getId())
                    .stockList(stocks)
                    .username(client.get().getUsername()) // можно брать без проверки, тк уже уверены, что пользователь существует
                    .build();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }

    /**
     * Регистрация нового пользователя
     * @param loginDto
     * @return возвращаем Dto - без пароля
     */
    public ClientDto register(LoginDto loginDto){
        if(!isClientExist(loginDto)){
            Client client = new Client();
            client.setUsername(loginDto.getUsername());
            client.setPassword(loginDto.getPassword());
            clientRepository.save(client);
            return getClientByUsername(client.getUsername());
        }
        else{
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Client already exist");
        }
    }







    /**------------------------------------------UTILS------------------------------------------------**/

    /**
     * Проверка существования клиента
     * @param loginDto
     * @return
     */
    private boolean isClientExist(LoginDto loginDto){
        log.info(String.format("isClientExist with username -> %s and password -> %s", loginDto.getUsername(),loginDto.getPassword()));
        Optional<Client> client = clientRepository.findByUsername(loginDto.getUsername());
        return client.isPresent();
    }

    /**
     * Проверка логина и пароля
     * @param loginDto
     * @return
     */
    private boolean isClientExistWithPassword(LoginDto loginDto){
        log.info(String.format("isClientExistWithPassword with username -> %s and password -> %s", loginDto.getUsername(),loginDto.getPassword()));
        Optional<Client> client = clientRepository.findByUsername(loginDto.getUsername());
        return client.map(value -> value.getPassword().equals(loginDto.getPassword())).orElse(false);
    }

    /**
     * Поиск клиента по имени
     * @param username
     * @return возвращаем Dto - без пароля
     */
    private ClientDto getClientByUsername(String username){
        Optional<Client> client = clientRepository.findByUsername(username);
        //конструируем dto объект
        if(client.isPresent()){
            return ClientDto.builder()
                    .id(client.get().getId())
                    .username(client.get().getUsername())
                    .build();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }
}
