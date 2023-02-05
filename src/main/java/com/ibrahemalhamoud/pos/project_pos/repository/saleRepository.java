package com.ibrahemalhamoud.pos.project_pos.repository;

import com.ibrahemalhamoud.pos.project_pos.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface saleRepository extends JpaRepository<SaleEntity,Integer> {

    List<SaleEntity> findByOrderId(Integer orderId);

}

