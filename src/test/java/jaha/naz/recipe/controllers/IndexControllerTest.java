package jaha.naz.recipe.controllers;

import jaha.naz.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    private IndexController indexController;

    @Before
    public void setUp() throws Exception {
      MockitoAnnotations.initMocks(this);
      indexController= new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {

        String value= indexController.getIndexPage(model);

        assertEquals("index",value);

        verify(recipeService,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),anySet());

    }
}