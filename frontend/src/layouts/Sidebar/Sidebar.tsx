import {
  Dashboard,
  Flight,
  Map,
  Person,
  Business,
  Settings
} from "@mui/icons-material";

import { NavLink } from "react-router-dom";

import "./Sidebar.scss";

const menu = [
  {
    label: "Dashboard",
    icon: <Dashboard />,
    path: "/dashboard"
  },
  {
    label: "Drones",
    icon: <Flight />,
    path: "/drones"
  },
  {
    label: "Missions",
    icon: <Map />,
    path: "/missions"
  },
  {
    label: "Pilots",
    icon: <Person />,
    path: "/pilots"
  },
  {
    label: "Organizations",
    icon: <Business />,
    path: "/organizations"
  },
  {
    label: "Settings",
    icon: <Settings />,
    path: "/settings"
  }
];

export default function Sidebar() {
  return (
    <aside className="sidebar">
      <div className="sidebar__logo">
        SkyOps
      </div>

      <nav className="sidebar__menu">
        {menu.map((item) => (
          <NavLink
            key={item.path}
            to={item.path}
            className={({ isActive }) =>
              isActive ? "sidebar__link active" : "sidebar__link"
            }
          >
            {item.icon}

            <span>{item.label}</span>
          </NavLink>
        ))}
      </nav>
    </aside>
  );
}

