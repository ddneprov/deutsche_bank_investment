package org.test.entity;


import javax.persistence.*;

@Entity
@Table(name = "client_table")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String stocksIdNumbers;
    private String stocksAmount;

    public Client(Client client){
        this.username = client.getUsername();
        this.password = client.getPassword();
    }

    public Client(){}

    public String getStocksIdNumbers() {
        return stocksIdNumbers;
    }

    public void setStocksIdNumbers(String stocksIdNumbers) {
        this.stocksIdNumbers = stocksIdNumbers;
    }

    public String getStocksAmount() {
        return stocksAmount;
    }

    public void setStocksAmount(String stocksAmount) {
        this.stocksAmount = stocksAmount;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
