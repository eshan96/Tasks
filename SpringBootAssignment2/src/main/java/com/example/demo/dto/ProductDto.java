package com.example.demo.dto;

import java.time.LocalDate;

public class ProductDto {

	private int productId;
	private String description;
	private double weight;
	private LocalDate manufacturingDate;
	private int useBeforeMonths;
	private LocalDate expiryDate;
	private int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
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
}
