package ma.youcode.promotionmar.Observer;

import ma.youcode.promotionmar.dto.PromotionGetDto;
import org.springframework.context.ApplicationEvent;


public class PromotionEvent  extends ApplicationEvent {
    private final PromotionGetDto promotionGetDto;

    public PromotionEvent(Object source,PromotionGetDto promotionGetDto) {
        super(source);
        this.promotionGetDto = promotionGetDto;
    }
    public PromotionGetDto getPromotionGetDto(){
        return promotionGetDto;
    }
}
