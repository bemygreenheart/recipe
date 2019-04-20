package jaha.naz.recipe.converters;

import jaha.naz.recipe.commands.UnitOfMeasureCommand;
import jaha.naz.recipe.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    static final Long ID= new Long(1);
    static final String desc= "description";
    UnitOfMeasureToUnitOfMeasureCommand convertor;

    @Before
    public void setUp() throws Exception {
        convertor= new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void notNullTest() {
        assertNotNull(convertor.convert(new UnitOfMeasure()));
    }

    @Test
    public void nullTest() {
        assertNull(convertor.convert(null));
    }

    @Test
    public void convert() {
        UnitOfMeasure unitOfMeasure= new UnitOfMeasure();
        unitOfMeasure.setId(ID);
        unitOfMeasure.setDescription(desc);

        UnitOfMeasureCommand unitOfMeasureCommand= convertor.convert(unitOfMeasure);

        assertEquals(ID, unitOfMeasureCommand.getId());
        assertEquals(desc, unitOfMeasureCommand.getDescription());
    }
}