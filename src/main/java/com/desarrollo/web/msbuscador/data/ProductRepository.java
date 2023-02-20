package com.desarrollo.web.msbuscador.data;

import com.desarrollo.web.msbuscador.model.pojo.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    List<Product> findAll();
    List<Product> findAllByEnableDiscount(boolean enableDiscount);
    Product getById(String id);
}
