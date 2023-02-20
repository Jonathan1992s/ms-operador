package com.desarrollo.web.msoperador.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateProductOrder {

    public CreateProductOrder(String name, Integer quantity, Float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price*quantity;
    }

    private String id;
    private String name;
    private Integer quantity;
    private Float price;
}
