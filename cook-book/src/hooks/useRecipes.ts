import { useState } from 'react';
import { Recipe } from '../types/recipes';
import items from '../data';

const useRecipes = () => {
  const [recipes, setRecipes] = useState<Recipe[]>(items);

  const addRecipe = (recipe: Recipe) => {
    setRecipes([...recipes, recipe]);
  };

  const editRecipe = (updatedRecipe: Recipe) => {
    setRecipes(recipes.map(recipe => (recipe.id === updatedRecipe.id ? updatedRecipe : recipe)));
  };

  const deleteRecipe = (id: string) => {
    setRecipes(recipes.filter(recipe => recipe.id !== id));
  };

  return { recipes, addRecipe, editRecipe, deleteRecipe };
};

export default useRecipes;
