package com.skyops.backend.dashboard.service.impl;

import com.skyops.backend.dashboard.dto.DashboardResponse;
import com.skyops.backend.dashboard.dto.DashboardStats;
import com.skyops.backend.dashboard.dto.FleetStatus;
import com.skyops.backend.dashboard.dto.MissionActivity;
import com.skyops.backend.dashboard.dto.RecentMission;
import com.skyops.backend.dashboard.service.DashboardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Override
    public DashboardResponse getDashboard() {

        return DashboardResponse.builder()
                .stats(buildStats())
                .fleetStatus(buildFleetStatus())
                .missionActivity(buildMissionActivity())
                .recentMissions(buildRecentMissions())
                .build();
    }

    private DashboardStats buildStats() {

        return DashboardStats.builder()
                .totalDrones(124)
                .activeMissions(18)
                .registeredPilots(56)
                .alerts(3)
                .build();
    }

    private FleetStatus buildFleetStatus() {

        return FleetStatus.builder()
                .available(84)
                .flying(26)
                .maintenance(14)
                .build();
    }

    private List<MissionActivity> buildMissionActivity() {

        return List.of(
                MissionActivity.builder()
                        .time("10:15 AM")
                        .message("Mission DG-1024 started")
                        .build(),

                MissionActivity.builder()
                        .time("09:45 AM")
                        .message("Drone SKY-007 completed inspection")
                        .build(),

                MissionActivity.builder()
                        .time("09:10 AM")
                        .message("Pilot assigned to Mission DG-1023")
                        .build()
        );
    }

    private List<RecentMission> buildRecentMissions() {

        return List.of(

                RecentMission.builder()
                        .missionId("DG-1024")
                        .drone("DJI Matrice 350")
                        .pilot("Rahul Sharma")
                        .status("IN_PROGRESS")
                        .build(),

                RecentMission.builder()
                        .missionId("DG-1023")
                        .drone("DJI Mavic 3")
                        .pilot("Ankit Verma")
                        .status("COMPLETED")
                        .build(),

                RecentMission.builder()
                        .missionId("DG-1022")
                        .drone("Parrot Anafi")
                        .pilot("Amit Singh")
                        .status("SCHEDULED")
                        .build()
        );
    }
}
