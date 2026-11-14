package com.vtest.store.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class RequestDto {
    @NotBlank(message = "Product name is required")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;
    @NotNull(message = "Product price is required")
    @PositiveOrZero(message = "Invalid Product price")
    private BigDecimal price;
    @NotNull(message = "Product quantity is required")
    @PositiveOrZero(message = "Invalid Product quantity")
    private Integer quantity;
    @NotBlank(message = "Product category is required")
    @Size(max = 20, message = "Category cannot exceed 20 characters")
    private String category;
    @Size(max = 100, message = "Description cannot exceed 500 characters")
    private String description;

    public RequestDto(String name, BigDecimal price, Integer quantity, String category, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
    }

    public RequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
