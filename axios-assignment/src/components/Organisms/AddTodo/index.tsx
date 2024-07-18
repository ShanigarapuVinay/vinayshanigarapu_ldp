import { FormControl } from "@mui/material";
import React, { useState } from "react";
import TextField from "../../Atoms/TextField";
import Button from "../../Atoms/Button";
import Typography from "../../Atoms/Typography";

interface AddTodoProps {
  addTodo: (title: string) => void;
}

const AddTodo: React.FC<AddTodoProps> = ({ addTodo }) => {
  const [title, setTitle] = useState<string>("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!title.trim()) return;
    addTodo(title);
    setTitle("");
  };

  return (
    <form onSubmit={handleSubmit}>
      <FormControl>
        <Typography variant="h4">Add Todo</Typography>
        <TextField
          type="text"
          value={title}
          label="Enter Your Todo"
          variant="outlined"
          onChange={(e) => setTitle(e.target.value)}
        />
        <Button variant="contained" type="submit">Add Todo</Button>
      </FormControl>
    </form>
  );
};

export default AddTodo;
