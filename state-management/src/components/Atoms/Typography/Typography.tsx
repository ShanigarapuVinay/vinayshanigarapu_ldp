import React from "react";
import { Typography as MUITypography } from "@mui/material";

interface TypographyProps {
  variant: "h1" | "h5" | "body2" | "subtitle1";
  children: React.ReactNode;
}
const Typography: React.FC<TypographyProps> = ({ variant, children }) => {
  return <MUITypography variant={variant}>{children}</MUITypography>;
};

export default Typography;
