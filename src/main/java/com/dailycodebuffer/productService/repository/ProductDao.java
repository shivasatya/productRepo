package com.dailycodebuffer.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.productService.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long> {

}
