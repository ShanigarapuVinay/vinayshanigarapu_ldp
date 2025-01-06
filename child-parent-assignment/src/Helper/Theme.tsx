import { createTheme } from "@mui/material";

const theme = createTheme({
  typography: {
    h2: {
      fontSize: "24px",
      lineHeight: "29.4px",
      fontWeight: "600",
    },
    body1: {
      color: "#E8E7F0",
      fontSize: "14px",
    },
    body2: {
      color: "#A5A5A6",
    },
  },
  components: {
    MuiIconButton: {
      styleOverrides: {
        root: {
          marginLeft: 1,
          color: "#A5A5A6",
        },
      },
    },
    MuiTableContainer: {
      styleOverrides: {
        root: {
          backgroundColor: "#201F24",
          border: "none",
        },
      },
    },
    MuiTableHead: {
      styleOverrides: {
        root: {
          backgroundColor: "#262529",
        },
      },
    },
    MuiTableRow: {
      styleOverrides: {
        root: {
          "&.Mui-selected, &.Mui-selected:hover": {
            backgroundColor: "#393552",
          },
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
  },
});

export default theme;
