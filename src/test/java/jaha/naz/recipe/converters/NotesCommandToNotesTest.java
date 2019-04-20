package jaha.naz.recipe.converters;

import jaha.naz.recipe.commands.NotesCommand;
import jaha.naz.recipe.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {
    static final Long ID= new Long(1);
    static final String recipeNote= "Find the way";

    NotesCommandToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter= new NotesCommandToNotes();

    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testNotNullObject() {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert() {
        NotesCommand notesCommand= new NotesCommand();
        notesCommand.setId(ID);
        notesCommand.setRecipeNotes(recipeNote);

        Notes notes=converter.convert(notesCommand);

        assertEquals(ID, notes.getId());
        assertEquals(recipeNote, notes.getRecipeNotes());
    }
}