package com.raul.spring.jpa.springjpav1.models.service;

import com.raul.spring.jpa.springjpav1.models.dao.IPartnerRepository;
import com.raul.spring.jpa.springjpav1.models.dao.IProductDao;
import com.raul.spring.jpa.springjpav1.models.entity.Partner;
import com.raul.spring.jpa.springjpav1.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PartenerRepoService implements IPartnerRepoService{
    @Autowired
    private IPartnerRepository partnerDao;

    @Autowired
    private IProductDao productDao;

    @Transactional(readOnly = true)
    @Override
    public List<Partner> findAll() {
        return (List<Partner>) partnerDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Partner> findAll(Pageable pageable) {
        return partnerDao.findAll(pageable);
    }

    @Transactional
    @Override
    public void save(Partner partner) {
        partnerDao.save(partner);
    }

    @Transactional(readOnly = true)
    @Override
    public Partner findOne(Long id) throws Exception {
        return partnerDao.findById(id).orElseGet(null);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        partnerDao.deleteById(id);
    }

    @Override
    public List<Product> findByProductName(String term) {
        return productDao.findByName(term);
    }
}
