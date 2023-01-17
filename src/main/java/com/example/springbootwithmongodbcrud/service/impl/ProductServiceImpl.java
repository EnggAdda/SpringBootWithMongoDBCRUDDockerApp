package com.example.springbootwithmongodbcrud.service.impl;

import com.example.springbootwithmongodbcrud.entity.Product;
import com.example.springbootwithmongodbcrud.repo.ProductRepo;
import com.example.springbootwithmongodbcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {

        Product productFromDB  =  productRepo.findById(id).get();
        productFromDB.setName(product.getName());
        productFromDB.setPrice(product.getPrice());
       return productRepo.save(productFromDB);

    }

    @Override
    public void deleteProduct(int id) {

        productRepo.deleteById(id);
    }
}
