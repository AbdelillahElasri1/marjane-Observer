package ma.youcode.promotionmar.mapper;

import ma.youcode.promotionmar.dto.ProductDto;
import ma.youcode.promotionmar.entities.Product;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class ProductDtoMapper implements Function<Product, ProductDto> {
    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    public Product apply(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice()
        );
    }
}
