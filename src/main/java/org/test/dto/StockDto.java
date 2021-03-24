package org.test.dto;

import lombok.Builder;

@Builder
public class StockDto {
    private String ticket;
    private String currentCost;
    private String fullName;
    private Integer stockCount;

    public String getTicket() {
        return ticket;
    }

    public String getCurrentCost() {
        return currentCost;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getStockCount() {
        return stockCount;
    }
}
