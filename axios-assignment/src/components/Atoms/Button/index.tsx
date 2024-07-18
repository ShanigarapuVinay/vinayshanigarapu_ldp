import React from "react";
import { ButtonProps, Button as MuiButton } from "@mui/material";

const Button: React.FC<ButtonProps> = ({ ...props }) => {
  return <MuiButton {...props}>{props.children}</MuiButton>;
};

export default Button;
