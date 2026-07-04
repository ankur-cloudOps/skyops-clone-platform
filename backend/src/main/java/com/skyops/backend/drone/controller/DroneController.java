package com.skyops.backend.drone.controller;

import com.skyops.backend.drone.entity.Drone;
import com.skyops.backend.drone.service.DroneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drones")
@CrossOrigin(origins = "http://localhost:5173")
public class DroneController {

    private final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @GetMapping
    public ResponseEntity<List<Drone>> getAllDrones() {
        return ResponseEntity.ok(droneService.getAllDrones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drone> getDroneById(@PathVariable Long id) {
        return droneService.getDroneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Drone> createDrone(@RequestBody Drone drone) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(droneService.createDrone(drone));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drone> updateDrone(
            @PathVariable Long id,
            @RequestBody Drone drone) {

        return ResponseEntity.ok(
                droneService.updateDrone(id, drone)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrone(@PathVariable Long id) {

        droneService.deleteDrone(id);

        return ResponseEntity.noContent().build();
    }
}