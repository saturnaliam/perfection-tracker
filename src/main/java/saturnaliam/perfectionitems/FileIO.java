package saturnaliam.perfectionitems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// NO LOOKING!!! BAD CODE!!!!

public class FileIO {
    private FileIO() {};

    private static class FileWriterHolder {
        public static final FileIO instance = new FileIO();
    }

    public static FileIO getInstance() {
        return FileWriterHolder.instance;
    }
    
    public void serializeRecipes(Recipe[] recipes) throws Exception {
        File recipesDirectory = new File("recipes");
        if (!recipesDirectory.exists()) {
            recipesDirectory.mkdir();
        }

        for (Recipe recipe : recipes) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("recipes/" + getFilename(recipe.name) + ".ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(recipe);
                objectOutputStream.flush();
                objectOutputStream.close();
            } catch (Exception e) {
               throw(e);
            }
        }
    }

    public Map<Integer, Recipe> deserializeRecipes() throws Exception {
        Map<Integer, Recipe> recipes = new HashMap<>();
        try {
            Stream<Path> pathStream = Files.walk(Paths.get("recipes/"));
            List<Path> paths = pathStream.filter(Files::isRegularFile).collect(Collectors.toList());

            for (Path path : paths) {
                Recipe r = deserializeRecipe(path.toString());
                recipes.put(r.id, r);
            }

            pathStream.close();
        } catch (Exception e) {
            throw(e);
        }

        return recipes;
    }

    private Recipe deserializeRecipe(String filename) throws Exception {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Recipe r = (Recipe) objectInputStream.readObject();
            objectInputStream.close();
            return r;
        } catch (Exception e) {
            throw(e);
        }
    }

    private String getFilename(String name) {
        final Pattern removeSpace = Pattern.compile(" ");
        final Matcher spaceMatcher = removeSpace.matcher(name);
        return spaceMatcher.replaceAll("_").toLowerCase();
    }
}
