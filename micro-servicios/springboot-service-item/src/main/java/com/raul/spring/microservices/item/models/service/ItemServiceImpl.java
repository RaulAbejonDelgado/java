package com.raul.spring.microservices.item.models.service;

import com.raul.spring.microservices.item.models.entity.Item;
import com.raul.spring.microservices.item.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    @Override
    public Product save(Product product) {
        HttpEntity<Product> body = new HttpEntity<Product>(product);

        ResponseEntity responseEntity = itemRest.exchange("http://service-products", HttpMethod.POST, body, Product.class);

        return (Product) responseEntity.getBody();
    }

    @Override
    public Product update(Long id, Product product) {
        HttpEntity<Product> body = new HttpEntity<Product>(product);
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id",id.toString());
        ResponseEntity responseEntity = itemRest.exchange("http://service-products", HttpMethod.PUT, body, Product.class, pathVariables);

        return (Product) responseEntity.getBody();
    }

    @Override
    public void delete(Long id) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id",id.toString());
        itemRest.delete("http://service-products".concat(id.toString()), pathVariables);
    }
}
