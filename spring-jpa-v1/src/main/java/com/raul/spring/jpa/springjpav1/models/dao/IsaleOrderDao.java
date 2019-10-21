package com.raul.spring.jpa.springjpav1.models.dao;

import com.raul.spring.jpa.springjpav1.models.entity.SaleOrder;
import org.springframework.data.repository.CrudRepository;

public interface IsaleOrderDao extends CrudRepository<SaleOrder, Long > {



}
