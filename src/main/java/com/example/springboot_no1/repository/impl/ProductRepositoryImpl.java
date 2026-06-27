package com.example.springboot_no1.repository.impl;

import com.example.springboot_no1.dto.request.product.ProductCreateRequest;
import com.example.springboot_no1.entity.ProductEntity;
import com.example.springboot_no1.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public ProductEntity createProduct(ProductCreateRequest product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("No1");
        productEntity.setProductPrice(new BigDecimal("21.6"));
        return productEntity;
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setProductName("No1");
        productEntity.setProductPrice(new BigDecimal("21.6"));
        return List.of(productEntity);
    }
}
