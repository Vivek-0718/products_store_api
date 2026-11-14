package com.vtest.store.service;

import com.vtest.store.dto.RequestDto;
import com.vtest.store.dto.ResponseDto;
import com.vtest.store.model.Product;
import com.vtest.store.repository.ProductRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ResponseEntity<Product> addProduct(RequestDto requestDto) {
        Product product = new Product();
        product.setName(requestDto.getName());
        product.setPrice(requestDto.getPrice());
        product.setQuantity(requestDto.getQuantity());
        product.setCategory(requestDto.getCategory());
        product.setDescription(requestDto.getDescription());
        productRepo.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    public ResponseEntity<List<ResponseDto>> getAllProducts() {
        List<Product> products = productRepo.findAll();
        List<ResponseDto> productsResponse = products.stream().map(
                product -> {
                    ResponseDto dto = new ResponseDto();
                    dto.setId(product.getId());
                    dto.setName(product.getName());
                    dto.setPrice(product.getPrice());
                    dto.setQuantity(product.getQuantity());
                    dto.setCategory(product.getCategory());
                    dto.setDescription(product.getDescription());
                    return dto;
                }).toList();
        return ResponseEntity.ok(productsResponse);
    }
}
