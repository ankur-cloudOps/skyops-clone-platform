package com.skyops.backend.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private DashboardStats stats;

    private FleetStatus fleetStatus;

    private List<MissionActivity> missionActivity;

    private List<RecentMission> recentMissions;

}
