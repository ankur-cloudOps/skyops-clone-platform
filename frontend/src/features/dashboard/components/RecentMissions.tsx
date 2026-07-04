import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  Typography
} from "@mui/material";

export default function RecentMissions() {
  return (
    <>
      <Typography variant="h6" sx={{ mb: 2 }}>
        Recent Missions
      </Typography>

      <Table>

        <TableHead>

          <TableRow>
            <TableCell>Mission</TableCell>
            <TableCell>Drone</TableCell>
            <TableCell>Status</TableCell>
          </TableRow>

        </TableHead>

        <TableBody>

          <TableRow>
            <TableCell>DG-1024</TableCell>
            <TableCell>Matrice 350</TableCell>
            <TableCell>Running</TableCell>
          </TableRow>

        </TableBody>

      </Table>
    </>
  );
}