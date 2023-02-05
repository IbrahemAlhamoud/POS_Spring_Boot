package com.ibrahemalhamoud.pos.project_pos.dao;
import com.ibrahemalhamoud.pos.project_pos.entity.ProductEntity;
import com.ibrahemalhamoud.pos.project_pos.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productDao {
    @Autowired
    private productRepository productRepo;



    public ProductEntity addProduct(ProductEntity entityadd){
       return this.productRepo.save(entityadd);
    }

    public String deleteProduct(Integer idPro) {
        Optional<ProductEntity> op = this.productRepo.findById(idPro);
        if (op.isPresent()) {
            this.productRepo.deleteById(idPro);
            return "yes";
        } else {
            return "erorr";
        }
    }
    public Optional<ProductEntity> findProductById(Integer idc) {
        return this.productRepo.findById(idc);
    }
    public ProductEntity findProductByBaracode(String code) {
        return this.productRepo.findByBarcode(code);
    }
    public List<ProductEntity> findProductAll() {
        return this.productRepo.findAll();
    }

}
