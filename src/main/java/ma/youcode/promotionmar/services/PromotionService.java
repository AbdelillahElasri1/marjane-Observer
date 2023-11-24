package ma.youcode.promotionmar.services;

import ma.youcode.promotionmar.dto.PromotionGetDto;
import ma.youcode.promotionmar.dto.PromotionPostDto;

import java.util.List;

public interface PromotionService {
    PromotionPostDto savePromotion(Long admin_id,Long product_id,PromotionPostDto promotionPostDto);
    List<PromotionGetDto> findAllPromotions();

}
