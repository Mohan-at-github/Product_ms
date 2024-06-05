package com.example.product_service.Services;

import com.example.product_service.Exceptions.InvalidCategoryException;
import com.example.product_service.Models.Category;
import com.example.product_service.Repository.CategoryRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(String categoryName) {
        Category category=new Category();
        category.setName(categoryName);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {

        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByID(long ID) {
        Optional<Category> optionalCategory=categoryRepository.findById(ID);
        if(optionalCategory.isEmpty()) throw new NullPointerException();
        return  optionalCategory.get();
    }

    @Override
    public Category UpdateCategory(long id, String name) throws InvalidCategoryException{
    Optional<Category> optionalCategory=categoryRepository.findById(id);
    if(optionalCategory.isEmpty()) throw new InvalidCategoryException("Invalid ID");
    Category category=optionalCategory.get();
    category.setName(name);
    return categoryRepository.save(category);

    }

    @Override
    public Category deleteCategory(long id) throws InvalidCategoryException {
        Optional<Category> optionalCategory=categoryRepository.findById(id);
        if(optionalCategory.isEmpty()) throw new InvalidCategoryException("Invalid ID");
        this.categoryRepository.deleteById(id);
        return optionalCategory.get();
    }

}
