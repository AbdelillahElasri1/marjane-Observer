package ma.youcode.promotionmar.services.implement;

import jakarta.persistence.EntityNotFoundException;
import ma.youcode.promotionmar.dto.PromotionGetDto;
import ma.youcode.promotionmar.dto.PromotionPostDto;
import ma.youcode.promotionmar.entities.AdminCenter;
import ma.youcode.promotionmar.entities.Product;
import ma.youcode.promotionmar.entities.Promotion;
import ma.youcode.promotionmar.mapper.AdminCenterDtoMapper;
import ma.youcode.promotionmar.mapper.ProductDtoMapper;
import ma.youcode.promotionmar.mapper.PromotionDtoMapper;
import ma.youcode.promotionmar.repositories.AdminCenterRepository;
import ma.youcode.promotionmar.repositories.ProductRepository;
import ma.youcode.promotionmar.repositories.PromotionRepository;
import ma.youcode.promotionmar.services.AdminCenterService;
import ma.youcode.promotionmar.services.ProductService;
import ma.youcode.promotionmar.services.PromotionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private PromotionDtoMapper promotionDtoMapper;
    @Autowired
    private ProductDtoMapper productDtoMapper;
    @Autowired
    private AdminCenterDtoMapper adminCenterDtoMapper;
    @Autowired
    private ProductService productService;
    @Autowired
    private AdminCenterService adminCenterService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AdminCenterRepository adminCenterRepository;
    @Autowired
    private ProductRepository productRepository;




    @Override
    public PromotionPostDto savePromotion(
            Long admin_id,
             Long product_id,
             PromotionPostDto promotionPostDto
    ) {
        AdminCenter adminCenter = adminCenterRepository.findById(admin_id)
                .orElseThrow(() -> new EntityNotFoundException("Admin Not found"));

        Product product = productRepository.findById(product_id).orElseThrow(() -> new EntityNotFoundException("Product not found"));

        Promotion promotion = modelMapper.map(promotionPostDto, Promotion.class);
        promotion.setAdminCenter(adminCenter);
        promotion.setProduct(product);

        Promotion savedPromotion = promotionRepository.save(promotion);
        PromotionPostDto savedPromotionDto = modelMapper.map(savedPromotion, PromotionPostDto.class);
        return savedPromotionDto;
    }

    @Override
    public List<PromotionGetDto> findAllPromotions() {
        return promotionRepository.findAll()
                .stream().map(promotionDtoMapper)
                .collect(Collectors.toList());
    }
}
