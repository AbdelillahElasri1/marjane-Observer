package ma.youcode.promotionmar.repositories;

import ma.youcode.promotionmar.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
