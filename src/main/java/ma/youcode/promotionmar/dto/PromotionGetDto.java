package ma.youcode.promotionmar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.promotionmar.entities.AdminCenter;
import ma.youcode.promotionmar.entities.Product;
import ma.youcode.promotionmar.entities.Promotion;
import ma.youcode.promotionmar.enums.PromotionType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionGetDto {
    private Long id;
    private String createdDate;
    private String startDate;
    private String endDate;
    private double discountPercentage;
    private String promotionDescription;
    private boolean isActive;
    private PromotionType promotionType;
    private ProductDto product;
    private AdminCenterDto adminCenter;
}
