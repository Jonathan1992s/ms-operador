package com.desarrollo.web.msoperador.data;

import com.desarrollo.web.msoperador.model.pojo.ShoppingOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ElasticsearchRepository {

    private final ShoppingOrderRepository shoppingOrderRepositoryRepository;

    public ShoppingOrder saveShoppingOrder(ShoppingOrder shoppingOrder){
        return shoppingOrderRepositoryRepository.save(shoppingOrder);
    }

    public List<ShoppingOrder> findShoppingOrderByClient(String client){
        return shoppingOrderRepositoryRepository.findShoppingOrderByClient(client);
    }


}
