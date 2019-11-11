package com.raul.spring.microservices.products.models.dao;


import com.raul.spring.microservices.commons.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository <Product, Long> {

}
