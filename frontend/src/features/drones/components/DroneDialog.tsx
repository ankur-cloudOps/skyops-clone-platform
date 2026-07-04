import { useState } from "react";
import axios from "axios";

import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  Button,
  TextField,
  MenuItem,
  Stack
} from "@mui/material";

type Props = {
  open: boolean;
  onClose: () => void;
  onSuccess: () => void;
};

export default function DroneDialog({
  open,
  onClose,
  onSuccess
}: Props) {
  const [form, setForm] = useState({
    manufacturer: "",
    model: "",
    category: "MEDIUM",
    registrationNumber: "",
    serialNumber: "",
    status: "ACTIVE",
    weight: 1
  });

  async function saveDrone() {
    try {
      await axios.post(
        "http://localhost:8080/api/v1/drones",
        form
      );

      onSuccess();
      onClose();

      setForm({
        manufacturer: "",
        model: "",
        category: "MEDIUM",
        registrationNumber: "",
        serialNumber: "",
        status: "ACTIVE",
        weight: 1
      });
    } catch (error) {
      console.error(error);
    }
  }

  return (
    <Dialog
      open={open}
      onClose={onClose}
      maxWidth="sm"
      fullWidth
    >
      <DialogTitle>Add Drone</DialogTitle>

      <DialogContent>
        <Stack
          spacing={2}
          sx={{ mt: 1 }}
        >
          <TextField
            label="Manufacturer"
            fullWidth
            value={form.manufacturer}
            onChange={(e) =>
              setForm({
                ...form,
                manufacturer: e.target.value
              })
            }
          />

          <TextField
            label="Model"
            fullWidth
            value={form.model}
            onChange={(e) =>
              setForm({
                ...form,
                model: e.target.value
              })
            }
          />

          <TextField
            select
            label="Category"
            fullWidth
            value={form.category}
            onChange={(e) =>
              setForm({
                ...form,
                category: e.target.value
              })
            }
          >
            <MenuItem value="NANO">NANO</MenuItem>
            <MenuItem value="MICRO">MICRO</MenuItem>
            <MenuItem value="SMALL">SMALL</MenuItem>
            <MenuItem value="MEDIUM">MEDIUM</MenuItem>
            <MenuItem value="LARGE">LARGE</MenuItem>
          </TextField>

          <TextField
            label="Registration Number"
            fullWidth
            value={form.registrationNumber}
            onChange={(e) =>
              setForm({
                ...form,
                registrationNumber: e.target.value
              })
            }
          />

          <TextField
            label="Serial Number"
            fullWidth
            value={form.serialNumber}
            onChange={(e) =>
              setForm({
                ...form,
                serialNumber: e.target.value
              })
            }
          />

          <TextField
            select
            label="Status"
            fullWidth
            value={form.status}
            onChange={(e) =>
              setForm({
                ...form,
                status: e.target.value
              })
            }
          >
            <MenuItem value="ACTIVE">ACTIVE</MenuItem>
            <MenuItem value="INACTIVE">INACTIVE</MenuItem>
            <MenuItem value="MAINTENANCE">MAINTENANCE</MenuItem>
          </TextField>

          <TextField
            type="number"
            label="Weight (kg)"
            fullWidth
            value={form.weight}
            onChange={(e) =>
              setForm({
                ...form,
                weight: Number(e.target.value)
              })
            }
          />
        </Stack>
      </DialogContent>

      <DialogActions>
        <Button onClick={onClose}>
          Cancel
        </Button>

        <Button
          variant="contained"
          onClick={saveDrone}
        >
          Save
        </Button>
      </DialogActions>
    </Dialog>
  );
}