package controller;

import dto.CrossCurrencyCreationRequest;
import dto.CrossCurrencyRequest;
import dto.CrossCurrencyResponse;
import org.springframework.web.bind.annotation.*;
import service.ConvertorService;

@RestController
@RequestMapping(value = "services")
public class ConvertorController {

    private final ConvertorService service;

    public ConvertorController(ConvertorService service) {
        this.service = service;
    }

    @PostMapping(value = "rates")
    public CrossCurrencyResponse getRateDetails(@RequestBody CrossCurrencyRequest request) throws RateRecordNotFoundException {
        return service.findRateDetail(request);
    }

    @PostMapping(value = "insert")
    public CrossCurrencyResponse xreateRateDetails(@RequestBody CrossCurrencyCreationRequest request) throws RateRecordNotFoundException {
        return service.createRate(request);
    }

    @GetMapping(value = "info")
    public String getRateDetails() throws RateRecordNotFoundException {
        return "Hi";
    }
}
