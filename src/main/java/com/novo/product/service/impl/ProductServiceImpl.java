package com.novo.product.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.novo.product.entity.Product;
import com.novo.product.exception.ProductNotFoundException;
import com.novo.product.repository.ProductRepository;
import com.novo.product.service.ProductService;

import jakarta.persistence.Cacheable;

@Service
public class ProductServiceImpl implements ProductService{
	
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Page<Product> getAllProductsPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProductById(Long id) {
        try {
            return productRepository.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException( "Product not found"));
        } catch (Exception ex) {
            logger.error("Error fetching product with ID {}: {}", id, ex.getMessage());
            throw ex;
        }
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
    
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
