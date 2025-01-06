import { createTheme } from "@mui/material";

const theme = createTheme({
  typography: {
    h3: {
      fontSize: "1.5rem",
      fontWeight: 600,
      fontFamily: "Roboto, Arial, sans-serif",
      color: "#333333",
      marginBottom: "1.5rem",
    },
    h4: {
      fontSize: "1.15rem",
      fontWeight: 600,
      fontFamily: "Roboto, Arial, sans-serif",
      color: "#333333", // Primary text color
      marginBottom: "0.7rem",
    },
    body1: {
      fontSize: "1rem",
      fontWeight: 400,
      fontFamily: "Roboto, Arial, sans-serif",
      color: "#555555",
      lineHeight: 1.5,
      marginBottom: "3rem",
    },
    subtitle1: {
      fontSize: "0.9rem",
      fontWeight: 400,
      fontFamily: "Roboto, Arial, sans-serif",
      color: "#666666", // Secondary text color
      lineHeight: 1.5,
    },
  },
  components: {
    MuiStack: {
      styleOverrides: {
        root: {
          width: "85%",
        },
      },
    },
  },
  breakpoints: {
    values: {
      xs: 0,
      sm: 600,
      md: 960,
      lg: 1280,
      xl: 1920,
    },
  },
});
export default theme;
