package com.thiagodev.ThisDeliver.repositories;

import com.thiagodev.ThisDeliver.entities.Order;
import com.thiagodev.ThisDeliver.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
