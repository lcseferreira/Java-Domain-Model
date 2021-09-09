package com.lcseferreira.domain.repositories;

import com.lcseferreira.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
