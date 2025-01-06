import React, { useEffect, useState } from "react";
import { Recipe } from "../types/recipes";
import "../Asserts/css/addRecipe.css";

interface AddRecipeProps {
  addRecipe: (recipe: Recipe) => void;
  editRecipe: (recipe: Recipe) => void;
  setOpen: React.Dispatch<React.SetStateAction<boolean>>;
  updateRecipe: Recipe | null;
  clearUpdateRecipe: () => void;
}

const AddRecipe: React.FC<AddRecipeProps> = ({
  addRecipe,
  editRecipe,
  setOpen,
  updateRecipe,
  clearUpdateRecipe,
}) => {
  const [title, setTitle] = useState("");
  const [recipe, setRecipe] = useState("");
  const [image, setImage] = useState<File | null>(null);

  useEffect(() => {
    if (updateRecipe) {
      setTitle(updateRecipe.title);
      setRecipe(updateRecipe.recipe);
    } else {
      setTitle("");
      setRecipe("");
      setImage(null);
    }
  }, [updateRecipe]);

  function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    const newRecipe: Recipe = {
      id: updateRecipe ? updateRecipe.id : Date.now().toString(),
      image: image ? URL.createObjectURL(image) : updateRecipe?.image || "",
      title,
      recipe,
    };
    if (updateRecipe) {
      editRecipe(newRecipe);
      clearUpdateRecipe(); // Clear the update recipe state after editing
    } else {
      addRecipe(newRecipe);
    }
    setImage(null);
    setTitle("");
    setRecipe("");
    setOpen(false);
  }

  function handleClose() {
    setOpen(false);
    clearUpdateRecipe(); // Clear the update recipe state when closing the form
  }

  return (
    <div className="overlay">
      <div className="addRecipe-container">
        <h2>{updateRecipe ? "Update Recipe" : "Add Recipe"}</h2>
        <div className="close-btn" onClick={handleClose}>
          <i className="fa-solid fa-xmark"></i>
        </div>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="Title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
          <textarea
            placeholder="Recipe"
            value={recipe}
            onChange={(e) => setRecipe(e.target.value)}
            required
          />
          <input
            type="file"
            accept="image/*"
            onChange={(e) =>
              setImage(e.target.files ? e.target.files[0] : null)
            }
          />
          <button type="submit">{updateRecipe ? "Update Recipe" : "Add Recipe"}</button>
        </form>
      </div>
    </div>
  );
};

export default AddRecipe;
