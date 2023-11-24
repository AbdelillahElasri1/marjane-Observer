package ma.youcode.promotionmar.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "admin_center")
public class AdminCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String password_confirmated;

    @OneToMany(mappedBy = "adminCenter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Promotion> promotions;

    public AdminCenter(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
