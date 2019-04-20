package jaha.naz.recipe.converters;

import jaha.naz.recipe.commands.RecipeCommand;
import jaha.naz.recipe.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final NotesCommandToNotes notesCommandToNotes;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final CategoryCommandToCategory categoryCommandToCategory;

    public RecipeCommandToRecipe(NotesCommandToNotes notesCommandToNotes,
                                 IngredientCommandToIngredient ingredientCommandToIngredient,
                                 CategoryCommandToCategory categoryCommandToCategory) {
        this.notesCommandToNotes = notesCommandToNotes;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.categoryCommandToCategory = categoryCommandToCategory;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if(recipeCommand==null){
            return null;
        }
        Recipe recipe= new Recipe();

        recipe.setServings(recipeCommand.getServings());
        recipe.setSource(recipeCommand.getSource());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setId(recipeCommand.getId());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setNotes(notesCommandToNotes.convert(recipeCommand.getNotesCommand()));

        if(recipeCommand.getIngredientCommands()!=null && recipeCommand.getIngredientCommands().size()>0){
            recipeCommand.getIngredientCommands().forEach(ingredientC -> recipe
                    .getIngredients().add(ingredientCommandToIngredient.convert(ingredientC)));
        }

        if(recipeCommand.getCategoryCommands()!=null && recipeCommand.getCategoryCommands().size()>0){
            recipeCommand.getCategoryCommands().forEach(categoryCommand -> recipe
                    .getCategories().add(categoryCommandToCategory.convert(categoryCommand)));
        }

        return recipe;
    }
}
