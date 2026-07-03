package com.skyops.backend.controller;

import com.skyops.backend.dto.drone.DroneRequest;
import com.skyops.backend.dto.drone.DroneResponse;
import com.skyops.backend.service.DroneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drones")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DroneController {

    private final DroneService droneService;

    @PostMapping
    public ResponseEntity<DroneResponse> createDrone(
            @Valid @RequestBody DroneRequest request) {

        return new ResponseEntity<>(
                droneService.createDrone(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<DroneResponse>> getAllDrones() {

        return ResponseEntity.ok(droneService.getAllDrones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DroneResponse> getDroneById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                droneService.getDroneById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DroneResponse> updateDrone(
            @PathVariable Long id,
            @Valid @RequestBody DroneRequest request) {

        return ResponseEntity.ok(
                droneService.updateDrone(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrone(
            @PathVariable Long id) {

        droneService.deleteDrone(id);

        return ResponseEntity.noContent().build();
    }
}
