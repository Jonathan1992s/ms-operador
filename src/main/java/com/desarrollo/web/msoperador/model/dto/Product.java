package com.desarrollo.web.msoperador.model.dto;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product{
    private String id;
    private String name;
    private String imageUrl;
    private Float price;
    private Float discount;
    private Boolean enableDiscount;
    private Integer stock;
    private String description;
    private String category;
    private String brand;
}