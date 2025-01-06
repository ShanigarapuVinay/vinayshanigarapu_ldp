import { useState, useEffect } from "react";
import axios from "axios";
import { Todo } from "../../Types/Todo";

const useTodos = () => {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [editingTodo, setEditingTodo] = useState<Todo | null>(null);

  useEffect(() => {
    axios
      .get("http://localhost:5000/todos")
      .then((response) => {
        setTodos(response.data);
      })
      .catch((error) => {
        console.error("Error fetching todos:", error);
      });
  }, []);

  const addTodo = (title: string) => {
    const newTodo = { id: Date.now().toString(), title, completed: false };
    axios
      .post("http://localhost:5000/todos", newTodo)
      .then((response) => {
        if (response.data && response.data.id) {
          setTodos([...todos, response.data]);
        } else {
          console.error("Invalid response data:", response.data);
        }
      })
      .catch((error) => {
        console.error("Error adding todo:", error);
      });
  };

  const toggleTodo = (id: number) => {
    const todo = todos.find((todo) => todo.id === id);
    if (todo) {
      axios
        .patch(`http://localhost:5000/todos/${id}`, {
          completed: !todo.completed,
        })
        .then((response) => {
          if (response.data && response.data.id) {
            setTodos(
              todos.map((todo) => (todo.id === id ? response.data : todo))
            );
          } else {
            console.error("Invalid response data:", response.data);
          }
        })
        .catch((error) => {
          console.error("Error toggling todo:", error);
        });
    }
  };

  const deleteTodo = (id: number) => {
    axios
      .delete(`http://localhost:5000/todos/${id}`)
      .then(() => {
        setTodos(todos.filter((todo) => todo.id !== id));
      })
      .catch((error) => {
        console.error(`Error deleting todo with id ${id}:`, error);
      });
  };

  const editTodo = (id: number) => {
    const todo = todos.find((todo) => todo.id === id);
    if (todo) {
      setEditingTodo(todo);
    }
  };

  const updateTodo = (id: number, title: string) => {
    axios
      .patch(`http://localhost:5000/todos/${id}`, { title })
      .then((response) => {
        if (response.data && response.data.id) {
          setTodos(
            todos.map((todo) => (todo.id === id ? response.data : todo))
          );
        } else {
          console.error("Invalid response data:", response.data);
        }
      })
      .catch((error) => {
        console.error("Error updating todo:", error);
      })
      .finally(() => {
        setEditingTodo(null);
      });
  };

  const cancelEdit = () => {
    setEditingTodo(null);
  };

  return {
    todos,
    addTodo,
    toggleTodo,
    deleteTodo,
    editTodo,
    updateTodo,
    editingTodo,
    cancelEdit,
  };
};

export default useTodos;
