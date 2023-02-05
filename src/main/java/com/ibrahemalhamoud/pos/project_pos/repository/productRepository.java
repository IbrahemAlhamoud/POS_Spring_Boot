package com.ibrahemalhamoud.pos.project_pos.repository;

import com.ibrahemalhamoud.pos.project_pos.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<ProductEntity,Integer> {


    ProductEntity findByBarcode(String barcode);
}
