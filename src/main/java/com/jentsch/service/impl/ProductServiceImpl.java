package com.jentsch.service.impl;

import co.elastic.clients.elasticsearch._types.Result;
import com.jentsch.connector.JavaClientProductConnector;
import com.jentsch.exception.RecordNotFoundException;
import com.jentsch.model.Product;
import com.jentsch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private JavaClientProductConnector javaClientProductConnector;

    @Override
    public Product fetchProductById(Long id) throws RecordNotFoundException, IOException {
        return javaClientProductConnector.fetchProductById(id);
    }

    @Override
    public Result saveProduct(Product product) throws IOException {
        return javaClientProductConnector.saveProduct(product);
    }

    @Override
    public Result deleteProductById(Long id) throws IOException {
        return javaClientProductConnector.deleteProductById(id);
    }

    @Override
    public List<Product> fetchAllProducts() throws IOException {
        return javaClientProductConnector.fetchAllProducts();
    }

    @Override
    public boolean bulkSaveProducts(List<Product> products) throws IOException {
        return javaClientProductConnector.bulkSaveProducts(products);
    }

    @Override
    public List<Product> fetchProducts(Product product) throws IOException {
        return javaClientProductConnector.fetchProducts(product);
    }

}
