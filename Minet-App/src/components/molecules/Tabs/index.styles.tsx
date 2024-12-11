import { styled, Tabs, Tab } from "@mui/material";
import { theme } from "../../../theme";

export const StyledTabs = styled(Tabs)({
  "& .MuiTabs-indicator": {
    backgroundColor: theme.palette.secondary.light,
  },
  borderBottom: `1px solid ${theme.palette.secondary.contrastText}`,
});

export const StyledTab = styled(Tab)({
  textTransform: "none",
  fontSize: theme.spacing(5),
  fontWeight: 400,
  lineHeight: theme.spacing(7),
  letterSpacing: "0.005em",
  color: theme.palette.primary.light,
  "&.Mui-selected": {
    color: theme.palette.secondary.light,
  },
});
