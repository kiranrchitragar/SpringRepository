package com.kiran.springBootFundamentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.springBootFundamentals.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	
}
