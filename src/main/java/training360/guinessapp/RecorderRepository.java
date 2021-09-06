package training360.guinessapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import training360.guinessapp.Recorder;
import java.util.Collection;

public interface RecorderRepository extends JpaRepository<Recorder,Long> {

    @Query(value = "SELECT r from Recorder r where r.name like 'B%' or r.name like '%e%' order by r.DateOfBirth desc")
    Collection<Recorder> listRecordersByNameB();

    @Query(value = "SELECT r.name from Recorder r where r.id = :id")
    String getRecorderName(long id);
}
