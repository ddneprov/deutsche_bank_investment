package org.test.entity;

import javax.persistence.*;

@Entity
@Table(name = "stock_table")
public class Stock {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String ticket;
    private String currentCost;

    public Stock(){}

    public String getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(String currentCost) {
        this.currentCost = currentCost;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
