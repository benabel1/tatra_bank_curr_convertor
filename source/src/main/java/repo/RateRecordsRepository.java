package repo;

import data.RateRecord;
import data.RateRecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RateRecordsRepository extends JpaRepository<RateRecord, RateRecordId> {
    @Query(value = "select * from RateRecord r where r.currFrom = ?1 and r.currTo = ?2", nativeQuery = true )
    Optional<RateRecord> findByIdsFromTo(String currFrom, String curTo);

    Optional<RateRecord> findByCurrFromAndCurrTo(String currFrom, String curTo);

}
