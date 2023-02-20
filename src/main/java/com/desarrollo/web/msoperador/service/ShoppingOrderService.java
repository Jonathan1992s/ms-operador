package com.desarrollo.web.msoperador.service;

import com.desarrollo.web.msoperador.model.pojo.ShoppingOrder;
import com.desarrollo.web.msoperador.model.request.CreateShoppingOrder;

import java.util.List;

public interface ShoppingOrderService {

    ShoppingOrder createShoppingOrder(CreateShoppingOrder request);

    List<ShoppingOrder> findShoppingOrderByClient(String client);
}
