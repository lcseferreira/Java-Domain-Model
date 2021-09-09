package com.lcseferreira.domain.repositories;

import com.lcseferreira.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
