package com.example.product_service.Controllers.DTOs.Product;

import com.example.product_service.Models.Product;
import lombok.Data;

@Data
public class DeleteproductRespDTO {
    private Product product;
    private String status;
}
