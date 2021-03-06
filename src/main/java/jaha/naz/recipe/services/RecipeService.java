package jaha.naz.recipe.services;

import jaha.naz.recipe.commands.RecipeCommand;
import jaha.naz.recipe.domain.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);

}
