import { createTheme } from "@mui/material/styles";

const theme = createTheme({
  palette: {
    primary: {
      main: "#2563EB",
    },
    secondary: {
      main: "#22C55E",
    },
    background: {
      default: "#F5F7FB",
    },
  },

  typography: {
    fontFamily: "Roboto, sans-serif",
  },

  shape: {
    borderRadius: 10,
  },
});

export default theme;