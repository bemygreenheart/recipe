package jaha.naz.recipe.commands;

import jaha.naz.recipe.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class RecipeCommand {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Byte[] image;
    private NotesCommand notesCommand;
    private Set<IngredientCommand> ingredientCommands = new HashSet<>();
    private Difficulty difficulty;
    private Set<CategoryCommand> categoryCommands= new HashSet<>();

}
