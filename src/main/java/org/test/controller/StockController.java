package org.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.orchestration.StockOrchestration;
import org.test.repository.StockRepository;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    @Autowired
    private StockOrchestration stockOrchestration;


    //TODO
}
