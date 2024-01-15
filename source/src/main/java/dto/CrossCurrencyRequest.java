package dto;

public class CrossCurrencyRequest {
    private String currFrom;
    private String currTo;

    public String getCurrFrom() {
        return currFrom;
    }

    public CrossCurrencyRequest setCurrFrom(String currFrom) {
        this.currFrom = currFrom;
        return this;
    }

    public String getCurrTo() {
        return currTo;
    }

    public CrossCurrencyRequest setCurrTo(String currTo) {
        this.currTo = currTo;
        return this;
    }
}
