import { Typography as MuiTypography } from "@mui/material";
import React from "react";

interface TypographyProps {
  variant:
    | "h1"
    | "h2"
    | "h3"
    | "h4"
    | "h5"
    | "h6"
    | "body1"
    | "body2"
    | "subtitle1"
    | "subtitle2"
    | "caption";
  label: string;
}
const Typography: React.FC<TypographyProps> = ({ variant, label }) => {
  return <MuiTypography variant={variant}>{label}</MuiTypography>;
};

export default Typography;
