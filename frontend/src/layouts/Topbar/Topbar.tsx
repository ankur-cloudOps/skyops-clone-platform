import {
  NotificationsNone,
  Search,
  AccountCircle
} from "@mui/icons-material";

import "./Topbar.scss";

export default function Topbar() {
  return (
    <header className="topbar">

      <h2>SkyOps Platform</h2>

      <div className="topbar__right">

        <div className="topbar__search">
          <Search fontSize="small" />
          <input placeholder="Search..." />
        </div>

        <NotificationsNone />

        <AccountCircle fontSize="large" />

      </div>

    </header>
  );
}