package data;

//from 3.+
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

//for spring boot bellow 3, 2+
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;

@Entity
@IdClass(RateRecordId.class)
public class RateRecord {

    @Id
    private String currFrom;
    @Id
    private String currTo;
    private BigDecimal rate;

    public String getCurrFrom() {
        return currFrom;
    }

    public RateRecord setCurrFrom(String currFrom) {
        this.currFrom = currFrom;
        return this;
    }

    public String getCurrTo() {
        return currTo;
    }

    public RateRecord setCurrTo(String currTo) {
        this.currTo = currTo;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public RateRecord setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

}
