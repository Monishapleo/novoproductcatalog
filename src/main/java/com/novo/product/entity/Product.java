package com.novo.product.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String name;
    private String description;
    @Column(nullable=false)
    private Double price;
    private Date createdDate;
    
	public Product() {
	}
	
	public Product(Long id, String name, String description, Double price, Date createdDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.createdDate=createdDate;
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
    
    
}