package com.example.springboot_no1.service;

import com.example.springboot_no1.dto.request.product.ProductCreateRequest;
import com.example.springboot_no1.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductEntity createProduct(ProductCreateRequest productCreateRequest);

    List<ProductEntity> findAllProducts();
}
