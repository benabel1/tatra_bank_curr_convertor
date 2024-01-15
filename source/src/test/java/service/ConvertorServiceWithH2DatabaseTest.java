package service;

import controller.RateRecordNotFoundException;
import data.RateRecord;
import dto.CrossCurrencyRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import repo.RateRecordsRepository;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {ConvertorService.class, RateRecordsRepository.class})
public class ConvertorServiceWithH2DatabaseTest {
    @Autowired
    RateRecordsRepository recordsRepository;

    @Autowired
    ConvertorService convertorService;

    @Test
    void contextLoads() {
        assertThat(recordsRepository).isNotNull();
        assertThat(convertorService).isNotNull();
    }

    @BeforeTestClass
    public void init() {
        var rates = new ArrayList<RateRecord>();
        rates.add(new RateRecord().setCurrFrom("EU").setCurrTo("UK").setRate(new BigDecimal("0.89")));
        rates.add(new RateRecord().setCurrFrom("EU").setCurrTo("SWI").setRate(new BigDecimal("1.11")));
        rates.add(new RateRecord().setCurrFrom("EU").setCurrTo("POL").setRate(new BigDecimal("14.02")));

        recordsRepository.saveAll(rates);
    }

    @Test
    public void findRateFromToUK_EU() throws RateRecordNotFoundException {

        CrossCurrencyRequest request = new CrossCurrencyRequest()
                .setCurrFrom("UK")
                .setCurrTo("EU");
        var result = convertorService.findRateDetail(request);

        assertEquals(result.getCurrFrom(), "UK");
        assertEquals(result.getCurrTo(), "EU");
        assertEquals(result.getRate(), new BigDecimal("2.21"));
    }

    @Test
    public void findRateFromToEU_UK() throws RateRecordNotFoundException {
        CrossCurrencyRequest request = new CrossCurrencyRequest()
                .setCurrFrom("EU")
                .setCurrTo("UK");
        var result = convertorService.findRateDetail(request);

        assertEquals(result.getCurrFrom(), "EU");
        assertEquals(result.getCurrTo(), "UK");
        assertEquals(result.getRate(), new BigDecimal("0.46"));
    }

}