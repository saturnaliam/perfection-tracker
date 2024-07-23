package saturnaliam.perfectionitems;

public class Main {
    public static void main(String[] args) {
        

        FileIO writer = FileIO.getInstance();

        try {
            writer.serializeRecipes(getRecipes());
            writer.deserializeRecipes();
            new SaveAnalyze();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Recipe[] getRecipes() {
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
        RawIngredient taro = new RawIngredient("Taro Root");
        RawIngredient mango = new RawIngredient("Mango");
        RawIngredient rice = new RawIngredient("Rice");

        /* cooking recipes */
        Recipe bread = new RecipeBuilder("Bread", 217).addIngredient(flour).build();
        Recipe autumnsBounty = new RecipeBuilder("Autumn's Bounty", 235).addIngredient(yam).addIngredient(pumpkin).build();
        Recipe beanHotpot = new RecipeBuilder("Bean Hotpot", 207).addManyIngredients(bean, 2).build();
        Recipe cranberrySauce = new RecipeBuilder("Cranberry Sauce", 238).addIngredient(cranberries).addIngredient(sugar).build();
        Recipe eggplantParmesan = new RecipeBuilder("Eggplant Parmesan", 231).addIngredient(eggplant).addIngredient(tomato).build();
        Recipe omelet = new RecipeBuilder("Omelet", 195).addIngredient(egg).addIngredient(milk).build();
        Recipe farmersLunch = new RecipeBuilder("Farmer's Lunch", 240).addIngredient(omelet).addIngredient(parsnip).build();
        Recipe fishStew = new RecipeBuilder("Fish Stew", 728).addIngredient(crayfish).addIngredient(mussel).addIngredient(periwinkle).addIngredient(tomato).build();
        Recipe tortilla = new RecipeBuilder("Tortilla", 229).addIngredient(corn).build();
        Recipe fishTaco = new RecipeBuilder("Fish Taco", 213).addIngredient(tuna).addIngredient(tortilla).addIngredient(cabbage).addIngredient(mayo).build();
        Recipe friedCalamari = new RecipeBuilder("Fried Calamari", 202).addIngredient(squid).addIngredient(flour).addIngredient(oil).build();
        Recipe glazedYams = new RecipeBuilder("Glazed Yams", 208).addIngredient(yam).addIngredient(sugar).build();
        Recipe luckyLunch = new RecipeBuilder("Lucky Lunch", 204).addIngredient(cucumber).addIngredient(tortilla).addIngredient(jazz).build();
        Recipe poppyseedMuffin = new RecipeBuilder("Poppyseed Muffin", 651).addIngredient(poppy).addIngredient(flour).addIngredient(sugar).build();
        Recipe pumpkinPie = new RecipeBuilder("Pumpkin Pie", 608).addIngredient(pumpkin).addIngredient(flour).addIngredient(milk).addIngredient(sugar).build();
        Recipe pumpkinSoup = new RecipeBuilder("Pumpkin Soup", 236).addIngredient(pumpkin).addIngredient(milk).build();
        Recipe radishSalad = new RecipeBuilder("Radish Salad", 609).addIngredient(oil).addIngredient(vinegar).addIngredient(radish).build();
        Recipe redPlate = new RecipeBuilder("Red Plate", 230).addIngredient(cabbage).addIngredient(radish).build();
        Recipe rhubardPie = new RecipeBuilder("Rhubarb Pie", 222).addIngredient(rhubarb).addIngredient(sugar).addIngredient(flour).build();
        Recipe roastedHazelnuts = new RecipeBuilder("Roasted Hazelnuts", 607).addManyIngredients(hazelnut, 3).build();
        Recipe salmonDinner = new RecipeBuilder("Salmon Dinner", 212).addIngredient(amaranth).addIngredient(salmon).addIngredient(kale).build();
        Recipe spicyEel = new RecipeBuilder("Spicy Eel", 226).addIngredient(eel).addIngredient(pepper).build();
        Recipe stirFry = new RecipeBuilder("Stir Fry", 606).addIngredient(caveCarrot).addIngredient(mushroom).addIngredient(kale).addIngredient(oil).build();
        Recipe strangeBun = new RecipeBuilder("Strange Bun", 203).addIngredient(flour).addIngredient(periwinkle).addIngredient(voidMayo).build();
        Recipe stuffing = new RecipeBuilder("Stuffing", 239).addIngredient(bread).addIngredient(hazelnut).addIngredient(cranberries).build();
        Recipe superMeal = new RecipeBuilder("Super Meal", 237).addIngredient(bokChoy).addIngredient(cranberries).addIngredient(artichoke).build();
        Recipe survivalBurger = new RecipeBuilder("Survival Burger", 241).addIngredient(bread).addIngredient(caveCarrot).addIngredient(eggplant).build();
        Recipe tropicalCurry = new RecipeBuilder("Tropical Curry", 907).addIngredient(coconut).addIngredient(pineapple).addIngredient(pepper).build();
        Recipe mangoRice = new RecipeBuilder("Mango Sticky Rice", 905).addIngredient(mango).addIngredient(coconut).addIngredient(rice).build();
        Recipe poi = new RecipeBuilder("Poi", 906).addManyIngredients(taro, 4).build();

        Recipe[] recipes = { bread, autumnsBounty, beanHotpot, cranberrySauce, eggplantParmesan, omelet, farmersLunch, fishStew, tortilla, fishTaco, 
                 friedCalamari, glazedYams, luckyLunch, poppyseedMuffin, pumpkinPie, pumpkinSoup, radishSalad, redPlate, rhubardPie, 
                 roastedHazelnuts, salmonDinner, spicyEel, stirFry, strangeBun, stuffing, superMeal, survivalBurger, tropicalCurry, mangoRice, poi };
        return recipes;
    }
}