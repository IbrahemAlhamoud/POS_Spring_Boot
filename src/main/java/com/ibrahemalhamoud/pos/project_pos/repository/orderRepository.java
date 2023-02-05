package com.ibrahemalhamoud.pos.project_pos.repository;

import com.ibrahemalhamoud.pos.project_pos.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<OrderEntity,Integer> {

}
