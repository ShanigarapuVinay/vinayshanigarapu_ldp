import {
  Box,
  Slider,
  Stack,
  styled,
  TableCell,
  TableContainer,
  TableRow,
} from "@mui/material";
import Typography from "../../components/atoms/typography";
import MinusSquare from "@mui/icons-material/IndeterminateCheckBoxOutlined";

// NavBar
export const StyledNavBar = styled(Stack)(({ theme }) => ({
  width: "Hug (250)",
  height: "Fixed (768px)",
  backgroundColor: "#201F24",
  padding: theme.spacing(5, 2.5, 0, 2.5),
  color: "#fff",
  gap: "40px",
}));
export const StyledBoxNavBar = styled(Box)(() => ({
  width: "210px",
  borderRadius: "12px",
  padding: "16px",
  color: "#A5A5A6",
}));

// Contract Table
export const StyledContractContainer = styled(Box)(({ theme }) => ({
  backgroundColor: "#201F24",
  borderRadius: "12px",
  height: "Hug (529px) ",
  maxWidth: "700px",
  padding: theme.spacing("32px", "0px", "20px", "32px"),
}));

export const StyledTableContainer = styled(TableContainer)(() => ({
  width: "Fill (668px)",
  height: "450px",
  marginTop: "20px",
  "&::-webkit-scrollbar": {
    height: "8px",
    width: "8px",
  },
  "&::-webkit-scrollbar-track": {
    background: "#2E2C36",
    borderRadius: "10px",
  },
  "&::-webkit-scrollbar-thumb": {
    background: "#5D5C66",
    borderRadius: "10px",
  },
  "&::-webkit-scrollbar-thumb:hover": {
    background: "#757575",
  },
}));

export const StyledTableRow = styled(TableRow)(() => ({
  height: "44px",
}));

export const StyledTableCell = styled(TableCell)(() => ({
  borderBottom: 'none',
}));
export const StyledMinusSquare = styled(MinusSquare)(({ theme }) => ({
  marginLeft: theme.spacing(1),
  marginTop: theme.spacing(1),
  color: "#727080",
}));
// Card
export const StyledCardContainer = styled(Box)(({ theme }) => ({
  backgroundColor: "#201F24",
  borderRadius: "12px",
  height: "465px",
  width: "Fixed (340px)",
  border: "1px",
  padding: theme.spacing("32px"),
}));

export const StyledMoleculeBox = styled(Box)(() => ({
  display: "flex",
  flexDirection: "row",
  justifyContent: "space-between",
  alignItems: "center",
}));
export const StyledBox = styled(Box)(() => ({
  marginTop: "20px",
}));
export const StyledSlider = styled(Slider)(({ theme }) => ({
  color: theme.palette.primary.main,
  height: 8,
  "& .MuiSlider-thumb": {
    height: 23,
    width: 23,
    borderRadius: "8px",
    backgroundColor: theme.palette.primary.main,
    border: `3px solid #B4A9FF`,
    "&:focus, &:hover, &.Mui-active": {
      boxShadow: "inherit",
    },
  },
  "& .MuiSlider-rail": {
    opacity: 0.5,
    backgroundColor: "#3A3A3D",
  },
}));
export const StyledTypography = styled(Typography)(() => ({
  "& span.value": {
    color: "#B4A9FF",
  },
  "& span.of": {
    color: "#9C9C9C",
  },
  "& span.max": {
    color: "#E8E7F0",
  },
  "& span.sub": {
    color: "#A5A5A6",
    fontSize: "12px",
  },
}));

// CashKick Layout
export const StyledCashKickBox = styled(Box)(() => ({
  background: "#19181C",
  width: "1160px",
  height: "768px",
}));

