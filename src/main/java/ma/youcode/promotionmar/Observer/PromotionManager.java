package ma.youcode.promotionmar.Observer;

import org.springframework.stereotype.Component;

@Component
public class PromotionManager implements PromotionListener{

    @Override
    public void notifyPromotion() {
        System.out.println("PromotionManager received promotion notification.");
    }
}
