package com.thiagodev.ThisDeliver.services;

import com.thiagodev.ThisDeliver.dto.OrderDTO;
import com.thiagodev.ThisDeliver.entities.Order;
import com.thiagodev.ThisDeliver.repositories.OrderRepository;
import com.thiagodev.ThisDeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;


    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = repository.findOrderWithProducts();

        return list.stream().map(OrderDTO::new).collect(Collectors.toList());

    }
}
