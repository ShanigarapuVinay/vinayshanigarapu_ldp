import { Box, styled } from "@mui/material";
import { theme } from "../../../theme";

export const Wrapper = styled(Box)({
  display: "flex",
  gap: theme.spacing(2.5),
});

export const InnerBox = styled(Box)({
  display: "flex",
  flexDirection: "column",
  gap: theme.spacing(1),
});
