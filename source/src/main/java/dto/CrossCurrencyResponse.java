package dto;

import java.math.BigDecimal;

public class CrossCurrencyResponse {
    private String currFrom;
    private String currTo;
    private BigDecimal rate;

    public String getCurrFrom() {
        return currFrom;
    }

    public CrossCurrencyResponse setCurrFrom(String currFrom) {
        this.currFrom = currFrom;
        return this;
    }

    public String getCurrTo() {
        return currTo;
    }

    public CrossCurrencyResponse setCurrTo(String currTo) {
        this.currTo = currTo;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public CrossCurrencyResponse setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }
}
