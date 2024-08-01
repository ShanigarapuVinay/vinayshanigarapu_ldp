import { createTheme } from "@mui/material";

const theme = createTheme({
  palette: {
    primary: {
      main: "#6C5DD3",
    },
  },
  typography: {
    fontFamily: "Gilroy",
    h1: {
      fontSize: "36px",
      lineHeight: "42px",
      fontWeight: 700,
      color: "#E8E7F0",
    },
    h2: {
      fontSize: "24px",
      lineHeight: "29.71px",
      fontWeight: 700,
    },
    h3: {
      fontSize: "24px",
      lineHeight: "29.4px",
      fontWeight: "600",
      color: "#E8E7F0",
    },
    h4: {
      fontSize: "24px",
      lineHeight: "29.4px",
      fontWeight: "600",
      color: "##E8E7F0",
    },
    h5: {
      fontSize: "18px",
      lineHeight: "27px",
      fontWeight: "500",
      color: "#A5A5A6",
    },
    body1: {
      color: "#A5A5A6",
      fontSize: "16px",
      fontWeight: "500",
      lineHeight: "22.4px",
    },
    body2: {
      fontSize: "14px",
      color: "#A5A5A6",
      fontWeight: "600",
    },
    subtitle1: {
      fontSize: "18px",
      color: "#A5A5A6",
    },
  },
  components: {
    MuiTableContainer: {
      styleOverrides: {
        root: {
          backgroundColor: "#201F24",
          border: "none",
        },
      },
    },
    MuiTable: {
      styleOverrides: {
        root: {
          minWidth: 820,
        },
      },
    },
    MuiTableHead: {
      styleOverrides: {
        root: {
          backgroundColor: "#262529",
          height: "44px",
        },
      },
    },
    MuiTableRow: {
      styleOverrides: {
        root: {
          "&.Mui-selected, &.Mui-selected:hover": {
            backgroundColor: "#393552",
          },
          height: "62px",
          cursor: "pointer",
        },
      },
    },
    MuiTableCell: {
      styleOverrides: {
        root: {
          borderBottom: "none",
        },
      },
    },
    MuiCheckbox: {
      styleOverrides: {
        root: {
          color: "#727080",
          "&.Mui-checked": {
            color: "#B4A9FF",
          },
        },
      },
    },
    MuiButton: {
      styleOverrides: {
        root: {
          textTransform: "none",
        },
        contained: {
          color: "#E8E8E9",
          fontSize: "16px",
          fontWeight: "600",
          lineHeight: "19px",
          width: "276px",
          height: "59px",
          borderRadius: "12px",
          "&:hover": {
            backgroundColor: "#4D4771",
          },
        },
        outlined: {
          color: "#C9C8CC",
          background: "#2D2D30",
          borderRadius: "12px",
          border: "none",
        },
      },
    },
  },
});

export default theme;
