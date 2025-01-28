package com.novo.product.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.novo.product.service.ExternalApiService;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {

    private  RestTemplate restTemplate;

    @Value("${external.api.url}")  
    private String apiUrl;
    

public ExternalApiServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


    public Double fetchProductPriceFromExternalApi(Long productId) {

    	String url = apiUrl + "/posts/" + productId;
        return restTemplate.getForObject(url, Double.class);
    }
}
