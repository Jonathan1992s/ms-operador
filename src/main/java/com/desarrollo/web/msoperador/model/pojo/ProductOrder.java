package com.desarrollo.web.msoperador.model.pojo;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrder {

    @Field(type = FieldType.Keyword, name = "id")
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Integer, name = "quantity")
    private Integer quantity;

    @Field(type = FieldType.Float, name = "price")
    private Float price;
}