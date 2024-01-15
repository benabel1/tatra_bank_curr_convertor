package main;

import data.RateRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repo.RateRecordsRepository;

import java.math.BigDecimal;
import java.util.logging.Logger;

@Configuration
public class Setup {

    Logger log;

//    @Bean
//    CommandLineRunner initDatabase(RateRecordsRepository repository) {
//
//        return args -> {
//            log.info("Preloading " + repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("UK").setRate(new BigDecimal("1.26"))));
//            log.info("Preloading " + repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("POL").setRate(new BigDecimal("1.26"))));
//            log.info("Preloading " + repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("CZK").setRate(new BigDecimal("1.26"))));
//            log.info("Preloading " + repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("SWI").setRate(new BigDecimal("1.26"))));
//            log.info("Preloading " + repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("PP").setRate(new BigDecimal("1.26"))));
//            log.info("Preloading " + repository.save(new RateRecord().setCurrFrom("EU").setCurrTo("BB").setRate(new BigDecimal("1.26"))));
//        };
//    }


}
