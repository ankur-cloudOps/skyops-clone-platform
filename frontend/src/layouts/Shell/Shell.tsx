import { Outlet } from "react-router-dom";

import Sidebar from "../Sidebar/Sidebar";
import Topbar from "../Topbar/Topbar";

import "./Shell.scss";

export default function Shell() {
  return (
    <div className="layout">

      <Sidebar />

      <div className="layout__content">

        <Topbar />

        <main className="layout__main">
          <Outlet />
        </main>

      </div>

    </div>
  );
}