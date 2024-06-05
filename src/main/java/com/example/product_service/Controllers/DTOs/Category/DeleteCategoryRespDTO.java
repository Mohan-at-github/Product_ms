package com.example.product_service.Controllers.DTOs.Category;

import com.example.product_service.Models.Category;
import lombok.Data;

@Data
public class DeleteCategoryRespDTO {
    Category category;
    private String status;
}
