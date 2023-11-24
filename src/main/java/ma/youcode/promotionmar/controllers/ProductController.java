package ma.youcode.promotionmar.controllers;

import ma.youcode.promotionmar.dto.ProductDto;
import ma.youcode.promotionmar.entities.Product;
import ma.youcode.promotionmar.mapper.ProductDtoMapper;
import ma.youcode.promotionmar.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDtoMapper productDtoMapper;

    @PostMapping
    public String saveProduct(@RequestBody ProductDto productDto){
        productService.saveProduct(productDto);
        return "product saved successfully";
    }
    @GetMapping
    public List<ProductDto> findAllProducts(){
        return productService.findAllProduct();
    }
    @GetMapping("{id}")
    public ProductDto findProductById(@PathVariable long id){
        Product product = productService.findProductById(id).orElseThrow();
        ProductDto productDto = productDtoMapper.apply(product);
        return productDto;
        }

}
