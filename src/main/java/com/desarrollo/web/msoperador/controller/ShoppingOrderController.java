package com.desarrollo.web.msoperador.controller;

import com.desarrollo.web.msoperador.model.pojo.ShoppingOrder;;
import com.desarrollo.web.msoperador.model.request.CreateShoppingOrder;
import com.desarrollo.web.msoperador.service.ShoppingOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShoppingOrderController {

    private final ShoppingOrderService service;
   
    @GetMapping(path = "/")
    public ResponseEntity<String> healthy(
          ){
        return ResponseEntity.ok("OK");
    }
    
    @GetMapping(path = "/orders/{client}")
    public ResponseEntity<List<ShoppingOrder>> saveShoppingOrder(@PathVariable(name = "client") String client){
        List<ShoppingOrder> shoppingOrder = service.findShoppingOrderByClient(client);
        if (shoppingOrder!=null){

            return ResponseEntity.status(HttpStatus.OK).body(shoppingOrder);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(path = "/orders")
    public ResponseEntity<ShoppingOrder> saveShoppingOrder(@RequestBody CreateShoppingOrder request){
        ShoppingOrder shoppingOrder = service.createShoppingOrder(request);
        if (shoppingOrder!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(shoppingOrder);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
