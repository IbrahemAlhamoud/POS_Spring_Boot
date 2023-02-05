package com.ibrahemalhamoud.pos.project_pos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "orders")
@Entity
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "total",length=1000000,columnDefinition="LONGTEXT")
    private Double total;
}
