package com.desarrollo.web.msbuscador.service;

import com.desarrollo.web.msbuscador.data.ElasticsearchRepository;
import com.desarrollo.web.msbuscador.model.pojo.Product;
import com.desarrollo.web.msbuscador.model.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ElasticsearchRepository repository;


    @Override
    public List<Product> getProducts() {
        return repository.getProducts();
    }

    @Override
    public List<Product> getProductsEnableDiscount() {
        return repository.getProductsDiscount();
    }

    @Override
    public Product getProductById(String id) {
        return repository.getById(id);
    }

    @Override
    public Product createProduct(CreateProductRequest request) {
        if (
                request != null
                        && StringUtils.hasLength(request.getName().trim())
                        && StringUtils.hasLength(request.getImageUrl().trim())
                        && request.getPrice() > (float)0
                        && request.getStock() >= 0
                        && request.getDiscount() >= 0
                        && request.getDiscount() <= 1
                        && StringUtils.hasLength(request.getDescription().trim())
                        && StringUtils.hasLength(request.getCategory().trim())
                        && StringUtils.hasLength(request.getBrand().trim())
        ){
            UUID uuid = UUID.randomUUID();
            Product product = Product.builder()
                    .id(uuid.toString())
                    .name(request.getName())
                    .imageUrl(request.getImageUrl())
                    .price(request.getPrice())
                    .stock(request.getStock())
                    .discount(request.getDiscount())
                    .enableDiscount(request.getEnableDiscount())
                    .description(request.getDescription())
                    .category(request.getCategory())
                    .brand(request.getBrand())
                    .build();
            return repository.saveProduct(product);
        }else{
            return null;
        }

    }

    @Override
    public List<Product> searchProducts(String name, String description, String category, String brand) {
        List<Product> products = repository.searchProducts(name, description, category, brand);
        System.out.println("name = " + name + ", description = " + description + ", category = " + category + ", brand = " + brand);
        for (Product x:products) {
            System.out.println(x);
        }
        return products.isEmpty() ? null : products;
    }

}
