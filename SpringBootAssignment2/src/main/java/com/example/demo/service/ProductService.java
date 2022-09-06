package com.example.demo.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductException;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;

	public void addProducts(ProductDto p) {
		Product product = new Product();
		product.setDescription(p.getDescription());
		product.setWeight(p.getWeight());
		product.setManufacturingDate(p.getManufacturingDate());
		product.setUseBeforeMonths(p.getUseBeforeMonths());
		product.setExpiryDate(getExpiryDate(p));
		product.setPrice(p.getPrice());

		productRepo.save(product);
	}

	public void deleteExpiredProducts() {
		Iterable<Product> productList = productRepo.findAll();
		List<Product> expiredProductList = new ArrayList<Product>();

		productList.forEach(product -> {

			if (product.getExpiryDate().isBefore(LocalDate.now())) {
				expiredProductList.add(product);
			}
		});

		for (int i = 0; i < expiredProductList.size(); i++) {
			productRepo.deleteById(expiredProductList.get(i).getProductId());
		}

	}

	public LocalDate getExpiryDate(ProductDto p) {
		return p.getManufacturingDate().plusMonths(p.getUseBeforeMonths());
	}

	public void sortProductsAfterDeletion(List<Product> products) {

	     List<Product> sortedProducts = products.stream().sorted((p1, p2) -> p1.getExpiryDate().compareTo(p2.getExpiryDate())).collect(Collectors.toList());
	}

	public void applyDiscounts() {

	      Iterable<Product> productList = productRepo.findAll();
	      
	      productList.forEach(product -> {
	    	  Period p = Period.between(product.getManufacturingDate(), LocalDate.now());
	    	  Product pr = null;
	    	  if(p.getMonths() == 6) {
	    		Optional<Product> prod =  productRepo.findById(product.getProductId());
	    		try {
					pr = prod.orElseThrow(() -> new ProductException("Item Not Found Exception"));
				} catch (ProductException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		 pr.setPrice(pr.getPrice() - ((20 / 100) * pr.getPrice()));
	    	  }
	      });
	}
	
	public Optional<Product> searchById(int productId) {
		return productRepo.findById(productId);
	}
}
