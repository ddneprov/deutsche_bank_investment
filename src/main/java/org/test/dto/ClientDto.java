package org.test.dto;

import lombok.Builder;
import org.test.entity.Stock;

import java.util.List;


/**
 * То, что отдаем на фронт, клиент без пароля
 */
@Builder
public class ClientDto {
    private Integer id;
    private String username;
    private List<Stock> stockList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }
}
