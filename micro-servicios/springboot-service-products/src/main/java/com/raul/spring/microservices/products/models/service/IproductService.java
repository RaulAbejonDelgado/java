package com.raul.spring.microservices.products.models.service;

import com.raul.spring.microservices.products.models.entity.Product;

import java.util.List;

public interface IproductService {

    public List<Product> findAll();
    public Product findById(Long id);
}