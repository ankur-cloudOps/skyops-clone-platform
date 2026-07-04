export interface DashboardResponse {
  stats: {
    totalDrones: number;
    activeMissions: number;
    registeredPilots: number;
    alerts: number;
  };

  fleetStatus: {
    available: number;
    flying: number;
    maintenance: number;
  };

  missionActivity: {
    time: string;
    message: string;
  }[];

  recentMissions: {
    missionId: string;
    drone: string;
    pilot: string;
    status: string;
  }[];
}