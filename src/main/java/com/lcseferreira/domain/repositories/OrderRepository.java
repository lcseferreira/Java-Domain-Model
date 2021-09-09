package com.lcseferreira.domain.repositories;

import com.lcseferreira.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
