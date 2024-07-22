package saturnaliam.perfectionitems;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RawIngredient implements Serializable {
    public String name;

    public RawIngredient(String name) {
        this.name = name;
    }

    public Map<String, Integer> countItems() {
        Map<String, Integer> items = new HashMap<>();
        items.put(this.name, 1);
        return items;
    }
}
