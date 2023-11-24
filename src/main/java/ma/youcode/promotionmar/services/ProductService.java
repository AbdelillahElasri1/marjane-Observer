package ma.youcode.promotionmar.services;

import ma.youcode.promotionmar.dto.ProductDto;
import ma.youcode.promotionmar.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    String saveProduct(ProductDto productDto);
    List<ProductDto> findAllProduct();

    Optional<Product> findProductById(long id);

}
