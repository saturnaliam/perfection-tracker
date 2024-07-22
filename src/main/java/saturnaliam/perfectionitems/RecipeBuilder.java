package saturnaliam.perfectionitems;

import java.util.ArrayList;
import java.util.List;

public class RecipeBuilder {
    private String name = null;
    private int id = -1;
    private List<RawIngredient> ingredients = new ArrayList<RawIngredient>();

    RecipeBuilder addId(int id) {
        this.id = id;
        return this;
    }

    RecipeBuilder addName(String name) {
        this.name = name;
        return this;
    }

    RecipeBuilder addIngredient(RawIngredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    RecipeBuilder addManyIngredients(RawIngredient ingredient, int count) {
        for (int i = 0; i < count; i++) {
            this.addIngredient(ingredient);
        }

        return this;
    }

    Recipe build() {
        try {
            return new Recipe(this.name, this.ingredients, this.id);
        } catch (Exception e) {
            throw e;
        }
    }
}
