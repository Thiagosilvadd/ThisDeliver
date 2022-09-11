package com.thiagodev.ThisDeliver.services;

import com.thiagodev.ThisDeliver.dto.OrderDTO;
import com.thiagodev.ThisDeliver.dto.ProductDTO;
import com.thiagodev.ThisDeliver.entities.Order;
import com.thiagodev.ThisDeliver.entities.OrderStatus;
import com.thiagodev.ThisDeliver.entities.Product;
import com.thiagodev.ThisDeliver.repositories.OrderRepository;
import com.thiagodev.ThisDeliver.repositories.ProductRepository;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;


    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findOrderWithProducts();
        return list.stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        List<Order> order = repository.findById(id);
        OrderDTO orderDTO = new OrderDTO(order);
        return orderDTO;
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO){
        Order order = new Order(null, orderDTO.getAddress(), orderDTO.getLatitude(), orderDTO.getLongitude(), Instant.now(), OrderStatus.PENDING);

        for (ProductDTO p : orderDTO.getProducts()){
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }

        order = repository.save(order);

        return new OrderDTO(order);
    }



}
