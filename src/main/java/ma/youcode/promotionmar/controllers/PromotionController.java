package ma.youcode.promotionmar.controllers;

import ma.youcode.promotionmar.dto.PromotionGetDto;
import ma.youcode.promotionmar.dto.PromotionPostDto;
import ma.youcode.promotionmar.entities.Promotion;
import ma.youcode.promotionmar.mapper.PromotionDtoMapper;
import ma.youcode.promotionmar.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotion")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;


    @PostMapping
    public ResponseEntity<PromotionPostDto> savePromotion(
            @RequestParam Long admin_id,
            @RequestParam Long product_id,
            @RequestBody PromotionPostDto promotionPostDto
    ){
        PromotionPostDto savedPromotion = promotionService.savePromotion(admin_id,product_id,promotionPostDto);

        return new ResponseEntity<>(savedPromotion, HttpStatus.CREATED);
    }
    @GetMapping
    public List<PromotionGetDto> findAllUsers(){
        return promotionService.findAllPromotions();
    }

}
