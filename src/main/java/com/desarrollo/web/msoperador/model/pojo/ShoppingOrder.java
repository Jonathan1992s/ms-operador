package com.desarrollo.web.msoperador.model.pojo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.List;

@Document(indexName = "shopping-orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingOrder {

    @Id
    private String id;

    @Field(type = FieldType.Keyword, name = "client")
    private String client;

    @Field(type = FieldType.Text, name = "date")
    private String date;

    @Field(type = FieldType.Float, name = "total")
    private Float total;

    @Field(type = FieldType.Nested, name = "products")
    private List<ProductOrder> products;


}
