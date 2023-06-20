package payments.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payments.service.domain.model.CardBrand;
import payments.service.exception.ItemNotFoundException;
import payments.service.repository.CardBrandRepository;

import java.util.List;

@Service
@Slf4j
public class CardBrandService {

    @Autowired
    private CardBrandRepository cardBrandRepository;

    public List<CardBrand> listAllCardBrands(){
        List<CardBrand> cardBrands = cardBrandRepository.findAll();
        log.info("{} items found", cardBrands.size());
        return cardBrands;
    }

    public CardBrand getCardBrandById(Long id) {
        CardBrand response = cardBrandRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("CardBrand for id: " + id + " not found"));

        log.info("cardBrand with id: {} found", id);
        return response;
    }

    public CardBrand insertCardBrand(CardBrand cardBrand) {
        CardBrand response = cardBrandRepository.save(cardBrand);
        log.info("Registry updated");
        return response;
    }
}
