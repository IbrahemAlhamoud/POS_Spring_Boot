package com.ibrahemalhamoud.pos.project_pos.dao;
import com.ibrahemalhamoud.pos.project_pos.dto.orderDto;
import com.ibrahemalhamoud.pos.project_pos.entity.OrderEntity;
import com.ibrahemalhamoud.pos.project_pos.repository.orderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data

public class orderDao {
    @Autowired
    private orderRepository orderRepo;

        public OrderEntity saveOrder(List<orderDto> order){
            if(order.size()!=0){

                Double total=0.0;
                for (orderDto o:order) {
                    total += o.getProductPrice();
                }
                OrderEntity oe = new OrderEntity();
                oe.setTotal(total);
                return this.orderRepo.save(oe);

            }
            else {
                return null;
            }

        }
         public List<OrderEntity> findAllOrder(){

            return this.orderRepo.findAll();
         }
}
