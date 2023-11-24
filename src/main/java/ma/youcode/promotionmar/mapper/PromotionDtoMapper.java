package ma.youcode.promotionmar.mapper;

import ma.youcode.promotionmar.dto.PromotionGetDto;
import ma.youcode.promotionmar.dto.PromotionPostDto;
import ma.youcode.promotionmar.entities.AdminCenter;
import ma.youcode.promotionmar.entities.Product;
import ma.youcode.promotionmar.entities.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PromotionDtoMapper implements Function<Promotion, PromotionGetDto> {
    private final ProductDtoMapper productDtoMapper;

    private final AdminCenterDtoMapper adminCenterDtoMapper;

    public PromotionDtoMapper(ProductDtoMapper productDtoMapper, AdminCenterDtoMapper adminCenterDtoMapper) {
        this.productDtoMapper = productDtoMapper;
        this.adminCenterDtoMapper = adminCenterDtoMapper;
    }

    @Override
    public PromotionGetDto apply(Promotion promotion) {
        return new PromotionGetDto(
                promotion.getId(),
                promotion.getCreatedDate(),
                promotion.getStartDate(),
                promotion.getEndDate(),
                promotion.getDiscountPercentage(),
                promotion.getPromotionDescription(),
                promotion.isActive(),
                promotion.getPromotionType(),
                productDtoMapper.apply(promotion.getProduct()),
                adminCenterDtoMapper.apply(promotion.getAdminCenter())

        );
    }

    public Promotion apply(PromotionPostDto promotionPostDto) {
        return new Promotion(
                promotionPostDto.getId(),
                promotionPostDto.getCreatedDate(),
                promotionPostDto.getStartDate(),
                promotionPostDto.getEndDate(),
                promotionPostDto.getDiscountPercentage(),
                promotionPostDto.getPromotionDescription(),
                promotionPostDto.isActive()

        );
    }
}
