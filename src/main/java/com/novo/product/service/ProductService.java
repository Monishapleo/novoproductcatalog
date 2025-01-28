package com.novo.product.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.novo.product.entity.Product;


public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Page<Product> getAllProductsPage(int page, int size);

	@Cacheable(value = "productPrices", key = "#id")
	public Product getProductById(Long id);
    
    public Product createProduct(Product product);

    public Product updateProduct(Long id, Product product);

    public void deleteProduct(Long id);
}
