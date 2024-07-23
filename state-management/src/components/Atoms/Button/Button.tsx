import React from "react";
import { Button as MUIButton } from "@mui/material";

interface ButtonProps {
  variant: "contained" | "outlined" | "text";
  onClick: () => void;
  children: React.ReactNode;
}
const Button: React.FC<ButtonProps> = ({ variant, onClick, children }) => {
  return (
    <MUIButton variant={variant} onClick={onClick}>
      {children}
    </MUIButton>
  );
};

export default Button;
