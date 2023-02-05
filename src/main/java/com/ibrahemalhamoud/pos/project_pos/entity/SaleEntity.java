package com.ibrahemalhamoud.pos.project_pos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "sales")
@Entity
@Data
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Integer saleId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "order_id")
    private Integer orderId;

    @JoinColumn(name = "product_id",insertable = false,updatable = false )
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductEntity productEntity;



}
