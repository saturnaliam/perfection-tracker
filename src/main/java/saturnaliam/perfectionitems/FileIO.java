package saturnaliam.perfectionitems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.regex.*;

public class FileIO {
    private FileIO() {};

    private static class FileWriterHolder {
        public static final FileIO instance = new FileIO();
    }

    public static FileIO getInstance() {
        return FileWriterHolder.instance;
    }
    
    public void serializeRecipes(Recipe[] recipes) {
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
                e.printStackTrace();
            }
        }
    }

    public void deserializeRecipes() {
        try {
            FileInputStream fileInputStream = new FileInputStream("recipes/super_meal.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Recipe r = (Recipe) objectInputStream.readObject();
            r.printPretty();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getFilename(String name) {
        final Pattern removeSpace = Pattern.compile(" ");
        final Matcher spaceMatcher = removeSpace.matcher(name);
        return spaceMatcher.replaceAll("_").toLowerCase();
    }
}
