package roman.com.listviewtestproject;

import java.util.ArrayList;

/**
 * Created by roman on 3/8/17.
 */

public class Data {
    public static ArrayList<Recipe> getRecipes() {
        final ArrayList<Recipe> recipeList = new ArrayList<>(30);

        recipeList.add(new Recipe("Fried Chicken"));
        recipeList.add(new Recipe("Chicken Soup"));
        recipeList.add(new Recipe("Boiled Chicken"));
        recipeList.add(new Recipe("Chicken Nuggets"));
        recipeList.add(new Recipe("Sweet and Sour Chicken Wings"));
        recipeList.add(new Recipe("Grilled Chicken"));
        recipeList.add(new Recipe("Fried Chicken"));
        recipeList.add(new Recipe("Chicken Soup"));
        recipeList.add(new Recipe("Boiled Chicken"));
        recipeList.add(new Recipe("Chicken Nuggets"));
        recipeList.add(new Recipe("Sweet and Sour Chicken Wings"));
        recipeList.add(new Recipe("Grilled Chicken"));
        recipeList.add(new Recipe("Fried Chicken"));
        recipeList.add(new Recipe("Chicken Soup"));
        recipeList.add(new Recipe("Boiled Chicken"));
        recipeList.add(new Recipe("Chicken Nuggets"));
        recipeList.add(new Recipe("Sweet and Sour Chicken Wings"));
        recipeList.add(new Recipe("Grilled Chicken"));

        return recipeList;
    }
}
