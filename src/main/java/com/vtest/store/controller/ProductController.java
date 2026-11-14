package com.vtest.store.controller;

import com.vtest.store.dto.RequestDto;
import com.vtest.store.dto.ResponseDto;
import com.vtest.store.model.Product;
import com.vtest.store.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody RequestDto requestDto) {
        return productService.addProduct(requestDto);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ResponseDto>> getAllProducts() {
        return productService.getAllProducts();
    }
}