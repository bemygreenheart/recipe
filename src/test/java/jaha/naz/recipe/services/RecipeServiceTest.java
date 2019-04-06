package jaha.naz.recipe.services;

import jaha.naz.recipe.domain.Recipe;
import jaha.naz.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceTest {

    @Mock
    RecipeRepository recipeRepository;
    private RecipeService recipeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService= new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void  getRecipesTest(){
        Set<Recipe> recipes= new HashSet<>();
        recipes.add(new Recipe());

        when(recipeRepository.findAll()).thenReturn(recipes);

        assertEquals(1,recipeService.getRecipes().size());

        verify(recipeRepository, times(1)).findAll();

    }
}