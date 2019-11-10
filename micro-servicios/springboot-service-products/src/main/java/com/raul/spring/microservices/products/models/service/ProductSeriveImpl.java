package com.raul.spring.microservices.products.models.service;

import com.raul.spring.microservices.products.models.dao.ProductDao;
import com.raul.spring.microservices.products.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductSeriveImpl implements  IproductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
}
