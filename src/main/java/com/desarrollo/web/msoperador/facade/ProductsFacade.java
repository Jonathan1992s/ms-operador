package com.desarrollo.web.msoperador.facade;

import com.desarrollo.web.msoperador.model.dto.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductsFacade {

    @Value("${get.product.url-by-id}")
    private String getProductUrl;

    private final RestTemplate restTemplate;

    public Product getProduct(String id){
        try {
            return restTemplate.getForObject(
                    String.format(getProductUrl+ id),
                    Product.class);
        }catch (HttpClientErrorException e){
            log.error("Client Error: {}, Product with ID {}", e.getStatusCode(), id);
            
            return null;
        }

    }

}
