package com.skyops.backend.dto.drone;

import com.skyops.backend.common.enums.DroneCategory;
import com.skyops.backend.common.enums.DroneStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneRequest {

    @NotBlank(message = "Registration number is required")
    @Size(max = 50, message = "Registration number cannot exceed 50 characters")
    private String registrationNumber;

    @NotBlank(message = "Serial number is required")
    @Size(max = 100, message = "Serial number cannot exceed 100 characters")
    private String serialNumber;

    @NotBlank(message = "Manufacturer is required")
    @Size(max = 100, message = "Manufacturer cannot exceed 100 characters")
    private String manufacturer;

    @NotBlank(message = "Model is required")
    @Size(max = 100, message = "Model cannot exceed 100 characters")
    private String model;

    @NotNull(message = "Drone category is required")
    private DroneCategory category;

    @NotNull(message = "Weight is required")
    @DecimalMin(value = "0.01", message = "Weight must be greater than zero")
    private BigDecimal weight;

    @NotNull(message = "Drone status is required")
    private DroneStatus status;
}
