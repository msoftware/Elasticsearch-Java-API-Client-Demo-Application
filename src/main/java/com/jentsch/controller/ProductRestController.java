package com.jentsch.controller;

import co.elastic.clients.elasticsearch._types.Result;
import com.jentsch.exception.InvalidRecordException;
import com.jentsch.exception.RecordNotFoundException;
import com.jentsch.model.Product;
import com.jentsch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts()
            throws IOException
    {
        List<Product> products = productService.fetchAllProducts();
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") final Long id)
            throws IOException
    {
        if (id == null) {
            throw new RecordNotFoundException("Please enter a valid 'id'");
        }
        return productService.fetchProductById(id);
    }

    @PostMapping("/find")
    public List<Product> fetchProducts(@RequestBody Product product)
            throws IOException
    {
        int anz = 1000;
        return productService.fetchProducts(product);
    }

    @PostMapping("/")
    public Result saveProduct(@RequestBody Product product)
            throws IOException
    {
        if (product.getId() == null) {
            throw new InvalidRecordException("Please enter a valid 'id'");
        }
        Result result = productService.saveProduct(product);
        return result;
    }

    @PostMapping("/all")
    public Boolean saveProducts(@RequestBody List<Product> products)
            throws IOException
    {
        Boolean result = productService.bulkSaveProducts(products);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteProductById(@PathVariable("id") final Long id)
            throws IOException
    {
        return productService.deleteProductById(id);
    }
}
