import React from "react";
import { Recipe } from "../types/recipes";
import "../Asserts/css/recipeItem.css";

interface RecipeItemProps {
  recipe: Recipe;
  deleteRecipe: (id: string) => void;
  editRecipe: (recipe: Recipe) => void;
  onClick: () => void;
  update: (recipe: Recipe) => void;
  setOpen: React.Dispatch<React.SetStateAction<boolean>>;
}

const RecipeItem: React.FC<RecipeItemProps> = (props) => {
  const { recipe, deleteRecipe, onClick, update, setOpen } = props;

  const handleEditClick = (e: React.MouseEvent) => {
    e.stopPropagation();
    setOpen(true);
    update(recipe);
  };

  const handleDeleteClick = (e: React.MouseEvent) => {
    e.stopPropagation();
    deleteRecipe(recipe.id);
  };

  return (
    <div className="recipe-container" onClick={onClick}>
      <h3>{recipe.title}</h3>
      <div className="image-wrapper">
        <img src={recipe.image} alt={recipe.title} />
        <div className="edit-button" onClick={handleEditClick}>
          <i className="fa-solid fa-pen-to-square edit"></i>
        </div>
        <div className="delete-button" onClick={handleDeleteClick}>
          <i className="fa-solid fa-trash-can delete"></i>
        </div>
      </div>
    </div>
  );
};

export default RecipeItem;
