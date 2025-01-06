import React from "react";
import { Recipe } from "../types/recipes";
import "../Asserts/css/recipeDetail.css";
interface RecipeDetailProps {
  recipe: Recipe;
  onBackClick: () => void;
}
const RecipeDetail: React.FC<RecipeDetailProps> = (props) => {
  const { recipe, onBackClick } = props;
  return (
    <div className="recipeDetail">
      <div className="recipeDetail-container">
        <div className="section1">
          <img src={recipe.image} alt={recipe.title} />
        </div>
        <div className="section2">
          <div className="close-btn" onClick={onBackClick}>
            <i className="fa-solid fa-xmark"></i>
          </div>
          <h2>{recipe.title}</h2>
          <hr />
          <p>{recipe.recipe}</p>
        </div>
      </div>
    </div>
  );
};

export default RecipeDetail;
