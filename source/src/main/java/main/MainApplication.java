package main;

import data.RateRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repo.RateRecordsRepository;

import java.math.BigDecimal;
import java.util.HashMap;

@SpringBootApplication
@EntityScan(basePackages = "data")
@ComponentScan(basePackages = {"service", "controller"})
@EnableJpaRepositories(basePackages = "repo")
@EnableAutoConfiguration
@Import(Setup.class)
public class MainApplication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    static HashMap<String, RateRecord> fakeDatabase = new HashMap<>();

//    public static void main(String[] args) {
//        fateDatabaseInitializer();
//        System.out.println("All rates:");
//        for (RateRecord record: fakeDatabase.values()) {
//            System.out.printf("%-3sx%3s %12.8f\n", record.getCurrFrom(), record.getCurrTo(), record.getRate());
//        }
//
//    }

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(MainApplication.class, args);
//
//        repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("UK").setRate(new BigDecimal("1.26")));
//        repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("POL").setRate(new BigDecimal("1.26")));
//        repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("CZK").setRate(new BigDecimal("1.26")));
//        repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("SWI").setRate(new BigDecimal("1.26")));
//        repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("PP").setRate(new BigDecimal("1.26")));
//        repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("BB").setRate(new BigDecimal("1.26")));

    }

    private static void fateDatabaseInitializer() {
        String another = "";
        //Hungary
        extracted("HU", 200.26f);
        //Poland
        extracted("PO", 100.20f);
        //UK
        extracted("UK", 0.96f);
        //Switzerland
        extracted("SWI", 1.12f);
    }

    private static void extracted(String countryCurrNote, double val) {
        fakeDatabase.put(countryCurrNote + "-EU", new RateRecord()
                .setCurrFrom(countryCurrNote)
                .setCurrTo("EU").
                setRate(BigDecimal.valueOf(val)));
    }
}