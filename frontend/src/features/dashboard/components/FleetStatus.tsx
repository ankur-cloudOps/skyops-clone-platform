import { Typography } from "@mui/material";

export default function FleetStatus() {
  return (
    <>
      <Typography variant="h6">
        Fleet Status
      </Typography>

      <Typography sx={{ mt: 2 }}>
        Available : 84
      </Typography>

      <Typography>
        Flying : 26
      </Typography>

      <Typography>
        Maintenance : 14
      </Typography>
    </>
  );
}