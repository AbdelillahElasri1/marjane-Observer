package ma.youcode.promotionmar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.promotionmar.enums.PromotionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createdDate;
    private String startDate;
    private String endDate;
    private double discountPercentage;
    private String promotionDescription;
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    private PromotionType promotionType;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminCenter adminCenter;

    public Promotion(Long id, String createdDate, String startDate, String endDate, double discountPercentage, String promotionDescription, boolean isActive) {
        this.id = id;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountPercentage = discountPercentage;
        this.promotionDescription = promotionDescription;
        this.isActive = isActive;
    }
}
