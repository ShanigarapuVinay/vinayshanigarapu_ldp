import React, { useState } from "react";
import Typography from "../../Atoms/Typography";
import AddTodoData from "../../Molecules/AddTodoData";
import { Text } from "../../../constants/Text/text";

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
      <Typography variant="h4">{Text.ADDTODO}</Typography>
      <AddTodoData
        textFieldType="text"
        textFieldValue={title}
        textLabel="Enter Your Todo"
        textVariant="outlined"
        onChange={(e) => setTitle(e.target.value)}
        buttonType="submit"
        buttonVariant="contained"
        buttonLabel="Add Todo"
      />
    </form>
  );
};

export default AddTodo;
