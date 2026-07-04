package com.skyops.backend.drone.repository;

import com.skyops.backend.drone.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

    Optional<Drone> findBySerialNumber(String serialNumber);

    Optional<Drone> findByRegistrationNumber(String registrationNumber);

    boolean existsBySerialNumber(String serialNumber);

    boolean existsByRegistrationNumber(String registrationNumber);

}