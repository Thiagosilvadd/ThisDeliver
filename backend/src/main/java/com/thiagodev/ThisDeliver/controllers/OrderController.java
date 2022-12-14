package com.thiagodev.ThisDeliver.controllers;

import com.thiagodev.ThisDeliver.dto.OrderDTO;
import com.thiagodev.ThisDeliver.dto.ProductDTO;
import com.thiagodev.ThisDeliver.services.OrderService;
import com.thiagodev.ThisDeliver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        List<OrderDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
