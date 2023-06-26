package payments.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payments.service.domain.model.CardBrand;
import payments.service.service.CardBrandService;

import java.util.List;

@RestController
@RequestMapping("api/v1/card-brand")
public class CardBrandController {

    @Autowired
    private CardBrandService cardBrandService;

    @GetMapping
    public ResponseEntity<?> listAllCardBrands(){
        List<CardBrand> cardBrands = cardBrandService.listAllCardBrands();
        return ResponseEntity.ok().body(cardBrands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCardBrandById(@PathVariable("id") Long id){
        CardBrand cardBrand = cardBrandService.getCardBrandById(id);
        return ResponseEntity.ok().body(cardBrand);
    }

    @PostMapping
    public ResponseEntity<?> insertUpdateCardBrand(@RequestBody CardBrand cardBrand){
        CardBrand cardBrandResponse = cardBrandService.insertUpdateCardBrand(cardBrand);
        return ResponseEntity.ok().body(cardBrandResponse);
    }
}
