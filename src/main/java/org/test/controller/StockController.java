package org.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.test.dto.NewStockDto;
import org.test.entity.Stock;
import org.test.orchestration.StockOrchestration;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    @Autowired
    private StockOrchestration stockOrchestration;

    @PostMapping("/add")
    public void addNewStock(@RequestBody NewStockDto stock){
        stockOrchestration.addNewStock(stock);
    }

    @PostMapping("/addToUser")
    public void addToUser(Integer userId, Integer stockId, Integer amount){
        stockOrchestration.addToUser(userId, stockId, amount);
    }

    @GetMapping("/getAll")
    public List<Stock> getAllStocks(){
        return stockOrchestration.getAllStocks();
    }
}
