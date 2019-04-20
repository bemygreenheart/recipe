package jaha.naz.recipe.converters;

import jaha.naz.recipe.commands.NotesCommand;
import jaha.naz.recipe.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToNotesCommandTest {

    static final Long ID= new Long(1);
    static final String recipeNote= "Find the way";

    NotesToNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter= new NotesToNotesCommand();

    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testNotNullObject() {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    public void convert() {
        Notes notes= new Notes();
        notes.setId(ID);
        notes.setRecipeNotes(recipeNote);

        NotesCommand notesCommand=converter.convert(notes);

        assertEquals(ID, notesCommand.getId());
        assertEquals(recipeNote, notesCommand.getRecipeNotes());
    }
}