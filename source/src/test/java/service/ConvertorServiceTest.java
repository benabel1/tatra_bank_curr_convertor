package service;

import controller.RateRecordNotFoundException;
import data.RateRecord;
import dto.CrossCurrencyRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repo.RateRecordsRepository;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ConvertorServiceTest {
    @Mock
    RateRecordsRepository recordsRepository;

    @InjectMocks
    ConvertorService convertorService;

    @Test
    void contextLoads() {
        assertThat(recordsRepository).isNotNull();
        assertThat(convertorService).isNotNull();
    }

    @Test
    @DisplayName(value = "Test one way conversion rate")
    public void findRateFromToUK_EU() throws RateRecordNotFoundException {
        when(recordsRepository.findByIdsFromTo(eq("UK"), eq("EU")))
                .thenReturn(Optional.ofNullable(new RateRecord().setCurrFrom("UK").setCurrTo("EU")
                        .setRate(new BigDecimal("2.21"))));


        CrossCurrencyRequest request = new CrossCurrencyRequest()
                .setCurrFrom("UK")
                .setCurrTo("EU");
        var result = convertorService.findRateDetail(request);

        assertEquals(result.getCurrFrom(), "UK");
        assertEquals(result.getCurrTo(), "EU");
        assertEquals(result.getRate(), new BigDecimal("2.21"));
    }

    @Test
    @DisplayName(value = "Test reverse way conversion rate")
    public void findRateFromToEU_UK() throws RateRecordNotFoundException {
        when(recordsRepository.findByIdsFromTo(eq("EU"), eq("UK")))
                .thenReturn(Optional.empty());
        when(recordsRepository.findByIdsFromTo(eq("UK"), eq("EU")))
                .thenReturn(Optional.ofNullable(new RateRecord().setCurrFrom("EU").setCurrTo("UK")
                        .setRate(new BigDecimal("2.21"))));

        CrossCurrencyRequest request = new CrossCurrencyRequest()
                .setCurrFrom("EU")
                .setCurrTo("UK");
        var result = convertorService.findRateDetail(request);

        assertEquals(result.getCurrFrom(), "EU");
        assertEquals(result.getCurrTo(), "UK");
        assertEquals(result.getRate(), new BigDecimal("0.46"));
    }

}