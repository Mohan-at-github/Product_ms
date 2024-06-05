package com.example.product_service.Services;

import com.example.product_service.Models.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();
    public Product getProductByID(long ID);
    public Product createProduct(String title,String price,String description, String image,String category);
    public Product updateImage(long id, String image) throws Exception;
    public Product updatePrice(long id, int price) throws Exception;
    public Product deleteProductByID(long id) throws Exception;

}
