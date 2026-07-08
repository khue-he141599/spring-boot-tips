package com.example.springboot_no1;

import com.example.springboot_no1.entity.OrderEntity;
import com.example.springboot_no1.entity.ProductEntity;
import com.example.springboot_no1.repository.OrderRepository;
import com.example.springboot_no1.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductOrderTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void manyToManyInserTest() {
        ProductEntity productEntity1 = new ProductEntity();
        ProductEntity productEntity2 = new ProductEntity();

        OrderEntity orderEntity1 = new OrderEntity();
        OrderEntity orderEntity2 = new OrderEntity();
        OrderEntity orderEntity3 = new OrderEntity();

        productEntity1.setProductName("p1");
        productEntity1.setProductPrice(new BigDecimal("10.2"));

        productEntity2.setProductName("p2");
        productEntity2.setProductPrice(new BigDecimal("10.3"));

        orderEntity1.setUserId(1);
        orderEntity2.setUserId(3);

        productEntity1.setOrderList(List.of(orderEntity1, orderEntity2));
        productEntity2.setOrderList(List.of(orderEntity1, orderEntity2, orderEntity3));

        orderRepository.save(orderEntity1);
        orderRepository.save(orderEntity2);
        orderRepository.save(orderEntity3);

        productRepository.save(productEntity1);
        productRepository.save(productEntity2);

    }

    @Test
    @Transactional
    void selectManyToManyTest() {
        ProductEntity p1 = productRepository.findById(1L).orElseThrow();
        System.out.println(p1);
        System.out.println(p1.getOrderList());
    }
}
