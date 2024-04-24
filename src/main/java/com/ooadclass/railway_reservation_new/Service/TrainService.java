package com.ooadclass.railway_reservation_new.Service;

import com.ooadclass.railway_reservation_new.Model.Train;
import com.ooadclass.railway_reservation_new.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Train getTrainById(Long id) {
        return trainRepository.findById(id).orElse(null);
    }

    public Train saveTrain(Train train) {
        return trainRepository.save(train);
    }

    public void deleteTrain(Long id) {
        trainRepository.deleteById(id);
    }

    public Set<String> getAllStations() {
        List<Train> trains = trainRepository.findAll();
        return trains.stream()
                .flatMap(train -> Stream.of(train.getSource(), train.getDestination()))
                .distinct()
                .collect(Collectors.toSet());
    }

    public List<Train> getTrainsBySourceDestination(String source, String destination) {
        return trainRepository.findBySourceAndDestination(
                source, destination);
    }

    public Set<String> getDistinctSources() {
        return trainRepository.findDistinctSource();
    }

    public Set<String> getDistinctDestinations() {
        return trainRepository.findDistinctDestination();
    }
}