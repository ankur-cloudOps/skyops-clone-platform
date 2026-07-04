package com.skyops.backend.drone.service;

import com.skyops.backend.drone.entity.Drone;

import java.util.List;
import java.util.Optional;

public interface DroneService {

    List<Drone> getAllDrones();

    Optional<Drone> getDroneById(Long id);

    Drone createDrone(Drone drone);

    Drone updateDrone(Long id, Drone drone);

    void deleteDrone(Long id);

}