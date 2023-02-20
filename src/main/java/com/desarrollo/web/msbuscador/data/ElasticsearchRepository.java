package com.desarrollo.web.msbuscador.data;

import com.desarrollo.web.msbuscador.model.pojo.Product;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class ElasticsearchRepository {


    private final String [] nameSearchFields = {"name.search", "name.search._2gram", "name.search._3gram"};
    private final String [] descriptionSearchFields = {"description.search", "description.search._2gram", "description.search._3gram"};

    private final ProductRepository productRepository;

    private final ElasticsearchOperations elasticClient;


    // PRODUCTS
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public List<Product> getProductsDiscount(){
        return productRepository.findAllByEnableDiscount(true);
    }
    public Product getById(String id){
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> searchProducts(String name, String description, String category, String brand){
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.should(QueryBuilders.matchQuery("name", name))
                /*.must(QueryBuilders.multiMatchQuery(description, descriptionSearchFields)
                        .type(MultiMatchQueryBuilder.Type.BOOL_PREFIX))*/
                .should(QueryBuilders.termQuery("category", category))
                .should(QueryBuilders.matchQuery("brand", brand));

        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = nativeSearchQueryBuilder.build();

        SearchHits<Product> result = elasticClient.search(query, Product.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

}
