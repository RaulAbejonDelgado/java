package com.raul.spring.jpa.springjpav1.models.service;

import com.raul.spring.jpa.springjpav1.models.entity.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPartnerRepoService {
    public List<Partner> findAll();

    public Page<Partner> findAll(Pageable pageable);

    public void save(Partner partner);

    public Partner findOne(Long id) throws Exception;

    public void delete(Long id);
}
