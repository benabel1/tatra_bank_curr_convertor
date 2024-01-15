package service;

import controller.RateRecordNotFoundAdvice;
import controller.RateRecordNotFoundException;
import data.RateRecord;
import dto.CrossCurrencyCreationRequest;
import dto.CrossCurrencyRequest;
import dto.CrossCurrencyResponse;
import org.springframework.stereotype.Service;
import repo.RateRecordsRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class ConvertorService {

    final RateRecordsRepository recordsRepository;

    public ConvertorService(RateRecordsRepository recordsRepository) {
        this.recordsRepository = recordsRepository;
    }

    public CrossCurrencyResponse findRateDetail(CrossCurrencyRequest request) throws RateRecordNotFoundException {
        CrossCurrencyResponse result;
        Optional<RateRecord> recordOrigin =  recordsRepository.findByCurrFromAndCurrTo(request.getCurrFrom(), request.getCurrTo());

        if(recordOrigin.isPresent()) {
            var record = recordOrigin.get();
            result = new CrossCurrencyResponse()
                    .setCurrFrom(request.getCurrFrom())
                    .setCurrTo(request.getCurrTo())
                    .setRate(record.getRate());
        } else {

            recordOrigin =  recordsRepository.findByCurrFromAndCurrTo(request.getCurrTo(), request.getCurrFrom());

            if (recordOrigin.isPresent()) {
                var record = recordOrigin.get();
                result = new CrossCurrencyResponse()
                        .setCurrFrom(request.getCurrFrom())
                        .setCurrTo(request.getCurrTo())
                        .setRate(BigDecimal.valueOf(1.00).divide(record.getRate(), 2, RoundingMode.UP));
            } else {
                throw new RateRecordNotFoundException("Not Record was found");
            }
        }

        return result;
    }

    public CrossCurrencyResponse createRate(CrossCurrencyCreationRequest request) {
        CrossCurrencyResponse result = null;
        Optional<RateRecord> recordOrigin =  recordsRepository.findByCurrFromAndCurrTo(request.getCurrFrom(), request.getCurrTo());

        if(!recordOrigin.isPresent()) {
            var f = new RateRecord().setCurrFrom(request.getCurrFrom()).setCurrTo(request.getCurrTo()).setRate(request.getRate());
            recordsRepository.save(f);
            return new CrossCurrencyResponse().setCurrFrom(f.getCurrFrom()).setCurrTo(f.getCurrTo()).setRate(f.getRate());
        }

        return result;
    }
}
