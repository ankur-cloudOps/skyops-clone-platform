import {
  Grid,
  Paper,
  Typography
} from "@mui/material";

import StatCard from "../components/StatCard";
import FleetStatus from "../components/FleetStatus";
import MissionActivity from "../components/MissionActivity";
import RecentMissions from "../components/RecentMissions";

export default function Dashboard() {
  return (
    <>

      <Typography variant="h4" sx={{ mb: 3, fontWeight: 700 }}>
        Dashboard
      </Typography>

      <Grid container spacing={3}>

        <Grid size={{ xs: 12, md: 3 }}>
          <StatCard title="Drone Fleet" value="124" color="#2563EB" />
        </Grid>

        <Grid size={{ xs: 12, md: 3 }}>
          <StatCard title="Active Missions" value="18" color="#22C55E" />
        </Grid>

        <Grid size={{ xs: 12, md: 3 }}>
          <StatCard title="Pilots" value="56" color="#F59E0B" />
        </Grid>

        <Grid size={{ xs: 12, md: 3 }}>
          <StatCard title="Alerts" value="3" color="#EF4444" />
        </Grid>

        <Grid size={{ xs: 12, md: 8 }}>
          <Paper sx={{ p: 3 }}>
            <MissionActivity />
          </Paper>
        </Grid>

        <Grid size={{ xs: 12, md: 4 }}>
          <Paper sx={{ p: 3 }}>
            <FleetStatus />
          </Paper>
        </Grid>

        <Grid size={{ xs: 12 }}>
          <Paper sx={{ p: 3 }}>
            <RecentMissions />
          </Paper>
        </Grid>

      </Grid>

    </>
  );
}
