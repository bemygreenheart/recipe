package jaha.naz.recipe.converters;

import jaha.naz.recipe.commands.IngredientCommand;
import jaha.naz.recipe.domain.Ingredient;
import jaha.naz.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class IngredientToIngredientCommandTest {

    static final Long ID=new Long(1);
    static final String DESCRIPTION="Goucumola";
    static final BigDecimal AMOUNT=new BigDecimal(2);
    static final Long UOMC_ID= new Long(2);

    IngredientToIngredientCommand convertor;

    @Before
    public void setUp() throws Exception {
        convertor = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullObject() {
        assertNull(convertor.convert(null));
    }

    @Test
    public void testNotNullObject() {
        assertNotNull(convertor.convert(new Ingredient()));
    }

    @Test
    public void convert() {
        Ingredient ingredient= new Ingredient();
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        ingredient.setId(ID);
        UnitOfMeasure unitOfMeasure= new UnitOfMeasure();
        unitOfMeasure.setId(UOMC_ID);
        ingredient.setUom(unitOfMeasure);

        IngredientCommand ingredientCommand= convertor.convert(ingredient);

        assertEquals(ID, ingredientCommand.getId());
        assertEquals(UOMC_ID, ingredientCommand.getUnitOfMeasureCommand().getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT,ingredient.getAmount());
    }
}