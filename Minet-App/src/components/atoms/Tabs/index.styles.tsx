import { styled, Tabs, Tab } from "@mui/material";
import { theme } from "../../../theme";

export const StyledTabs = styled(Tabs)({
  "& .MuiTabs-indicator": {
    backgroundColor: theme.palette.secondary.light,
  },
});

export const StyledTab = styled(Tab)({
  textTransform: "none",
  fontSize: "20px",
  fontWeight: 400,
  lineHeight: "28px",
  letterSpacing: "0.005em",
  color: theme.palette.primary.light,
  "&.Mui-selected": {
    color: theme.palette.secondary.light,
  },
});
