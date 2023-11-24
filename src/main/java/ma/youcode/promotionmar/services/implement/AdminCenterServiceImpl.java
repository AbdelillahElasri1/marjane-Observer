package ma.youcode.promotionmar.services.implement;

import ma.youcode.promotionmar.entities.AdminCenter;
import ma.youcode.promotionmar.mapper.AdminCenterDtoMapper;
import ma.youcode.promotionmar.repositories.AdminCenterRepository;
import ma.youcode.promotionmar.services.AdminCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCenterServiceImpl implements AdminCenterService {
    @Autowired
    private AdminCenterRepository adminCenterRepository;
    @Autowired
    private AdminCenterDtoMapper adminCenterDtoMapper;
    @Override
    public AdminCenter saveAdminCenter(AdminCenter adminCenterDto) {
//        AdminCenter adminCenter = adminCenterDtoMapper.apply(adminCenterDto);
        return adminCenterRepository.save(adminCenterDto);
    }
}
