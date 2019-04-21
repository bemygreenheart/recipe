package jaha.naz.recipe.services;

import jaha.naz.recipe.converters.RecipeCommandToRecipe;
import jaha.naz.recipe.converters.RecipeToRecipeCommand;
import jaha.naz.recipe.domain.Recipe;
import jaha.naz.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceTest {

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    //@Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    private RecipeService recipeService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService= new RecipeServiceImpl(recipeRepository,recipeCommandToRecipe,recipeToRecipeCommand);
    }

    @Test
    public void  getRecipesTest(){
        Set<Recipe> recipes= new HashSet<>();
        recipes.add(new Recipe());

        when(recipeRepository.findAll()).thenReturn(recipes);

        assertEquals(1,recipeService.getRecipes().size());

        verify(recipeRepository, times(1)).findAll();

    }

    @Test
    public void findById() {
        Recipe recipe= new Recipe();
        recipe.setId(1L);

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        Recipe returnRecipe=recipeService.findById(1l);
        assertNotNull(returnRecipe);
        assertEquals(new Long(1),returnRecipe.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}