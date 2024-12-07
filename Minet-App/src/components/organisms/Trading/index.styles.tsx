import { Box, styled } from "@mui/material";
import { theme } from "../../../theme";

export const Wrapper = styled(Box)({
  width: "1239px",
  height: "856px",
  display: "flex",
  flexDirection: "column",
  gap: "12px",
});

export const Header = styled(Box)({
  height: "42px",
  display: "flex",
  padding: "0px 24px",
});

export const StyledBody = styled(Box)({
  display: "flex",
  flexDirection: "column",
  gap: "12px",
});

export const Row = styled(Box)({
  height: "74px",
  display: "flex",
  border: `1px solid ${theme.palette.secondary.contrastText}`,
  padding: "0px 24px",
  borderRadius: "4px",
  alignItems: "center",
  "&:hover": {
    boxShadow: "0px 1px 10px 0px #2C2C2C14",
  },
});

export const StyledRow = styled(Box)({
  display: "flex",
  alignItems: "center",
});
