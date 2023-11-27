package ma.youcode.promotionmar.services.implement;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import ma.youcode.promotionmar.Observer.PromotionEvent;
import ma.youcode.promotionmar.dto.ProductDto;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PromotionDtoMapper promotionDtoMapper;

    @Autowired
    private AdminCenterRepository adminCenterRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    Logger logger = LoggerFactory.getLogger(PromotionServiceImpl.class);
    





    @Override
    public PromotionPostDto savePromotion(
            Long admin_id,
             Long product_id,
             PromotionPostDto promotionPostDto
    ) {
        logger.info("add promotion{}", promotionPostDto);
        AdminCenter adminCenter = adminCenterRepository.findById(admin_id)
                .orElseThrow(() -> new EntityNotFoundException("Admin Not found"));

        Product product = productRepository.findById(product_id).orElseThrow(() -> new EntityNotFoundException("Product not found"));

        Promotion promotion = modelMapper.map(promotionPostDto, Promotion.class);
        promotion.setAdminCenter(adminCenter);
        promotion.setProduct(product);

        Promotion savedPromotion = promotionRepository.save(promotion);
        PromotionPostDto savedPromotionDto = modelMapper.map(savedPromotion, PromotionPostDto.class);

        eventPublisher.publishEvent(new PromotionEvent(this,savedPromotionDto));
        log.info("new notification: new promotion added{}",savedPromotionDto);

        return savedPromotionDto;
    }

    @Override
    public List<PromotionGetDto> findAllPromotions() {
        logger.info("get All Promotion");
        return promotionRepository.findAll()
                .stream().map(promotionDtoMapper)
                .collect(Collectors.toList());
    }
}
