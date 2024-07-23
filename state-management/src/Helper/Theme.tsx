import { createTheme } from "@mui/material";
import { green, grey } from "@mui/material/colors";

const theme = createTheme({
  typography: {
    fontFamily: "'Poppins', sans-serif",
    h1: {
      fontSize: 30,
      fontWeight: 700,
      marginTop: 20,
      marginBottom: 20,
    },
    h5: {
      fontSize: 18,
      fontWeight: 700,
      marginBottom: 5,
    },
    body2: {
      fontSize: 14,
      color: "#888",
    },
    subtitle1: {
      fontSize: 16,
      color: "#888",
      marginBottom: 5,
      fontWeight: 600,
    },
  },
  components: {
    MuiCardMedia: {
      styleOverrides: {
        root: {
          height: 250,
          objectFit: "cover",
        },
      },
    },
    MuiCard: {
      styleOverrides: {
        root: {
          width: 300,
        },
      },
    },
    MuiStack: {
      styleOverrides: {
        root: {
          marginTop: 25,
        },
      },
    },
    MuiButton: {
      styleOverrides: {
        root: {
          marginTop: 10,
          fontWeight: "bold",
        },
      },
    },
    MuiTabs: {
      styleOverrides: {
        indicator: {
          backgroundColor: green[500],
        },
      },
    },
    MuiTab: {
      styleOverrides: {
        root: {
          color: grey[600],
          "&.Mui-selected": {
            color: green[500],
          },
        },
      },
    },
  },
});
export default theme;
