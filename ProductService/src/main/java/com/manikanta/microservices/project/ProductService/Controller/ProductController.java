package com.manikanta.microservices.project.ProductService.Controller;

import com.manikanta.microservices.project.ProductService.DTO.ProductDTO;
import com.manikanta.microservices.project.ProductService.Entity.Product;
import com.manikanta.microservices.project.ProductService.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductDTO> getProducts() {
        return productService.getProducts();

    }

    @GetMapping("{product-id}")
    public ProductDTO getProductById(@PathVariable("product-id") Long id) {
    return productService.getProduct(id);
    }

    @DeleteMapping("{product-id}")
    public void deleteUserById(@PathVariable("user-id") Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }
}