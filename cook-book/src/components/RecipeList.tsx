import React, { useState } from "react";
import { Recipe } from "../types/recipes";
import RecipeItem from "./RecipeItem";
import "../Asserts/css/recipeList.css";
import RecipeDetail from "./RecipeDetail";

interface RecipeListProps {
  recipes: Recipe[];
  deleteRecipe: (id: string) => void;
  editRecipe: (recipe: Recipe) => void;
  update: (recipe: Recipe) => void;
  setOpen: React.Dispatch<React.SetStateAction<boolean>>;
}
const RecipeList: React.FC<RecipeListProps> = (props) => {
  const { recipes, deleteRecipe, editRecipe, update, setOpen } = props;
  const [selectedRecipe, setSelectedRecipe] = useState<Recipe | null>(null);
  const handleRecipeClick = (recipe: Recipe) => {
    setSelectedRecipe(recipe);
  };

  const handleBackClick = () => {
    setSelectedRecipe(null);
  };
  return (
    <div className="recipeList-container">
      {recipes.map((recipe) => (
        <RecipeItem
          key={recipe.id}
          recipe={recipe}
          deleteRecipe={deleteRecipe}
          editRecipe={editRecipe}
          update={update}
          setOpen={setOpen}
          onClick={() => handleRecipeClick(recipe)}
        />
      ))}
      {selectedRecipe && (
        <RecipeDetail recipe={selectedRecipe} onBackClick={handleBackClick} />
      )}
    </div>
  );
};

export default RecipeList;
