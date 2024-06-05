package com.example.product_service.Controllers.DTOs.Category;

import com.example.product_service.Controllers.DTOs.Product.ResponseStatusDTO;
import com.example.product_service.Models.Category;
import lombok.Data;

import java.util.Calendar;
@Data
public class GetCategoryByIDRespDTO {
    private Category category;
    private ResponseStatusDTO responseStatus;
}
