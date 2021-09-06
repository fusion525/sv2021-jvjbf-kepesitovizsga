package training360.guinessapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import training360.guinessapp.WorldRecord;

public interface WorldRecordRepository extends JpaRepository<WorldRecord, Long> {

    @Query(value = "SELECT w from WorldRecord w where w.recorderId = :id order by w.dateOfRecord")
    WorldRecord getRecordByRecorder(long id);

}
