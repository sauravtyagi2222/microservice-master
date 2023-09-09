package com.programing.productservice.service;

import com.programing.productservice.dto.ProductRequest;
import com.programing.productservice.dto.ProductResponse;
import com.programing.productservice.model.Product;
import com.programing.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        productRepository.save(product);
    }

    public List<ProductResponse> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
