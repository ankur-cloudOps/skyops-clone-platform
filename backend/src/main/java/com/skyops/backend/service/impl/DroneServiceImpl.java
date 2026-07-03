package com.skyops.backend.service.impl;

import com.skyops.backend.dto.drone.DroneRequest;
import com.skyops.backend.dto.drone.DroneResponse;
import com.skyops.backend.entity.Drone;
import com.skyops.backend.exception.ResourceNotFoundException;
import com.skyops.backend.mapper.DroneMapper;
import com.skyops.backend.repository.DroneRepository;
import com.skyops.backend.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;
    private final DroneMapper droneMapper;

    @Override
    public DroneResponse createDrone(DroneRequest request) {

        if (droneRepository.existsByRegistrationNumber(request.getRegistrationNumber())) {
            throw new IllegalArgumentException("Drone with registration number already exists.");
        }

        Drone drone = droneMapper.toEntity(request);

        Drone savedDrone = droneRepository.save(drone);

        return droneMapper.toResponse(savedDrone);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DroneResponse> getAllDrones() {

        return droneRepository.findAll()
                .stream()
                .map(droneMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DroneResponse getDroneById(Long id) {

        Drone drone = droneRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Drone not found with id: " + id));

        return droneMapper.toResponse(drone);
    }

    @Override
    public DroneResponse updateDrone(Long id, DroneRequest request) {

        Drone drone = droneRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Drone not found with id: " + id));

        droneMapper.updateDroneFromRequest(request, drone);

        Drone updatedDrone = droneRepository.save(drone);

        return droneMapper.toResponse(updatedDrone);
    }

    @Override
    public void deleteDrone(Long id) {

        Drone drone = droneRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Drone not found with id: " + id));

        droneRepository.delete(drone);
    }
}
