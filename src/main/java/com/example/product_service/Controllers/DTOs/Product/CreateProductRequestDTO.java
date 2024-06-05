package com.example.product_service.Controllers.DTOs.Product;

import lombok.Data;

@Data
public class CreateProductRequestDTO {
    private String title;
    private String price;
    private String description;
    private String image;
    private String categoryName;
}
