package jaha.naz.recipe.converters;

import jaha.naz.recipe.commands.IngredientCommand;
import jaha.naz.recipe.commands.UnitOfMeasureCommand;
import jaha.naz.recipe.domain.Ingredient;
import jaha.naz.recipe.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    static final Long ID= new Long(1);
    static final BigDecimal AMOUNT=new BigDecimal(1);
    static final Recipe RECIPE= new Recipe();
    static final Long uom_id= new Long(2);
    static final String DESC= "Cheeseburger";

    IngredientCommandToIngredient convertor;

    @Before
    public void setUp() throws Exception {
        convertor= new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObject() {
        assertNull(convertor.convert(null));
    }

    @Test
    public void testNotNullObject() {
        assertNotNull(convertor.convert(new IngredientCommand()));
    }

    @Test
    public void convert() {
        IngredientCommand ingredientCommand= new IngredientCommand();
        UnitOfMeasureCommand unitOfMeasureCommand= new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(uom_id);
        ingredientCommand.setUnitOfMeasureCommand(unitOfMeasureCommand);
        ingredientCommand.setDescription(DESC);
        ingredientCommand.setAmount(AMOUNT);
        ingredientCommand.setId(ID);

        Ingredient ingredient= convertor.convert(ingredientCommand);

        assertEquals(uom_id, ingredient.getUom().getId());
        assertEquals(ID, ingredient.getId());
        assertEquals(DESC, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertNull(ingredient.getRecipe());
    }
}