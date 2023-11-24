package ma.youcode.promotionmar.serviceTest;

import ma.youcode.promotionmar.dto.ProductDto;
import ma.youcode.promotionmar.entities.Product;
import ma.youcode.promotionmar.mapper.ProductDtoMapper;
import ma.youcode.promotionmar.repositories.ProductRepository;
import ma.youcode.promotionmar.services.implement.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductDtoMapper productDtoMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testSaveProduct() {
        ProductDto productDto = new ProductDto();
        Product product = new Product();
        productDto.setId(1L);
        productDto.setName("Toshiba");
        productDto.setPrice(39.99);

        when(productDtoMapper.apply(productDto)).thenReturn(product);

        String result = productService.saveProduct(productDto);

        assertEquals("product saved successfully", result);
        verify(productRepository, times(1)).save(product);
    }
    @Test
    public void testFindAllProduct() {
        Product product1 = new Product(1L,"dell pc",29.80);
        Product product2 = new Product(2L,"Legion pc",19.99);

        List<Product> productList = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(productList);
        when(productDtoMapper.apply(product1)).thenReturn(new ProductDto());
        when(productDtoMapper.apply(product2)).thenReturn(new ProductDto());

        List<ProductDto> result = productService.findAllProduct();

        assertEquals(2, result.size());
    }

    @Test
    public void testFindProductById() {
        long productId = 1L;
        Product product = new Product();
        product.setId(1L);
        product.setName("mac book pro");
        product.setPrice(99.99);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
//        when(productDtoMapper.apply(product)).thenReturn(new ProductDto(/* provide necessary values */));

        Optional<Product> result = productService.findProductById(productId);

        assertTrue(result.isPresent());
    }
}
