package com.example.product_service.Services;

import com.example.product_service.Models.Category;
import com.example.product_service.Models.Product;
import com.example.product_service.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;
    CategoryService categoryService;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService=categoryService;
    }

    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductByID(long ID) {
        Optional<Product> optionalProduct=this.productRepository.findById(ID);
        if(optionalProduct.isEmpty()) throw new NullPointerException();
        return optionalProduct.get();
    }

    @Override
    public Product createProduct(String title, String price, String description, String image, String categoryName) {
        Category category=  this.categoryService.createCategory(categoryName);
        Product product=new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(Integer.parseInt(price));
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product updateImage(long id, String image) throws Exception {

        Optional<Product> optionalProduct=productRepository.findById(id);
        if(optionalProduct.isEmpty()) throw new Exception("Invalid ID");
        Product product=optionalProduct.get();
        product.setImage(image);
        return productRepository.save(product);
    }

    @Override
    public Product updatePrice(long id, int price) throws Exception {
        Optional<Product> optionalProduct=productRepository.findById(id);
        if(optionalProduct.isEmpty()) throw new Exception("Invalid ID");
        Product product=optionalProduct.get();
        product.setPrice(price);
        return this.productRepository.save(product);
    }


    @Override
    public Product deleteProductByID(long id) throws Exception {
        Optional<Product> optionalProduct=this.productRepository.findById(id);
        if(optionalProduct.isEmpty()) throw new Exception();
        this.productRepository.deleteById(id);
        return optionalProduct.get();
    }

}

