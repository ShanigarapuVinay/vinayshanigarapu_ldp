import { ButtonProps, Container, FormControl, TextFieldProps } from "@mui/material";
import React from "react";
import Button from "../../Atoms/Button";
import TextField from "../../Atoms/TextField";

type AddTodoDataProps = ButtonProps & TextFieldProps;

const AddTodoData: React.FC<AddTodoDataProps> = ({ ...props }) => {
  return (
    <Container>
      <FormControl>
        <TextField {...props} />
        <Button {...props} />
      </FormControl>
    </Container>
  );
};

export default AddTodoData;
