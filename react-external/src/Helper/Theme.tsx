import { createTheme } from "@mui/material";

const theme = createTheme({
  typography: {
    fontFamily: "Montserrat",
    h1: {
      fontSize: "20px",
      lineHeight: "30px",
      fontWeight: 500,
    },
    h3: {
      fontSize: "12px",
      marginTop: "1rem",
      color: "#656E66",
      lineHeight: "16px",
      fontWeight: 700,
    },
    body1: {
      fontSize: "12px",
      marginTop: "0.4rem",
      lineHeight: "16px",
      fontWeight: 500,
      color: "#FF725E",
    },
    body2: {
      fontSize: "12px",
      marginTop: "0.2rem",
      color: "#656E66",
      fontWeight: 500,
    },
  },
  components: {
    MuiPaper: {
      styleOverrides: {
        root: {
          width: "571px",
          height: "159px",
          justifyContent: "center",
          borderRadius: "12px",
          margin: "15% 30%",
          padding: "16px 19px 16px 19px",
          gap: "10px",
        },
      },
    },
    MuiStack: {
      styleOverrides: {
        root: {
          marginTop: "10px",
        },
      },
    },
  },
});

export default theme;
