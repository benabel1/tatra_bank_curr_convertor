package data;

import java.io.Serializable;

public class RateRecordId implements Serializable {
    private String currFrom;
    private String currTo;

    public RateRecordId() {}

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
}
