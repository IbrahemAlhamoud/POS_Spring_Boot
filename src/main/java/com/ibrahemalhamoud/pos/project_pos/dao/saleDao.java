package com.ibrahemalhamoud.pos.project_pos.dao;

import com.ibrahemalhamoud.pos.project_pos.dto.orderDto;
import com.ibrahemalhamoud.pos.project_pos.entity.OrderEntity;
import com.ibrahemalhamoud.pos.project_pos.entity.SaleEntity;
import com.ibrahemalhamoud.pos.project_pos.repository.saleRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class saleDao {
    @Autowired
    private saleRepository saleRepo;
    private orderDao orderDao;
    public saleDao(orderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderEntity saveSale(List<orderDto> order) {
        OrderEntity order1 = this.orderDao.saveOrder(order);

        for (orderDto o : order) {
            SaleEntity sale = new SaleEntity();
            sale.setOrderId(order1.getOrderId());
            sale.setProductId(o.getProductId());
            this.saleRepo.save(sale);
        }
        return order1;
    }

    public List<SaleEntity> saleAll(){
        return this.saleRepo.findAll();
    }

    public List<SaleEntity> saleByOrder(Integer orderId){

        return this.saleRepo.findByOrderId(orderId);

    }
}
