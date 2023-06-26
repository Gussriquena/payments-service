package payments.service.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import payments.service.domain.model.CardBrand;
import payments.service.exception.ItemNotFoundException;
import payments.service.exception.SaveItemException;
import payments.service.repository.CardBrandRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static payments.service.util.MockCardBrand.mockCardBrand;

@ExtendWith(SpringExtension.class)
class CardBrandServiceTest {

    @Mock
    private CardBrandRepository cardBrandRepository;

    @InjectMocks
    private CardBrandService cardBrandService;

    @Test
    @DisplayName("When getCardBrandById, then return success")
    void when_getCardBrand_thenSuccess(){
        when(cardBrandRepository.findById(any())).thenReturn(Optional.of(mockCardBrand()));

        CardBrand cardBrand = cardBrandService.getCardBrandById(1L);

        assertEquals(mockCardBrand(), cardBrand);
        verify(cardBrandRepository, times(1)).findById(any());
    }

    @Test
    @DisplayName("When getCardBrandById, then throws ItemNotFoundException")
    void when_getCardBrand_thenThrowException(){
        when(cardBrandRepository.save(any())).thenThrow(new ItemNotFoundException("Item not found"));
        assertThrows(ItemNotFoundException.class, () -> cardBrandService.getCardBrandById(1L));
        verify(cardBrandRepository, times(1)).findById(any());
    }

    @Test
    @DisplayName("When insertUpdateCardBrand, then return success")
    void when_insertCardBrand_thenSuccess(){
        when(cardBrandRepository.save(any())).thenReturn(mockCardBrand());

        CardBrand cardBrand = cardBrandService.insertUpdateCardBrand(mockCardBrand());

        assertEquals(mockCardBrand(), cardBrand);
        verify(cardBrandRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("When insertUpdateCardBrand, then throws SaveItemException")
    void when_insertCardBrand_thenThrowsException(){
        when(cardBrandRepository.save(any())).thenThrow(new SaveItemException("Failed inserting"));
        assertThrows(SaveItemException.class, () -> cardBrandService.insertUpdateCardBrand(mockCardBrand()));
        verify(cardBrandRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("When insertUpdateCardBrand, then return success")
    void when_updateCardBrand_thenSuccess(){
        when(cardBrandRepository.findById(any())).thenReturn(Optional.of(mockCardBrand()));
        when(cardBrandRepository.save(any())).thenReturn(mockCardBrand());

        CardBrand cardBrand = cardBrandService.insertUpdateCardBrand(mockCardBrand());

        assertEquals(mockCardBrand(), cardBrand);
        verify(cardBrandRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("When listAllCardBrands, then return success")
    void when_listAllCardBrands_thenSuccess(){
        when(cardBrandRepository.findAll()).thenReturn(List.of(mockCardBrand()));

        List<CardBrand> cardBrands = cardBrandService.listAllCardBrands();

        assertEquals(List.of(mockCardBrand()), cardBrands);
        verify(cardBrandRepository, times(1)).findAll();
    }

}