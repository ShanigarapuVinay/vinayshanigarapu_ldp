import { createTheme } from "@mui/material";

export const theme = createTheme({
  palette: {
    primary: {
      main: "#20B03F",
      dark: "#343446",
      light: "#7D7D89",
    },
    secondary: {
      main: "#B71A33",
      dark: "#4B4B60",
      light: "#0052FF",
      contrastText: "#E8E8F7",
    },
  },
  typography: {
    fontFamily: "Graphik",
    caption: {
      fontSize: "14px",
      fontWeight: 500,
      lineHeight: "16px",
      letterSpacing: "0.01em",
    },
    body1: {
      fontSize: "16px",
      fontWeight: 500,
      lineHeight: "22px",
      letterSpacing: "0.01em",
    },
    body2: {
      fontSize: "16px",
      fontWeight: 400,
      lineHeight: "22px",
      letterSpacing: "0.01em",
    },
    overline: {
      fontSize: "12px",
      fontWeight: 400,
      lineHeight: "14px",
    },
  },
  spacing: 4,
});
