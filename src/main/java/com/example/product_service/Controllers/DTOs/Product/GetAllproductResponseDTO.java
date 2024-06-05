package com.example.product_service.Controllers.DTOs.Product;

import com.example.product_service.Models.Product;
import lombok.Data;

import java.util.List;
@Data
public class GetAllproductResponseDTO {
    List<Product> productList;
}
