package com.desarrollo.web.msoperador.data;

import com.desarrollo.web.msoperador.model.pojo.ShoppingOrder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ShoppingOrderRepository extends ElasticsearchRepository<ShoppingOrder, String> {

    List<ShoppingOrder> findShoppingOrderByClient(String client);
}
