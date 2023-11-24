package ma.youcode.promotionmar.services.implement;

import ma.youcode.promotionmar.dto.ProductDto;
import ma.youcode.promotionmar.entities.Product;
import ma.youcode.promotionmar.mapper.ProductDtoMapper;
import ma.youcode.promotionmar.repositories.ProductRepository;
import ma.youcode.promotionmar.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDtoMapper productDtoMapper;

    @Override
    public String saveProduct(ProductDto productDto) {
        Product product = productDtoMapper.apply(productDto);
        productRepository.save(product);
        return "product saved successfully";
    }

    @Override
    public List<ProductDto> findAllProduct() {
        return productRepository.findAll()
                .stream().map(productDtoMapper).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findProductById(long id) {
        Optional<Product> product = productRepository.findById(id);
//        ProductDto productDto = productDtoMapper.apply(product);
        if (product.isPresent()){
            return Optional.of(product.get());
        }
        return null;
    }
}
