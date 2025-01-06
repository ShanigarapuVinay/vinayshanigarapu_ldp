import React, { useState } from "react";
import "./App.css";
import useRecipes from "./hooks/useRecipes";
import RecipeList from "./components/RecipeList";
import AddRecipe from "./components/AddRecipe";
import { Recipe } from "./types/recipes";

function App() {
  const { recipes, addRecipe, editRecipe, deleteRecipe } = useRecipes();
  const [open, setOpen] = useState(false);
  const [updateRecipe, setUpdateRecipe] = useState<Recipe | null>(null);
  const clearUpdateRecipe = () => {
    setUpdateRecipe(null);
  };
  function update(recipe: Recipe) {
    setUpdateRecipe(recipe);
  }
  return (
    <div className="App">
      <div className="container">
        <h1>Cook Book</h1>
        <hr />
        <RecipeList
          recipes={recipes}
          deleteRecipe={deleteRecipe}
          editRecipe={editRecipe}
          setOpen={setOpen}
          update={update}
        />
        <div className="icon-add" onClick={() => setOpen(true)}>
          <i className="fa-solid fa-plus"></i>
        </div>
        {open && (
          <AddRecipe
            addRecipe={addRecipe}
            editRecipe={editRecipe}
            setOpen={setOpen}
            updateRecipe={updateRecipe}
            clearUpdateRecipe={clearUpdateRecipe} // Pass the clearUpdateRecipe method
          />
        )}
      </div>
    </div>
  );
}

export default App;
