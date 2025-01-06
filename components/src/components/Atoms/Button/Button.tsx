import React from "react";
import "./button.css";

interface ButtonProps {
  label: string;
  color?: string;
  size?: "sm" | "m" | "l";
}
const Button: React.FC<ButtonProps> = ({
  label,
  color = "purple",
  size = "l",
}) => {
  return (
    <button className="btn" type="submit">
      {label}
    </button>
  );
};

export default Button;
