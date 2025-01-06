import { FormControl } from "@mui/material";
import React from "react";
import Button from "../../Atoms/Button";
import TextField from "../../Atoms/TextField";

interface AddTodoDataProps {
  textFieldType: string;
  textFieldValue: string;
  textLabel: string;
  textVariant: "outlined" | "filled" | "standard";
  onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
  buttonVariant: "contained" | "text" | "outlined";
  buttonType: "submit" | "button" | "reset";
  buttonLabel: string;
}

const AddTodoData: React.FC<AddTodoDataProps> = ({
  textFieldType,
  textFieldValue,
  textLabel,
  textVariant,
  onChange,
  buttonVariant,
  buttonType,
  buttonLabel,
}) => {
  return (
    <FormControl>
      <TextField
        type={textFieldType}
        value={textFieldValue}
        label={textLabel}
        variant={textVariant}
        onChange={onChange}
      />
      <Button
        type={buttonType}
        variant={buttonVariant}
        children={buttonLabel}
      />
    </FormControl>
  );
};

export default AddTodoData;
