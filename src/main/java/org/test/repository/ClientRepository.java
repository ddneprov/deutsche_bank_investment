package org.test.repository;

import org.springframework.stereotype.Repository;
import org.test.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByUsername(String username);
    Optional<Client> findFirstById(Integer id);
}
