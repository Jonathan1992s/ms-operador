package com.desarrollo.web.msbuscador.model.pojo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Document(indexName = "products")
@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
public class Product {

    public Product(String id, String name, String urlImg, Float price, Float discount,Boolean enableDiscount, Integer stock, String description, String category, String brand) {
        this.id = id;
        this.name = name;
        this.imageUrl = urlImg;
        this.price = price;
        this.discount = discount;
        this.enableDiscount = enableDiscount;
        this.stock = stock;
        this.description = description;
        this.category = category;
        this.brand = brand;
        if (enableDiscount && discount >= 0){
            this.price = price - price*discount;
        }
    }

    @Id
    private String id;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "name"),
    otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String name;

    @Field(type = FieldType.Keyword, name = "imageUrl")
    private String imageUrl;

    @Field(type = FieldType.Float, name = "price")
    private Float price;

    @Field(type = FieldType.Float, name = "discount")
    private Float discount;
    @Field(type = FieldType.Boolean, name = "enableDiscount")
    private Boolean enableDiscount  ;

    @Field(type = FieldType.Integer, name = "stock")
    private Integer stock;

    @MultiField(mainField = @Field(type = FieldType.Text, name = "description"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String description;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "category"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String category;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "brand"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String brand;


}
