package com.ibrahemalhamoud.pos.project_pos.controller;

import com.ibrahemalhamoud.pos.project_pos.dao.productDao;
import com.ibrahemalhamoud.pos.project_pos.dto.orderDto;
import com.ibrahemalhamoud.pos.project_pos.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/products")
public class productController {
    @Autowired
    private productDao productDao;

    private orderDto order;



    @PostMapping(path = "/addProduct")
    public ProductEntity addProductController(@RequestBody ProductEntity entityadd) {
        return this.productDao.addProduct(entityadd);
    }
    @GetMapping(path = "/deleteProduct")
    public String deleteProductController(@RequestParam Integer idPro) {
        return this.productDao.deleteProduct(idPro);
    }
    @GetMapping(path = "/findProductById")
    public Optional<ProductEntity> findProductByIdController(@RequestParam Integer idc){
        return this.productDao.findProductById(idc);
    }
    @GetMapping(path = "/findProductByBarcode")
    public ProductEntity findProductByBaracodeController(@RequestParam String Barcode){
        return this.productDao.findProductByBaracode(Barcode);
    }
    @GetMapping(path = "/findProductAll")
    public List<ProductEntity> findProductAll(){
        return this.productDao.findProductAll();
    }

}
