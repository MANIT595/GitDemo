package com.manikanta.microservices.project.ProductService.Service.Implementation;

import com.manikanta.microservices.project.ProductService.DTO.ProductDTO;
import com.manikanta.microservices.project.ProductService.Entity.Product;
import com.manikanta.microservices.project.ProductService.Repository.ProductRepository;
import com.manikanta.microservices.project.ProductService.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().
                map(product -> mapToDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(Long productId) {
        Product product = productRepository.findById(productId).get();
        return mapToDTO(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        System.out.println("Product deleted");
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
        System.out.println("Product Added");
    }

    public ProductDTO mapToDTO(Product product){
        return modelMapper.map(product,ProductDTO.class);
    }
}
