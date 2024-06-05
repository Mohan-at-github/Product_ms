package com.example.product_service.Controllers;

import com.example.product_service.Controllers.DTOs.Category.*;
import com.example.product_service.Controllers.DTOs.Product.DeleteproductRespDTO;
import com.example.product_service.Controllers.DTOs.Product.ResponseStatusDTO;
import com.example.product_service.Models.Category;
import com.example.product_service.Services.CategoryService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Data
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @PostMapping
    public CreateCategoryRespDTO createCategory(@RequestBody CreateCategoryReqDTO reqDTO){
        CreateCategoryRespDTO respDTO=new CreateCategoryRespDTO();
        String name=reqDTO.getName();
        Category category=this.categoryService.createCategory(name);
        respDTO.setCategory(category);
        return respDTO;

    }

    @GetMapping()
    public GetAllCategoryRespDTO getAllCategory(){
        GetAllCategoryRespDTO respDTO=new GetAllCategoryRespDTO();
        List<Category> categoryList=this.categoryService.getAllCategory();
        respDTO.setCategoryList(categoryList);
        return respDTO;
    }

    @GetMapping("/{ID}")
    public GetCategoryByIDRespDTO getCategoryByIDRespDTO(@PathVariable long ID)
    {
        GetCategoryByIDRespDTO categorybyID=new GetCategoryByIDRespDTO();
        try{
            Category category=this.categoryService.getCategoryByID(ID);
            categorybyID.setCategory(category);
            categorybyID.setResponseStatus(ResponseStatusDTO.SUCCESS);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            categorybyID.setResponseStatus(ResponseStatusDTO.FAILURE);
        }

        return categorybyID;
    }

    @PutMapping("/{ID}")
    public UpdateCateroryRespDTO updateCaterory(@RequestBody UpdateCategoryReqDTO updateCateroryReqDTO, @PathVariable long ID) throws Exception {
        UpdateCateroryRespDTO updateCateroryRespDTO=new UpdateCateroryRespDTO();
        String name= updateCateroryReqDTO.getName();
        Category category=this.categoryService.UpdateCategory(ID,name);
        updateCateroryRespDTO.setCategory(category);
        return updateCateroryRespDTO;
    }
    @DeleteMapping("/{id}") //deleting category here is not possible because i  ts foreign of product table so delete the product then category
    public DeleteCategoryRespDTO Deletecategory(@PathVariable int id){
       DeleteCategoryRespDTO respDTO=new DeleteCategoryRespDTO();
        try{
            Category category= this.categoryService.deleteCategory(id);
            respDTO.setStatus("Successfully Deleted");
            respDTO.setCategory(category);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            respDTO.setStatus("failed to delete, enter valid ID");
        }
        return respDTO;
    }
}
