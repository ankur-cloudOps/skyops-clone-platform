import {
  List,
  ListItem,
  Typography
} from "@mui/material";

export default function MissionActivity() {
  return (
    <>
      <Typography variant="h6" sx={{ mb: 2 }}>
        Mission Activity
      </Typography>

      <List>

        <ListItem>
          Mission DG-1024 Started
        </ListItem>

        <ListItem>
          Drone SKY-007 Completed
        </ListItem>

        <ListItem>
          Pilot Assigned
        </ListItem>

      </List>
    </>
  );
}