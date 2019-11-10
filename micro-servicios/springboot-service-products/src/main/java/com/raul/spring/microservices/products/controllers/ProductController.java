package com.raul.spring.microservices.products.controllers;

import com.raul.spring.microservices.products.models.entity.Product;
import com.raul.spring.microservices.products.models.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private Environment env;

    @Autowired
    private IproductService productService;

    @Value("${server.port}")
    private int port;

    @GetMapping("/list")
    public List<Product> list(){
        return productService.findAll().stream().map(product -> {
            //product.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port"))));
            product.setPort(port);
            return product;
        }).collect(Collectors.toList());
    }

    @GetMapping("/detail/{id}")
    public Product findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        // port = Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port")));
        product.setPort(port);

        return product;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@PathVariable(value = "id") Long id,
                          @RequestBody Product product){
        Product p = productService.findById(id);
        p.setName(product.getName());
        p.setPrice(product.getPrice());

        return p;

    }

    @DeleteMapping("{/id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id ){
        productService.deleteById(id);

    }
}
