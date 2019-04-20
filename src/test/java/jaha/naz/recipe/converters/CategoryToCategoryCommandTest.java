package jaha.naz.recipe.converters;

import jaha.naz.recipe.commands.CategoryCommand;
import jaha.naz.recipe.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final Long ID= new Long(2);
    public static final String DESCRIPTION="desription";
    CategoryToCategoryCommand categoryToCategoryCommand;

    @Before
    public void setUp() throws Exception {
        categoryToCategoryCommand= new CategoryToCategoryCommand();
    }

    @Test
    public void nullTest(){
        assertNull(categoryToCategoryCommand.convert(null));
    }

    @Test
    public void notNullTest(){
        assertNotNull(categoryToCategoryCommand.convert(new Category()));
    }

    @Test
    public void convert() {
        Category category= new Category();
        category.setId(ID);
        category.setDescription(DESCRIPTION);

        CategoryCommand categoryCommand= categoryToCategoryCommand.convert(category);

        assertEquals(ID,categoryCommand.getId());
        assertEquals(DESCRIPTION,category.getDescription());
    }
}