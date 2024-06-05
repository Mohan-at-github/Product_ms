package com.example.product_service.Controllers;

import com.example.product_service.Controllers.DTOs.Product.*;
import com.example.product_service.Models.Product;
import com.example.product_service.Services.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/products")
public class ProductController  {
   private ProductService productService;
   @Autowired

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    private CreateProductResponseDTO CreateProduct(@RequestBody CreateProductRequestDTO requestDTO){
      CreateProductResponseDTO productResponseDTO=new CreateProductResponseDTO();
      try{
          Product product=this.productService.createProduct(requestDTO.getTitle(), requestDTO.getPrice(), requestDTO.getDescription(), requestDTO.getImage(), requestDTO.getCategoryName());
          productResponseDTO.setMessage("Successfully Inserted");
          productResponseDTO.setResponseStatusDTO(ResponseStatusDTO.SUCCESS);
      }catch(Exception e){
          productResponseDTO.setMessage(e.getMessage());
          productResponseDTO.setResponseStatusDTO(ResponseStatusDTO.FAILURE);
      }
        return productResponseDTO;


    }
    @GetMapping
    public GetAllproductResponseDTO getAllProduct(){
       GetAllproductResponseDTO responseDTO=new GetAllproductResponseDTO();
      List<Product> products= productService.getAllProduct();
      responseDTO.setProductList(products);
      return responseDTO;
    }

    @GetMapping("/{ID}")
    public GetProductByIdResponseDTO getProductById(@PathVariable long ID){
       GetProductByIdResponseDTO productByID=new GetProductByIdResponseDTO();
       Product product=productService.getProductByID(ID);
       productByID.setProduct(product);
       return productByID;
    }
    //impl pending
    //1. update_product image+title
    //2. delete_product
    @PatchMapping("/{id}/updateimage")
    public UpdateProductIMGRespDTO updateProductIMG(@RequestBody UpdateproductIMGReqDTO reqDTO,@PathVariable int id) throws Exception {
        UpdateProductIMGRespDTO respDTO= new UpdateProductIMGRespDTO();
        String image=reqDTO.getImage();
        Product product=this.productService.updateImage(id, image);
        respDTO.setProduct(product);
        return respDTO;
    }

    @PutMapping("/{id}/updateprice")
    public UpdateProductPriceRespDTO updateProductIMG(@RequestBody UpdateproductPriceReqDTO reqDTO, @PathVariable int id) throws Exception {
        UpdateProductPriceRespDTO respDTO=new UpdateProductPriceRespDTO();
        int price =reqDTO.getPrice();
        Product product=this.productService.updatePrice(id, price);
        respDTO.setProduct(product);
        return respDTO;
    }
    @DeleteMapping({"/{id}"})
    public DeleteproductRespDTO deleteproductbyID(@PathVariable long id){
      DeleteproductRespDTO respDTO=new DeleteproductRespDTO();
      try{
          Product product=this.productService.deleteProductByID(id);
          respDTO.setProduct(product);
          respDTO.setStatus("Successfully Deleted");
      }
      catch(Exception e){
          System.out.println(e.getMessage());
          respDTO.setStatus("Failed to delete");
      }
       return respDTO;
    }
}
