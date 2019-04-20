package jaha.naz.recipe.converters;

import jaha.naz.recipe.commands.RecipeCommand;
import jaha.naz.recipe.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private NotesToNotesCommand notesToNotesCommand;
    private IngredientToIngredientCommand ingredientToIngredientCommand;
    private CategoryToCategoryCommand categoryToCategoryCommand;

    public RecipeToRecipeCommand(NotesToNotesCommand notesToNotesCommand,
                                 IngredientToIngredientCommand ingredientToIngredientCommand,
                                 CategoryToCategoryCommand categoryToCategoryCommand) {
        this.notesToNotesCommand = notesToNotesCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.categoryToCategoryCommand = categoryToCategoryCommand;
    }

    @Override
    public RecipeCommand convert(Recipe recipe) {
        if(recipe==null){
            return null;
        }
        RecipeCommand recipeCommand= new RecipeCommand();
        recipeCommand.setId(recipe.getId());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setDirections(recipe.getDirections());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setUrl(recipe.getUrl());

        recipeCommand.setNotesCommand(notesToNotesCommand.convert(recipe.getNotes()));

        if(recipe.getCategories()!=null && recipe.getCategories().size()>0){
            recipe.getCategories().forEach(category -> recipeCommand.getCategoryCommands()
                    .add(categoryToCategoryCommand.convert(category)));
        }

        if(recipe.getIngredients()!=null && recipe.getIngredients().size()>0){
            recipe.getIngredients().forEach(ingredient -> recipeCommand.getIngredientCommands()
            .add(ingredientToIngredientCommand.convert(ingredient)));
        }

        return recipeCommand;

    }
}
