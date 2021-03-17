package org.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findFirstById(Integer id);
    Stock findFirstByTicket(String ticket);
}
