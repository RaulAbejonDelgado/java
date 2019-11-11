package com.raul.spring.microservices.item.models.service;

import com.raul.spring.microservices.commons.models.entity.Product;
import com.raul.spring.microservices.item.models.entity.Item;


import java.util.List;

public interface ItemsService {

    public List<Item> listAll();
    public Item findById(Long id, int quantity);

    public Product save(Product product);
    public Product update(Long id ,Product product);
    public void delete(Long id);
}
