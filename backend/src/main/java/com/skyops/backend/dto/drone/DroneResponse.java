package com.skyops.backend.dto.drone;

import com.skyops.backend.common.enums.DroneCategory;
import com.skyops.backend.common.enums.DroneStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneResponse {

    private Long id;

    private String registrationNumber;

    private String serialNumber;

    private String manufacturer;

    private String model;

    private DroneCategory category;

    private BigDecimal weight;

    private DroneStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}