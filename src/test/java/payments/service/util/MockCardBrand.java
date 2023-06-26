package payments.service.util;

import payments.service.domain.model.CardBrand;

import java.time.LocalDateTime;

public class MockCardBrand {

    public static CardBrand mockCardBrand(){
        return CardBrand.builder()
                .id(1L)
                .name("MasterCard")
                .createdAt(LocalDateTime.of(2023, 6, 20, 9, 50))
                .updatedAt(LocalDateTime.of(2023, 6, 20, 9, 50))
                .build();
    }

}
