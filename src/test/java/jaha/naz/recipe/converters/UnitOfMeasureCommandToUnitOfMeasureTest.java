package jaha.naz.recipe.converters;

import jaha.naz.recipe.commands.UnitOfMeasureCommand;
import jaha.naz.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    static final String desc= "description";
    static final Long  id= new Long(1);
    UnitOfMeasureCommandToUnitOfMeasure convertor;

    @Before
    public void setUp() throws Exception {
        convertor= new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void nullTest() {
        assertNull(convertor.convert(null));
    }

    @Test
    public void notNullTest() {
        assertNotNull(new UnitOfMeasureCommand());
    }

    @Test
    public void convert() {
        UnitOfMeasureCommand unitOfMeasureCommand= new UnitOfMeasureCommand();
        unitOfMeasureCommand.setDescription(desc);
        unitOfMeasureCommand.setId(id);

        UnitOfMeasure unitOfMeasure= convertor.convert(unitOfMeasureCommand);

        assertEquals(id, unitOfMeasure.getId());
        assertEquals(desc, unitOfMeasure.getDescription());
    }
}