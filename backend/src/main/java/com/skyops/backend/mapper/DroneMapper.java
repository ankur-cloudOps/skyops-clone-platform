package com.skyops.backend.mapper;

import com.skyops.backend.dto.drone.DroneRequest;
import com.skyops.backend.dto.drone.DroneResponse;
import com.skyops.backend.entity.Drone;
import org.springframework.stereotype.Component;

@Component
public class DroneMapper {

    public Drone toEntity(DroneRequest request) {

        return Drone.builder()
                .registrationNumber(request.getRegistrationNumber())
                .serialNumber(request.getSerialNumber())
                .manufacturer(request.getManufacturer())
                .model(request.getModel())
                .category(request.getCategory())
                .weight(request.getWeight())
                .status(request.getStatus())
                .build();
    }

    public DroneResponse toResponse(Drone drone) {

        return DroneResponse.builder()
                .id(drone.getId())
                .registrationNumber(drone.getRegistrationNumber())
                .serialNumber(drone.getSerialNumber())
                .manufacturer(drone.getManufacturer())
                .model(drone.getModel())
                .category(drone.getCategory())
                .weight(drone.getWeight())
                .status(drone.getStatus())
                .createdAt(drone.getCreatedAt())
                .updatedAt(drone.getUpdatedAt())
                .build();
    }

    public void updateDroneFromRequest(DroneRequest request, Drone drone) {

        drone.setRegistrationNumber(request.getRegistrationNumber());
        drone.setSerialNumber(request.getSerialNumber());
        drone.setManufacturer(request.getManufacturer());
        drone.setModel(request.getModel());
        drone.setCategory(request.getCategory());
        drone.setWeight(request.getWeight());
        drone.setStatus(request.getStatus());
    }
}
