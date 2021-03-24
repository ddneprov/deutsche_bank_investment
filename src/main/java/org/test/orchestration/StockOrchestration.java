package org.test.orchestration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.dto.NewStockDto;
import org.test.entity.Client;
import org.test.entity.Stock;
import org.test.repository.ClientRepository;
import org.test.repository.StockRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Сервисный слой акций
 */
@Slf4j
@Component
public class StockOrchestration {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ClientRepository clientRepository;

    public void addNewStock(NewStockDto stock){
        Stock newStock = new Stock();
        newStock.setTicket(stock.getTicket());
        newStock.setCurrentCost(stock.getCurrentCost());
        newStock.setFullName(stock.getFullName());
        stockRepository.save(newStock);
    }

    /**
     * добавить новую акцию в портфель/увеличить количество существующих акций
     * @param userId
     * @param stockId
     * @return
     */
    public void addToUser(Integer userId, Integer stockId, Integer amount){
        Optional<Client> client = clientRepository.findFirstById(userId);
        String[] stocksStr = client.get().getStocksIdNumbers().split(",");
        if(!isExist(userId, stockId)) {
            client.get().setStocksIdNumbers(client.get().getStocksIdNumbers() + "," + stockId.toString());
            client.get().setStocksAmount(client.get().getStocksAmount() + "," + amount.toString());
            clientRepository.save(client.get());
        } else {
            String[] amounts = client.get().getStocksAmount().split(",");
            for(int i = 0; i < stocksStr.length; i++){
                if(stockId.equals(Integer.valueOf(stocksStr[i]))){
                    int updateAmount = Integer.parseInt(amounts[i]) + amount;
                    amounts[i] = Integer.toString(updateAmount);
                    StringBuilder srt = new StringBuilder();
                    for(int j = 0; j < amounts.length; j++){
                        srt.append(amounts[j]);
                        if((j+1) != amounts.length){
                            srt.append(",");
                        }
                    }
                    client.get().setStocksAmount(srt.toString());
                    clientRepository.save(client.get());
                }
            }
        }
    }

    /**
     * есть ли акция у пользователя в портфеле
     * @param userId
     * @param stockId
     * @return
     */
    private boolean isExist(Integer userId, Integer stockId) {
        Optional<Client> client = clientRepository.findFirstById(userId);
        String[] stocksStr = client.get().getStocksIdNumbers().split(",");
        for (int i = 0; i < stocksStr.length; i++) {  // если акция уже есть в портфеле
            if (stockId.equals(Integer.valueOf(stocksStr[i]))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Получить все акции
     * @return
     */
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }
}
