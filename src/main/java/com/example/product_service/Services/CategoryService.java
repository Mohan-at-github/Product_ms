package com.example.product_service.Services;

import com.example.product_service.Exceptions.InvalidCategoryException;
import com.example.product_service.Models.Category;

import java.util.List;

public interface CategoryService {
    public Category createCategory(String Category);
    public List<Category> getAllCategory();
    public Category getCategoryByID(long ID);
    public Category UpdateCategory(long id,String name) throws Exception;
    public Category deleteCategory(long id) throws InvalidCategoryException;
}
