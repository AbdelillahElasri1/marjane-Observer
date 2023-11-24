package ma.youcode.promotionmar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.promotionmar.enums.PromotionType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionPostDto {
    private Long id;
    private String createdDate;
    private String startDate;
    private String endDate;
    private double discountPercentage;
    private String promotionDescription;
    private boolean isActive;
    private PromotionType promotionType;
    private int product_id;
    private int admin_id;
}
