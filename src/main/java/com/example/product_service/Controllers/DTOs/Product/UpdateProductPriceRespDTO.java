package com.example.product_service.Controllers.DTOs.Product;

import com.example.product_service.Models.Product;
import lombok.Data;

@Data
public class UpdateProductPriceRespDTO {
    private Product product;
}
