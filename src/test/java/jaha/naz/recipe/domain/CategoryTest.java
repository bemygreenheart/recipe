package jaha.naz.recipe.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() throws Exception {
        category= new Category();
    }

    @Test
    public void setId(){
        Long value=1L;
        category.setId(value);
        assertEquals(value,category.getId());
    }

    @Test
    public void getId() {
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void setDescription() {
    }
}