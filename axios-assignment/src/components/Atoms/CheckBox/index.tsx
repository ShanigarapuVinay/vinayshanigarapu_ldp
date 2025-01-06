import { CheckboxProps, Checkbox as MuiCheckBox } from "@mui/material";
import React from "react";

const CheckBox: React.FC<CheckboxProps> = ({ ...props }) => {
  return <MuiCheckBox {...props} />;
};

export default CheckBox;
