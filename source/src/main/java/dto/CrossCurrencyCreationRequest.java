package dto;

import java.math.BigDecimal;

public class CrossCurrencyCreationRequest {
    private String currFrom;
    private String currTo;
    private BigDecimal rate;

    public String getCurrFrom() {
        return currFrom;
    }

    public void setCurrFrom(String currFrom) {
        this.currFrom = currFrom;
    }

    public String getCurrTo() {
        return currTo;
    }

    public void setCurrTo(String currTo) {
        this.currTo = currTo;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
