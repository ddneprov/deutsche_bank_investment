package org.test.repository;

import org.test.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByUsername(String username);
    Client findFirstById(Integer id);
}
