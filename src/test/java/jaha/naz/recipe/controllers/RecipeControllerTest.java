package jaha.naz.recipe.controllers;

import jaha.naz.recipe.domain.Recipe;
import jaha.naz.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RecipeControllerTest {

    @Mock
    RecipeService recipeService;
    RecipeController recipeController;
    MockMvc mockMvc;
    Recipe recipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
        mockMvc= MockMvcBuilders.standaloneSetup(recipeController).build();

        recipe= new Recipe();
        recipe.setId(1L);
    }

    @Test
    public void showRecipe() throws Exception {

        when(recipeService.findById(any())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/1")).andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));

        verify(recipeService, times(1)).findById(anyLong());

    }
}