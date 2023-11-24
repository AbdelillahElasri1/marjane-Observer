package ma.youcode.promotionmar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminCenterDto {
    private Long id;
    private String name;
    private String email;
}
