package ma.youcode.promotionmar.mapper;

import ma.youcode.promotionmar.dto.AdminCenterDto;
import ma.youcode.promotionmar.entities.AdminCenter;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AdminCenterDtoMapper implements Function<AdminCenter, AdminCenterDto> {
    @Override
    public AdminCenterDto apply(AdminCenter adminCenter) {
        return new AdminCenterDto(
                adminCenter.getId(),
                adminCenter.getName(),
                adminCenter.getEmail()
        );
    }

    public AdminCenter apply(AdminCenterDto adminCenterDto) {
        return new AdminCenter(
                adminCenterDto.getId(),
                adminCenterDto.getName(),
                adminCenterDto.getEmail()
        );
    }
}
