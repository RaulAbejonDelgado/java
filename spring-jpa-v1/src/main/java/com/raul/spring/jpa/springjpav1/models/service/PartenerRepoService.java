package com.raul.spring.jpa.springjpav1.models.service;

import com.raul.spring.jpa.springjpav1.models.dao.IPartnerRepository;
import com.raul.spring.jpa.springjpav1.models.entity.Partner;
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
}
