import React, { useEffect, useState } from "react";
import { Todo } from "../../../Types/Todo";
import { FormControl } from "@mui/material";
import TextField from "../../Atoms/TextField";
import Button from "../../Atoms/Button";
import Typography from "../../Atoms/Typography";
import { Text } from "../../../constants/Text/text";
interface EditTodoProps {
  todo: Todo;
  updateTodo: (id: number, title: string) => void;
  cancelEdit: () => void;
}
const EditTodo: React.FC<EditTodoProps> = ({
  todo,
  updateTodo,
  cancelEdit,
}) => {
  const [title, setTitle] = useState<string>(todo.title);
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!title.trim()) return;
    updateTodo(todo.id, title);
  };
  useEffect(() => {
    setTitle(todo.title);
  }, [todo]);
  return (
    <form onSubmit={handleSubmit}>
      <Typography variant="h4">{Text.EDITTODO}</Typography>
      <FormControl>
        <TextField
          type="text"
          value={title}
          variant="outlined"
          onChange={(e) => setTitle(e.target.value)}
        />
        <Button variant="contained" type="submit">
          {Text.EDITTODO}
        </Button>
        <Button
          variant="contained"
          type="submit"
          color="error"
          onClick={cancelEdit}
        >
          {Text.CANCEL}
        </Button>
      </FormControl>
    </form>
  );
};

export default EditTodo;
