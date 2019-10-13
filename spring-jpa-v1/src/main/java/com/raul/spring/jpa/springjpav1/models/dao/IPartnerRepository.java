package com.raul.spring.jpa.springjpav1.models.dao;

import com.raul.spring.jpa.springjpav1.models.entity.Partner;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPartnerRepository extends PagingAndSortingRepository<Partner, Long> {



}
