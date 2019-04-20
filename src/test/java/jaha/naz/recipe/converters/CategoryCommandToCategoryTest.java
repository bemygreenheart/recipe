package jaha.naz.recipe.converters;

import jaha.naz.recipe.commands.CategoryCommand;
import jaha.naz.recipe.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE=new Long(1);
    public static final String DESCRIPTION= "description";
    CategoryCommandToCategory convertor;

    @Before
    public void setUp() throws Exception {
        convertor= new CategoryCommandToCategory();
    }

    @Test
    public void nullTest(){
        assertNull(convertor.convert(null));
    }

    @Test
    public void notNullTest(){
        assertNotNull(convertor.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {

        CategoryCommand categoryCommand= new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        Category category=convertor.convert(categoryCommand);

        assertEquals(category.getId(), categoryCommand.getId());
        assertEquals(category.getDescription(), categoryCommand.getDescription());

    }
}