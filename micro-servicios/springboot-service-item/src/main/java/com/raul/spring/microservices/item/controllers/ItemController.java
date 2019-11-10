package com.raul.spring.microservices.item.controllers;

import com.raul.spring.microservices.item.models.entity.Item;
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

    @GetMapping("/detail/{id}/quantity/{quantity}")
    public Item detail(@PathVariable Long id , @PathVariable int quantity){
        return  itemsService.findById(id,quantity);
    }



}
