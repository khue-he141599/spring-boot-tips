package com.example.springboot_no1.service.impl;

import com.example.springboot_no1.dto.request.product.ProductCreateRequest;
import com.example.springboot_no1.entity.ProductEntity;
import com.example.springboot_no1.repository.ProductRepository;
import com.example.springboot_no1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired /*dependency injection*/
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductCreateRequest productCreateRequest) {
        return productRepository.createProduct(productCreateRequest);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAllProducts();
    }
}
