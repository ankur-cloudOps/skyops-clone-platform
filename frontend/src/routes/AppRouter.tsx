import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Shell from "../layouts/Shell/Shell";

import Dashboard from "../features/dashboard/pages/Dashboard";
import DroneList from "../features/drones/pages/DroneList";

export default function AppRouter() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Shell />}>
          <Route index element={<Dashboard />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/drones" element={<DroneList />} />
        </Route>

        <Route path="*" element={<Navigate to="/dashboard" replace />} />
      </Routes>
    </BrowserRouter>
  );
}