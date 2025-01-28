package com.novo.product.service.impl;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.novo.product.entity.Product;
import com.novo.product.repository.ProductRepository;
import com.novo.product.service.ExternalApiService;
import com.novo.product.service.ProductPriceUpdateService;

@Service
public class ProductPriceUpdateServiceImpl implements ProductPriceUpdateService{
	private  ProductRepository productRepository;
    private  ExternalApiService externalApiService;
   
    public ProductPriceUpdateServiceImpl(ProductRepository productRepository, ExternalApiService externalApiService) {
		this.productRepository = productRepository;
		this.externalApiService = externalApiService;
	}

	@Scheduled(fixedRate = 86400000)  
    public void updateProductPrices() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            Double newPrice = externalApiService.fetchProductPriceFromExternalApi(product.getId());
            if (newPrice != null) {
                product.setPrice(newPrice);
                productRepository.save(product);
            }
        }
    }

}
