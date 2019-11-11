package com.raul.spring.microservices.item.controllers;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.raul.spring.microservices.commons.models.entity.Product;
import com.raul.spring.microservices.item.models.entity.Item;

import com.raul.spring.microservices.item.models.service.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope //permit us refresh update the components, the enviroment, the context without restart the server
@RestController
public class ItemController {

    private static Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private Environment env;

    @Autowired
    private ItemsService itemsService;

    @Value("${configuration.text}")
    private String text;

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

    @GetMapping("/get-config")
    public ResponseEntity<?> getConfig(@Value("${server.port}") String port){

        log.info("The input value of getConfig() is -> "+ port);

        Map<String,String> json = new HashMap<>();
        json.put("text", text);
        json.put("port", port);

        if(env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")){
            json.put("configuration.author.name",env.getProperty("configuration.author.name"));
            json.put("configuration.author.email",env.getProperty("configuration.author.email"));
        }
        return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
        return itemsService.save(product);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@PathVariable Long id, @RequestBody Product product){


        return  itemsService.update(id,product);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        itemsService.delete(id);

    }
}
