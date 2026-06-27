package com.example.springboot_no1.controller;

import com.example.springboot_no1.dto.request.product.ProductCreateRequest;
import com.example.springboot_no1.entity.ProductEntity;
import com.example.springboot_no1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/add")
    public ProductEntity createProduct(ProductCreateRequest productCreateRequest) {
        return productService.createProduct(productCreateRequest);
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
        return productService.findAllProducts();
    }
}
