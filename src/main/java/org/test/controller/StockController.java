package org.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.dto.StockDto;
import org.test.orchestration.StockOrchestration;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    @Autowired
    private StockOrchestration stockOrchestration;

    @PostMapping("/add")
    public void addNewStock(@RequestBody StockDto stock){
        stockOrchestration.addNewStock(stock);
    }
}
