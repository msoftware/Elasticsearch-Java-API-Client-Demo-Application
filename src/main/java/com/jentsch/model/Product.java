package com.jentsch.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Long stocks;
    private Date createdAt;
    private Date updatedAt;

    public static Map<String, Object> getConditionMap(Product product) {
        Map<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("id", product.getId());
        conditionMap.put("name", product.getName());
        conditionMap.put("price", product.getPrice());
        conditionMap.put("description", product.getDescription());
        conditionMap.put("stocks", product.getStocks());
        conditionMap.put("createdAt", product.getCreatedAt());
        conditionMap.put("updatedAt", product.getUpdatedAt());
        return conditionMap;
    }
}
