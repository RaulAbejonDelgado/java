package com.raul.spring.microservices.item.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.raul.spring.microservices.item.models.entity.Item;
import com.raul.spring.microservices.item.models.entity.Product;
import com.raul.spring.microservices.item.models.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping("/list")
    public List<Item> list(){
        return itemsService.listAll();

    }

    @HystrixCommand(fallbackMethod = "alternativeMethod")
    @GetMapping("/detail/{id}/quantity/{quantity}")
    public Item detail(@PathVariable Long id , @PathVariable int quantity){
        return  itemsService.findById(id,quantity);
    }

    /**
     * This method will executed if we will get an error after calling to products api
     * @param id detail() input id
     * @param quantity detail() input quantity
     * @return item
     */
    public Item alternativeMethod(Long id, int quantity){
        Item i = new Item();
        Product p = new Product();

        i.setQuantity(quantity);
        p.setId(id);
        p.setName("Product Alternative");
        p.setPrice(12.00);
        i.setProduct(p);

        return i ;

    }



}
