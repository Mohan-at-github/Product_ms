package com.example.product_service.Controllers.DTOs.Category;

import com.example.product_service.Models.Category;
import lombok.Data;

import java.util.List;

@Data
public class GetAllCategoryRespDTO {
    List<Category> categoryList;
}
