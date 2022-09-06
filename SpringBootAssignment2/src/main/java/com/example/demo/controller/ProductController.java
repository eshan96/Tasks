package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public void addProduct(@RequestBody ProductDto pdto) {
		productService.addProducts(pdto);
	}
	
	@DeleteMapping("/product")
	public void deleteExpiredProducts() {
		productService.deleteExpiredProducts();
	}
	
	@PutMapping("/product")
	public void applyDiscounts() {
		productService.applyDiscounts();
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product> getProduct(@PathVariable int id){
		return productService.searchById(id);
	}
}
