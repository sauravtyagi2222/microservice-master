package com.programing.productservice.controller;

import com.programing.productservice.dto.ProductRequest;
import com.programing.productservice.dto.ProductResponse;
import com.programing.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        log.info("Call create product service {} ", productRequest.getId());
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> findAllProducts(){
        log.info("Call findAllProducts() service");
        return productService.findAllProducts();
    }

}
