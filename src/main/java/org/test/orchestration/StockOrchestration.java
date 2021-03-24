package org.test.orchestration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.dto.NewStockDto;
import org.test.entity.Stock;
import org.test.repository.StockRepository;

/**
 * Сервисный слой акций
 */
@Slf4j
@Component
public class StockOrchestration {

    @Autowired
    private StockRepository stockRepository;

    public void addNewStock(NewStockDto stock){
        Stock newStock = new Stock();
        newStock.setTicket(stock.getTicket());
        newStock.setCurrentCost(stock.getCurrentCost());
        newStock.setFullName(stock.getFullName());
        stockRepository.save(newStock);
    }
}
