package ma.youcode.promotionmar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductDto {
   private Long id;
   private String name;
   private double price;
}
