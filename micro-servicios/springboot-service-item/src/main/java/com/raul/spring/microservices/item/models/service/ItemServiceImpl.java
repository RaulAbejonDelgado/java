package com.raul.spring.microservices.item.models.service;

import com.raul.spring.microservices.item.models.entity.Item;
import com.raul.spring.microservices.item.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemsService {

    @Autowired
    private RestTemplate itemRest;

    @Override
    public List<Item> listAll() {
        List<Product> products = Arrays.asList(Objects.requireNonNull(itemRest.getForObject("http://service-products/list", Product[].class)));

        return products.stream().map(p -> new Item(p,1)).collect(Collectors.toList());

    }

    @Override
    public Item findById(Long id, int quantity) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id",id.toString());
        Product product = itemRest.getForObject("http://service-products/detail/{id}", Product.class, pathVariables);
        return new Item(product,quantity);
    }
}
