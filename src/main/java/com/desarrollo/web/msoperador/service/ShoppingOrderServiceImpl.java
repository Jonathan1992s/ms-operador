package com.desarrollo.web.msoperador.service;

import com.desarrollo.web.msoperador.data.ElasticsearchRepository;
import com.desarrollo.web.msoperador.facade.ProductsFacade;
import com.desarrollo.web.msoperador.model.dto.Product;
import com.desarrollo.web.msoperador.model.pojo.ProductOrder;
import com.desarrollo.web.msoperador.model.pojo.ShoppingOrder;
import com.desarrollo.web.msoperador.model.request.CreateProductOrder;
import com.desarrollo.web.msoperador.model.request.CreateShoppingOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingOrderServiceImpl implements ShoppingOrderService {

    @Autowired
    private ProductsFacade productsFacade;

    private final ElasticsearchRepository repository;
    @Override
    public ShoppingOrder createShoppingOrder(CreateShoppingOrder request) {
        if (
                request != null
                        && StringUtils.hasLength(request.getClient().trim())
                        && StringUtils.hasLength(request.getDate().trim())
                        && request.getTotal() >= 0
                        && request.getTotal() >= 0
                        && !request.getProducts().isEmpty()
        ){
            UUID uuid = UUID.randomUUID();
            List<ProductOrder> products = new ArrayList<ProductOrder>(){};
            for (CreateProductOrder productOrder: request.getProducts()) {
                Product filterProduct = productsFacade.getProduct(productOrder.getId());
                if (filterProduct !=null){
                    products.add(
                            new ProductOrder(
                                    filterProduct.getId(),
                                    filterProduct.getName(),
                                    productOrder.getQuantity(),
                                    filterProduct.getPrice()
                            )
                    );
                }
            }

            ShoppingOrder shoppingOrder = ShoppingOrder.builder()
                    .id(uuid.toString())
                    .client(request.getClient())
                    .date(request.getDate())
                    .total(request.getTotal())
                    .products(products)
                    .build();
            return repository.saveShoppingOrder(shoppingOrder);
        }else{
            return null;
        }
    }

    @Override
    public List<ShoppingOrder> findShoppingOrderByClient(String client){
        return repository.findShoppingOrderByClient(client);
    }
}
