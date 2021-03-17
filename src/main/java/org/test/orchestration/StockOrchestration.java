package org.test.orchestration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.repository.StockRepository;

/**
 * Сервисный слой акций
 */
@Slf4j
@Component
public class StockOrchestration {

    @Autowired
    private StockRepository stockRepository;

    //TODO
}
