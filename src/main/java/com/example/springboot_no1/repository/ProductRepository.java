package com.example.springboot_no1.repository;

import com.example.springboot_no1.dto.request.product.ProductCreateRequest;
import com.example.springboot_no1.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    ProductEntity createProduct(ProductCreateRequest product);

    List<ProductEntity> findAllProducts();
}
