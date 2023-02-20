package com.desarrollo.web.msbuscador.service;

import com.desarrollo.web.msbuscador.model.pojo.Product;
import com.desarrollo.web.msbuscador.model.request.CreateProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    List<Product> getProductsEnableDiscount();
    Product getProductById(String id);
    Product createProduct(CreateProductRequest request);
    List<Product> searchProducts (String name, String description, String category, String brand);
}
