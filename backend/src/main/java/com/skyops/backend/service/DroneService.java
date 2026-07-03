package com.skyops.backend.service;

import com.skyops.backend.dto.drone.DroneRequest;
import com.skyops.backend.dto.drone.DroneResponse;

import java.util.List;

public interface DroneService {

    DroneResponse createDrone(DroneRequest request);

    List<DroneResponse> getAllDrones();

    DroneResponse getDroneById(Long id);

    DroneResponse updateDrone(Long id, DroneRequest request);

    void deleteDrone(Long id);

}
