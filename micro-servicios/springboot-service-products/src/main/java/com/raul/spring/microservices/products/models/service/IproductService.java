package com.raul.spring.microservices.products.models.service;



import com.raul.spring.microservices.commons.models.entity.Product;

import java.util.List;

public interface IproductService {

    public List<Product> findAll();
    public Product findById(Long id);

    public Product save(Product product);

    public void deleteById(Long id);
}
