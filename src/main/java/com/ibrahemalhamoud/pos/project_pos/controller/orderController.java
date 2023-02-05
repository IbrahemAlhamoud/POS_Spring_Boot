package com.ibrahemalhamoud.pos.project_pos.controller;

import com.ibrahemalhamoud.pos.project_pos.dao.orderDao;
import com.ibrahemalhamoud.pos.project_pos.dao.saleDao;
import com.ibrahemalhamoud.pos.project_pos.dto.orderDto;
import com.ibrahemalhamoud.pos.project_pos.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/orders")
public class orderController {
    @Autowired
    private orderDao orderDao;

    @Autowired
    private saleDao saleDao;

    @PostMapping(path = "/saveOrder")
    public OrderEntity findTotal(@RequestBody List<orderDto> order) {

        return this.saleDao.saveSale(order);

    }

    @GetMapping(path = "findAllOrder")

    public List<OrderEntity> findAllOrderController() {

        return this.orderDao.findAllOrder();
    }
}
