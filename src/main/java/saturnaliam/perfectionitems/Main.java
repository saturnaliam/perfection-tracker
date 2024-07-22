package saturnaliam.perfectionitems;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /* raw ingredients */
        RawIngredient yam = new RawIngredient("Yam");
        RawIngredient pumpkin = new RawIngredient("Pumpkin");
        RawIngredient bean = new RawIngredient("Green Bean");
        RawIngredient cranberries = new RawIngredient("Cranberries");
        RawIngredient sugar = new RawIngredient("Sugar");
        RawIngredient eggplant = new RawIngredient("Eggplant");
        RawIngredient tomato = new RawIngredient("Tomato");
        RawIngredient parsnip = new RawIngredient("Parsnip");
        RawIngredient egg = new RawIngredient("Egg");
        RawIngredient milk = new RawIngredient("Milk");
        RawIngredient crayfish = new RawIngredient("Crayfish");
        RawIngredient mussel = new RawIngredient("Mussel");
        RawIngredient periwinkle = new RawIngredient("Periwinkle");
        RawIngredient tuna = new RawIngredient("Tuna");
        RawIngredient cabbage = new RawIngredient("Red Cabbage");
        RawIngredient mayo = new RawIngredient("Mayonnaise");
        RawIngredient corn = new RawIngredient("Corn");
        RawIngredient squid = new RawIngredient("Squid");
        RawIngredient flour = new RawIngredient("Wheat Flour");
        RawIngredient oil = new RawIngredient("Oil");
        RawIngredient cucumber = new RawIngredient("Sea Cucumber");
        RawIngredient jazz = new RawIngredient("Blue Jazz");
        RawIngredient poppy = new RawIngredient("Poppy");
        RawIngredient radish = new RawIngredient("Radish");
        RawIngredient vinegar = new RawIngredient("Vinegar");
        RawIngredient rhubarb = new RawIngredient("Rhubarb");
        RawIngredient hazelnut = new RawIngredient("Hazelnut");
        RawIngredient salmon = new RawIngredient("Salmon");
        RawIngredient amaranth = new RawIngredient("Amaranth");
        RawIngredient kale = new RawIngredient("Kale");
        RawIngredient eel = new RawIngredient("Eel");
        RawIngredient pepper = new RawIngredient("Hot Pepper");
        RawIngredient caveCarrot = new RawIngredient("Cave Carrot");
        RawIngredient mushroom = new RawIngredient("Common Mushroom");
        RawIngredient voidMayo = new RawIngredient("Void Mayonnaise");
        RawIngredient bokChoy = new RawIngredient("Bok Choy");
        RawIngredient artichoke = new RawIngredient("Artichoke");
        RawIngredient pineapple = new RawIngredient("Pineapple");
        RawIngredient coconut = new RawIngredient("Coconut");
        //RawIngredient taro = new RawIngredient("Taro Root");
        RawIngredient mango = new RawIngredient("Mango");
        RawIngredient rice = new RawIngredient("Rice");

        /* cooking recipes */
        Recipe bread = new RecipeBuilder().addName("Bread").addId(217).addIngredient(flour).build();
        Recipe autumnsBounty = new RecipeBuilder().addName("Autumn's Bounty").addId(235).addIngredient(yam).addIngredient(pumpkin).build();
        Recipe beanHotpot = new RecipeBuilder().addName("Bean Hotpot").addId(207).addManyIngredients(bean, 2).build();
        Recipe cranberrySauce = new RecipeBuilder().addName("Cranberry Sauce").addId(238).addIngredient(cranberries).addIngredient(sugar).build();
        Recipe eggplantParmesan = new RecipeBuilder().addName("Eggplant Parmesan").addId(231).addIngredient(eggplant).addIngredient(tomato).build();
        Recipe omelet = new RecipeBuilder().addName("Omelet").addId(195).addIngredient(egg).addIngredient(milk).build();
        Recipe farmersLunch = new RecipeBuilder().addName("Farmer's Lunch").addId(240).addIngredient(omelet).addIngredient(parsnip).build();
        Recipe fishStew = new RecipeBuilder().addName("Fish Stew").addId(728).addIngredient(crayfish).addIngredient(mussel).addIngredient(periwinkle).addIngredient(tomato).build();
        Recipe tortilla = new RecipeBuilder().addName("Tortilla").addId(229).addIngredient(corn).build();
        Recipe fishTaco = new RecipeBuilder().addName("Fish Taco").addId(213).addIngredient(tuna).addIngredient(tortilla).addIngredient(cabbage).addIngredient(mayo).build();
        Recipe friedCalamari = new RecipeBuilder().addName("Fried Calamari").addId(202).addIngredient(squid).addIngredient(flour).addIngredient(oil).build();
        Recipe glazedYams = new RecipeBuilder().addName("Glazed Yams").addId(208).addIngredient(yam).addIngredient(sugar).build();
        Recipe luckyLunch = new RecipeBuilder().addName("Lucky Lunch").addId(204).addIngredient(cucumber).addIngredient(tortilla).addIngredient(jazz).build();
        Recipe poppyseedMuffin = new RecipeBuilder().addName("Poppyseed Muffin").addId(651).addIngredient(poppy).addIngredient(flour).addIngredient(sugar).build();
        Recipe pumpkinPie = new RecipeBuilder().addName("Pumpkin Pie").addId(608).addIngredient(pumpkin).addIngredient(flour).addIngredient(milk).addIngredient(sugar).build();
        Recipe pumpkinSoup = new RecipeBuilder().addName("Pumpkin Soup").addId(236).addIngredient(pumpkin).addIngredient(milk).build();
        Recipe radishSalad = new RecipeBuilder().addName("Radish Salad").addId(609).addIngredient(oil).addIngredient(vinegar).addIngredient(radish).build();
        Recipe redPlate = new RecipeBuilder().addName("Red Plate").addId(230).addIngredient(cabbage).addIngredient(radish).build();
        Recipe rhubardPie = new RecipeBuilder().addName("Rhubarb Pie").addId(222).addIngredient(rhubarb).addIngredient(sugar).addIngredient(flour).build();
        Recipe roastedHazelnuts = new RecipeBuilder().addName("Roasted Hazelnuts").addId(607).addManyIngredients(hazelnut, 3).build();
        Recipe salmonDinner = new RecipeBuilder().addName("Salmon Dinner").addId(212).addIngredient(amaranth).addIngredient(salmon).addIngredient(kale).build();
        Recipe spicyEel = new RecipeBuilder().addName("Spicy Eel").addId(226).addIngredient(eel).addIngredient(pepper).build();
        Recipe stirFry = new RecipeBuilder().addName("Stir Fry").addId(606).addIngredient(caveCarrot).addIngredient(mushroom).addIngredient(kale).addIngredient(oil).build();
        Recipe strangeBun = new RecipeBuilder().addName("Strange Bun").addId(203).addIngredient(flour).addIngredient(periwinkle).addIngredient(voidMayo).build();
        Recipe stuffing = new RecipeBuilder().addName("Stuffing").addId(239).addIngredient(bread).addIngredient(hazelnut).addIngredient(cranberries).build();
        Recipe superMeal = new RecipeBuilder().addName("Super Meal").addId(237).addIngredient(bokChoy).addIngredient(cranberries).addIngredient(artichoke).build();
        Recipe survivalBurger = new RecipeBuilder().addName("Survival Burger").addId(241).addIngredient(bread).addIngredient(caveCarrot).addIngredient(eggplant).build();
        Recipe tropicalCurry = new RecipeBuilder().addName("Tropical Curry").addId(907).addIngredient(coconut).addIngredient(pineapple).addIngredient(pepper).build();
        Recipe mangoRice = new RecipeBuilder().addName("Mango Sticky Rice").addId(905).addIngredient(mango).addIngredient(coconut).addIngredient(rice).build();
        //Recipe poi = new RecipeBuilder().addName("Poi").addId(906).addManyIngredients(taro, 4).build();

        FileIO writer = FileIO.getInstance();
        Recipe[] recipes = { mangoRice, superMeal };
        writer.serializeRecipes(recipes);
        writer.deserializeRecipes();
    }

    private static Map<String, Integer> countIngredients(Recipe[] recipes) {
        Map<String, Integer> items = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            Stream<Map.Entry<String, Integer>> combined = Stream.concat(recipes[i].countItems().entrySet().stream(), items.entrySet().stream());
            items = combined.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a + b));
        }
        
        return items;
    }
}