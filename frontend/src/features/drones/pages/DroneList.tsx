import { useEffect, useState } from "react";

import {
  Paper,
  Typography,
  Button,
  Stack,
  TextField,
  Chip,
  IconButton
} from "@mui/material";

import {
  DataGrid,
  type GridColDef
} from "@mui/x-data-grid";

import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";

import DroneDialog from "../components/DroneDialog";
import { getDrones, deleteDrone } from "../services/drone.service";
import type { Drone } from "../types/drone";

export default function DroneList() {
  const [rows, setRows] = useState<Drone[]>([]);
  const [search, setSearch] = useState("");
  const [openDialog, setOpenDialog] = useState(false);

  useEffect(() => {
    loadDrones();
  }, []);

  async function loadDrones() {
    try {
      const data = await getDrones();
      setRows(data);
    } catch (error) {
      console.error("Failed to load drones:", error);
    }
  }

  async function handleDelete(id: number) {
    if (!window.confirm("Delete this drone?")) {
      return;
    }

    try {
      await deleteDrone(id);
      loadDrones();
    } catch (error) {
      console.error("Failed to delete drone:", error);
    }
  }

  const filteredRows = rows.filter((drone) =>
    drone.manufacturer.toLowerCase().includes(search.toLowerCase()) ||
    drone.model.toLowerCase().includes(search.toLowerCase()) ||
    drone.serialNumber.toLowerCase().includes(search.toLowerCase())
  );

  const columns: GridColDef[] = [
    {
      field: "manufacturer",
      headerName: "Manufacturer",
      flex: 1
    },
    {
      field: "model",
      headerName: "Model",
      flex: 1
    },
    {
      field: "category",
      headerName: "Category",
      flex: 1
    },
    {
      field: "status",
      headerName: "Status",
      flex: 1,
      renderCell: (params) => (
        <Chip
          size="small"
          label={params.value}
          color={
            params.value === "ACTIVE"
              ? "success"
              : params.value === "MAINTENANCE"
              ? "warning"
              : "default"
          }
        />
      )
    },
    {
      field: "weight",
      headerName: "Weight (kg)",
      flex: 1
    },
    {
      field: "actions",
      headerName: "Actions",
      width: 120,
      sortable: false,
      filterable: false,
      renderCell: (params) => (
        <>
          <IconButton size="small">
            <EditIcon />
          </IconButton>

          <IconButton
            size="small"
            color="error"
            onClick={() => handleDelete(params.row.id)}
          >
            <DeleteIcon />
          </IconButton>
        </>
      )
    }
  ];

  return (
    <Paper sx={{ p: 3 }}>
      <Stack
        direction="row"
        sx={{
          justifyContent: "space-between",
          alignItems: "center",
          mb: 3
        }}
      >
        <Typography
          variant="h4"
          sx={{
            fontWeight: 700
          }}
        >
          Drone Management
        </Typography>

        <Button
          variant="contained"
          onClick={() => setOpenDialog(true)}
        >
          Add Drone
        </Button>
      </Stack>

      <TextField
        fullWidth
        label="Search drones..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        sx={{ mb: 3 }}
      />

      <DataGrid
        rows={filteredRows}
        columns={columns}
        getRowId={(row) => row.id}
        autoHeight
        disableRowSelectionOnClick
        pageSizeOptions={[5, 10, 20]}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 5,
              page: 0
            }
          }
        }}
      />

      <DroneDialog
        open={openDialog}
        onClose={() => setOpenDialog(false)}
        onSuccess={loadDrones}
      />
    </Paper>
  );
}