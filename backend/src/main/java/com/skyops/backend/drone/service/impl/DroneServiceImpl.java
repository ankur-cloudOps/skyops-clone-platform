package com.skyops.backend.drone.service.impl;

import com.skyops.backend.drone.entity.Drone;
import com.skyops.backend.drone.repository.DroneRepository;
import com.skyops.backend.drone.service.DroneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    @Override
    public Optional<Drone> getDroneById(Long id) {
        return droneRepository.findById(id);
    }

    @Override
    public Drone createDrone(Drone drone) {

        if (droneRepository.existsBySerialNumber(drone.getSerialNumber())) {
            throw new RuntimeException("Serial number already exists.");
        }

        if (droneRepository.existsByRegistrationNumber(drone.getRegistrationNumber())) {
            throw new RuntimeException("Registration number already exists.");
        }

        return droneRepository.save(drone);
    }

    @Override
    public Drone updateDrone(Long id, Drone drone) {

        Drone existingDrone = droneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drone not found."));

        existingDrone.setManufacturer(drone.getManufacturer());
        existingDrone.setModel(drone.getModel());
        existingDrone.setCategory(drone.getCategory());
        existingDrone.setSerialNumber(drone.getSerialNumber());
        existingDrone.setRegistrationNumber(drone.getRegistrationNumber());
        existingDrone.setStatus(drone.getStatus());
        existingDrone.setWeight(drone.getWeight());
        existingDrone.setUpdatedAt(drone.getUpdatedAt());

        return droneRepository.save(existingDrone);
    }

    @Override
    public void deleteDrone(Long id) {

        Drone drone = droneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drone not found."));

        droneRepository.delete(drone);
    }
}