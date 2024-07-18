import { Container, Stack, ThemeProvider } from "@mui/material";
import useTodos from "../../../Hooks/useTodo";
import Typography from "../../Atoms/Typography";
import TodoList from "../../Organisms/TodoList";
import EditTodo from "../../Organisms/EditTodo";
import AddTodo from "../../Organisms/AddTodo";
import theme from "../../../Helper/Theme";
import { Text } from "../../../constants/Text/text";

const Todos: React.FC = () => {
  const {
    todos,
    addTodo,
    toggleTodo,
    deleteTodo,
    editTodo,
    updateTodo,
    cancelEdit,
    editingTodo,
  } = useTodos();

  return (
    <ThemeProvider theme={theme}>
      <Container>
        <Typography variant="h1">{Text.TITLE}</Typography>
        <Stack direction="row">
          <TodoList
            todos={todos}
            toggleTodo={toggleTodo}
            deleteTodo={deleteTodo}
            editTodo={editTodo}
          />
          {editingTodo ? (
            <EditTodo
              todo={editingTodo}
              updateTodo={updateTodo}
              cancelEdit={cancelEdit}
            />
          ) : (
            <AddTodo addTodo={addTodo} />
          )}
        </Stack>
      </Container>
    </ThemeProvider>
  );
};

export default Todos;
