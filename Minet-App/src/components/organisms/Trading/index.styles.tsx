import { Box, styled } from "@mui/material";
import { theme } from "../../../theme";

export const Wrapper = styled(Box)({
  width: theme.spacing(309.75),
  height: theme.spacing(214),
  display: "flex",
  flexDirection: "column",
  gap: theme.spacing(3),
});

export const Header = styled(Box)({
  height: theme.spacing(10.5),
  display: "flex",
  padding: "0px 24px",
});

export const StyledBody = styled(Box)({
  display: "flex",
  flexDirection: "column",
  gap: theme.spacing(3),
});

export const Row = styled(Box)({
  height: "74px",
  display: "flex",
  border: `1px solid ${theme.palette.secondary.contrastText}`,
  padding: "0px 24px",
  borderRadius: theme.spacing(1),
  alignItems: "center",
  "&:hover": {
    boxShadow: "0px 1px 10px 0px #2C2C2C14",
  },
});

export const StyledRow = styled(Box)({
  display: "flex",
  alignItems: "center",
});
