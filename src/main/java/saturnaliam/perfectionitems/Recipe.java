package saturnaliam.perfectionitems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recipe extends RawIngredient {
    public int id;
    public List<RawIngredient> ingredients;

    public Recipe(String name, List<RawIngredient> ingredients, int id) {
        super(name);
        this.ingredients = ingredients;
        this.id = id;
    }

    public Map<String, Integer> countItems() {
        Map<String, Integer> items = new HashMap<>();
        
        for (int i = 0; i < ingredients.size(); i++) {
            Map<String, Integer> item = ingredients.get(i).countItems();
            Stream<Map.Entry<String, Integer>> combined = Stream.concat(item.entrySet().stream(), items.entrySet().stream());
            items = combined.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a + b));
        }

        return items;
    }

    public void printPretty() {
        Map<String, Integer> items = countItems();
        
        System.out.println("=== " + this.name + " ===");

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("" + entry.getKey() + ": " + entry.getValue());
        }
    }
}
