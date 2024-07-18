import React, { useState } from "react";
import { Todo } from "../../../Types/Todo";
import { Container } from "@mui/material";
import { DataGrid, GridColDef, GridRenderCellParams } from "@mui/x-data-grid";
import Button from "../../Atoms/Button";
import CheckBox from "../../Atoms/CheckBox";

interface TodoListProps {
  todos: Todo[];
  toggleTodo: (id: number) => void;
  deleteTodo: (id: number) => void;
  editTodo: (id: number) => void;
}

const TodoList: React.FC<TodoListProps> = ({
  todos,
  toggleTodo,
  deleteTodo,
  editTodo,
}) => {
  const columns: GridColDef[] = [
    { field: "title", headerName: "Title", width: 350 },
    {
      field: "completed",
      headerName: "Completed",
      width: 150,
      renderCell: (params: GridRenderCellParams) => (
        <CheckBox
          checked={params.value as boolean}
          onChange={() => toggleTodo(params.row.id)}
        />
      ),
    },
    {
      field: "edit",
      headerName: "Edit",
      width: 200,
      renderCell: (params: GridRenderCellParams) => (
        <Button variant="contained" onClick={() => editTodo(params.row.id)}>
          Edit
        </Button>
      ),
    },
    {
      field: "delete",
      headerName: "Delete",
      width: 200,
      renderCell: (params: GridRenderCellParams) => (
        <Button
          variant="contained"
          color="error"
          onClick={() => deleteTodo(params.row.id)}
        >
          Delete
        </Button>
      ),
    },
  ];

  const rows = todos.map((todo) => ({
    id: todo.id,
    title: todo.title,
    completed: todo.completed,
  }));
  const [paginationModel, setPaginationModel] = useState({
    pageSize: 5,
    page: 0,
  });
  return (
    <Container>
      <DataGrid
        rows={rows}
        columns={columns}
        paginationModel={paginationModel}
        onPaginationModelChange={setPaginationModel}
        pageSizeOptions={[5, 10, 25]}
        autoHeight
        disableRowSelectionOnClick
        sx={{
          '& .MuiDataGrid-cell': {
            fontSize: '1rem',
          },
          '& .MuiDataGrid-columnHeaders': {
            fontSize: '1rem',
            backgroundColor: '#f5f5f5',
            fontWeight: 'bold',
          },
          '& .MuiDataGrid-row': {
            backgroundColor: '#fff',
          },
        }}
      />
    </Container>
  );
};

export default TodoList;
