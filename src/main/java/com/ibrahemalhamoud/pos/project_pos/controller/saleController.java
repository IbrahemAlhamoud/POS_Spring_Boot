package com.ibrahemalhamoud.pos.project_pos.controller;

import com.ibrahemalhamoud.pos.project_pos.dao.saleDao;
import com.ibrahemalhamoud.pos.project_pos.entity.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/sales")
public class saleController {
    @Autowired
    private saleDao saleDao;
    @GetMapping(path = "/findSallAll")
    public List<SaleEntity> sallAllController(){
        return this.saleDao.saleAll();
    }

    @GetMapping(path ="/findByOrder")
    public List<SaleEntity> sallByOrderController(@RequestParam Integer ordereId){
        return this.saleDao.saleByOrder(ordereId);
    }

}
