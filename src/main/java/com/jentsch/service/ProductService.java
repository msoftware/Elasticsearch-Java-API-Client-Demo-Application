package com.jentsch.service;

import co.elastic.clients.elasticsearch._types.Result;
import com.jentsch.exception.RecordNotFoundException;
import com.jentsch.model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    Product fetchProductById(Long id) throws RecordNotFoundException, IOException;

    Result saveProduct(Product product) throws IOException;

    Result deleteProductById(Long id) throws IOException;

    List<Product> fetchAllProducts() throws IOException;

    boolean bulkSaveProducts(List<Product> products) throws IOException;

    List<Product> fetchProducts(Product product) throws IOException;
}
