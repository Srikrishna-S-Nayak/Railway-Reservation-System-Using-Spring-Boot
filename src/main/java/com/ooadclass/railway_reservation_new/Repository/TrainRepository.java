package com.ooadclass.railway_reservation_new.Repository;

import com.ooadclass.railway_reservation_new.Model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findBySourceAndDestination(String source, String destination);

    @Query("SELECT DISTINCT t.source FROM Train t")
    Set<String> findDistinctSource();

    @Query("SELECT DISTINCT t.destination FROM Train t")
    Set<String> findDistinctDestination();

}