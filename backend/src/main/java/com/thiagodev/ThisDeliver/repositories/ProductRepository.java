package com.thiagodev.ThisDeliver.repositories;

import com.thiagodev.ThisDeliver.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByNameAsc();
}


