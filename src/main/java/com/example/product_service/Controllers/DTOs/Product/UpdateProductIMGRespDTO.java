package com.example.product_service.Controllers.DTOs.Product;

import com.example.product_service.Models.Category;
import com.example.product_service.Models.Product;
import lombok.Data;

@Data
public class UpdateProductIMGRespDTO {
    private Product product;
}
