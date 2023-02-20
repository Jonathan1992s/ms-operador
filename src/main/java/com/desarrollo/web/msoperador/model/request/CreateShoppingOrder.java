package com.desarrollo.web.msoperador.model.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateShoppingOrder {

    private String id;
    private String client;
    private String date;
    private Float total;
    private List<CreateProductOrder> products;

}