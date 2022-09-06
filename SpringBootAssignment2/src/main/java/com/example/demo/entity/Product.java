package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String description;
	private double weight;
	private int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "manufacturing_date")
	private LocalDate manufacturingDate;
	
	@Column(name = "use_before_months")
	private int useBeforeMonths;
	
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public int getUseBeforeMonths() {
		return useBeforeMonths;
	}
	public void setUseBeforeMonths(int useBeforeMonths) {
		this.useBeforeMonths = useBeforeMonths;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Product(int productId, String description, double weight, LocalDate manufacturingDate, int useBeforeMonths,
			LocalDate expiryDate) {
		
		this.productId = productId;
		this.description = description;
		this.weight = weight;
		this.manufacturingDate = manufacturingDate;
		this.useBeforeMonths = useBeforeMonths;
		this.expiryDate = expiryDate;
	}
	public Product() {
		
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", description=" + description + ", weight=" + weight
				+ ", manufacturingDate=" + manufacturingDate + ", useBeforeMonths=" + useBeforeMonths + ", expiryDate="
				+ expiryDate + "]";
	}
	
	
}
