package com.kiran.springBootFundamentals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.springBootFundamentals.entity.Product;
import com.kiran.springBootFundamentals.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value = "/products" )
	@GetMapping
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	@RequestMapping(value = "/product/{id}")
	@GetMapping
	public Product getProductById(@PathVariable("id") int  id) {
		return productRepository.findById(id).get();
	}
	
	
	@RequestMapping(value = "/createProduct")
	@PostMapping
	
	public Product createProduct(@RequestBody Product product) {
		System.out.println("product:: " + product.toString());
		return productRepository.save(product);
	}
	
	@RequestMapping(value = "/updateProduct")
	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
