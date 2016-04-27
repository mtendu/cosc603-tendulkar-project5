package edu.towson.cis.cosc603.project5.coffeemaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: Auto-generated Javadoc
/**
 * Starts the console UI for the CoffeeMaker.
 *
 * @author Josh
 * @version $Revision: 1.0 $
 */
public class Main {
    
    /** The coffee maker. */
    private static CoffeeMaker coffeeMaker;

    /**
     * Main menu.
     */
    public static void mainMenu() {
    	
    		Recipe [] recipes = coffeeMaker.getRecipes();
            for(int i = 0; i < recipes.length; i++) {
                System.out.println((i+1) + ". " + recipes[i].getName() +
                		recipes[i].getPrice() +
                		recipes[i].getAmtCoffee() +
                		recipes[i].getAmtMilk() +
                		recipes[i].getAmtSugar() +
                		recipes[i].getAmtChocolate());
                		
            }
    	
        System.out.println("1. Add a recipe");
        System.out.println("2. Delete a recipe");
        System.out.println("3. Edit a recipe");
        System.out.println("4. Add inventory");
        System.out.println("5. Check inventory");
        System.out.println("6. Make coffee");
        System.out.println("0. Exit");
        Main main = new Main();

        //Get user input
        int userInput = main.stringToInt(main.inputOutput("Please press the number that corresponds to what you would like the coffee maker to do."));
        if(userInput == 1) main.addRecipe();
        if(userInput == 2) main.deleteRecipe();
        if(userInput == 3) main.editRecipe();
        if(userInput == 4) main.addInventory();
        if(userInput == 5) main.checkInventory();
        if(userInput == 6) main.makeCoffee();
        if(userInput == 0) System.exit(0);
    }
	
	/**
	 * Adds the recipe.
	 */
	public  void addRecipe() {
	    //Read in recipe name
	    final String name = inputOutput("Please enter the recipe name: ");
	    
	    //Read in recipe price
	    final String priceString = inputOutput("Please enter the recipe price: $");
	    final int price = stringToInt(priceString);
	    if(price < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt coffee
	    final String coffeeString = inputOutput("Please enter the units of coffee in the recipe: ");
	    final int amtCoffee = stringToInt(coffeeString);
	    if(amtCoffee < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt milk
	    final String milkString = inputOutput("Please enter the units of milk in the recipe: ");
	    int amtMilk = stringToInt(milkString);
	    if(amtMilk < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt sugar
	    final String sugarString = inputOutput("Please enter the units of sugar in the recipe: ");
	    int amtSugar = stringToInt(sugarString);
	    if(amtSugar < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt chocolate
	    final String chocolateString = inputOutput("Please enter the units of chocolate in the recipe: ");
	    int amtChocolate = stringToInt(chocolateString);
	    if(amtChocolate < 0) {
	    	mainMenu();
	    }
	    
	    boolean recipeAdded = false;
		Recipe r = new Recipe();
		r.setName(name);
		r.setPrice(price);
		r.setAmtCoffee(amtCoffee);
		r.setAmtMilk(amtMilk);
		r.setAmtSugar(amtSugar);
		r.setAmtChocolate(amtChocolate);
		   
		recipeAdded = coffeeMaker.addRecipe(r);
	    
	    if(recipeAdded) System.out.println(name + " successfully added.");
	    else System.out.println(name + "could not be added.");
	    
	    mainMenu();
    }
    
    /**
     * Delete recipe.
     */
    public  void deleteRecipe() {
        Recipe [] recipes = coffeeMaker.getRecipes();
        for(int i = 0; i < recipes.length; i++) {
            System.out.println((i+1) + ". " + recipes[i].getName());
        }
        String recipeToDeleteString = inputOutput("Please select the number of the recipe to delete.");
        int recipeToDeleteIndx = stringToInt(recipeToDeleteString) - 1;
	    if(recipeToDeleteIndx < 0) {
	    	mainMenu();
	    }
        
	    Recipe recipeToDelete = recipes[recipeToDeleteIndx];
        boolean recipeDeleted = coffeeMaker.deleteRecipe(recipeToDelete);
        
        if(recipeDeleted) System.out.println(recipeToDelete.getName() + " successfully deleted.");
	    else System.out.println(recipeToDelete.getName() + "could not be deleted.");
        
        mainMenu();
    }
    
    /**
     * Edits the recipe.
     */
    public  void editRecipe() {
        Recipe [] recipes = coffeeMaker.getRecipes();
        for(int i = 0; i < recipes.length; i++) {
            System.out.println((i+1) + ". " + recipes[i].getName());
        }
        final String recipeToEditString = inputOutput("Please select the number of the recipe to edit.");
        int recipeToEdit = stringToInt(recipeToEditString) -1;
	    if(recipeToEdit < 0) {
	    	mainMenu();
	    }
        
        Recipe oldRecipe = recipes[recipeToEdit];
        
	    //Read in recipe name
        final String name = inputOutput("Please enter the recipe name: ");
	    
	    //Read in recipe price
        final String priceString = inputOutput("Please enter the recipe price: $");
	    int price = stringToInt(priceString);
	    if(price < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt coffee
	    final String coffeeString = inputOutput("Please enter the units of coffee in the recipe: ");
	    int amtCoffee = stringToInt(coffeeString);
	    if(amtCoffee < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt milk
	    final String milkString = inputOutput("Please enter the units of milk in the recipe: ");
	    int amtMilk = stringToInt(milkString);
	    if(amtMilk < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt sugar
	    final String sugarString = inputOutput("Please enter the units of sugar in the recipe: ");
	    int amtSugar = stringToInt(sugarString);
	    if(amtSugar < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt chocolate
	    final String chocolateString = inputOutput("Please enter the units of chocolate in the recipe: ");
	    int amtChocolate = stringToInt(chocolateString);
	    if(amtChocolate < 0) {
	    	mainMenu();
	    }
	    
	    Recipe newRecipe = new Recipe();
	    newRecipe.setName(name);
	    newRecipe.setPrice(price);
	    newRecipe.setAmtCoffee(amtCoffee);
	    newRecipe.setAmtMilk(amtMilk);
	    newRecipe.setAmtSugar(amtSugar);
	    newRecipe.setAmtChocolate(amtChocolate);
        
        boolean recipeEdited = coffeeMaker.editRecipe(oldRecipe, newRecipe);
        
        if(recipeEdited) System.out.println(oldRecipe.getName() + " successfully edited.");
	    else System.out.println(oldRecipe.getName() + "could not be edited.");
        
        mainMenu();
    }
    
    /**
     * Adds the inventory.
     */
    public  void addInventory() {
	    //Read in amt coffee
    	final String coffeeString = inputOutput("Please enter the units of coffee to add: ");
	    int amtCoffee = stringToInt(coffeeString);
	    if(amtCoffee < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt milk
	    final String milkString = inputOutput("Please enter the units of milk to add: ");
	    int amtMilk = stringToInt(milkString);
	    if(amtMilk < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt sugar
	    final String sugarString = inputOutput("Please enter the units of sugar to add: ");
	    int amtSugar = stringToInt(sugarString);
	    if(amtSugar < 0) {
	    	mainMenu();
	    }
	    
	    //Read in amt chocolate
	    final String chocolateString = inputOutput("Please enter the units of chocolate to add: ");
	    int amtChocolate = stringToInt(chocolateString);
	    if(amtChocolate < 0) {
	    	mainMenu();
	    }
	    
        coffeeMaker.addInventory(amtCoffee, amtMilk, amtSugar, amtChocolate);
        mainMenu();
    }
    
    /**
     * Check inventory.
     */
    public  void checkInventory() {
        Inventory inventory = coffeeMaker.checkInventory();
        System.out.println(inventory.toString());
        mainMenu();
    }
    
    /**
     * Make coffee.
     */
    public  void makeCoffee() {
        Recipe [] recipes = coffeeMaker.getRecipes();
        for(int i = 0; i < recipes.length; i++) {
            System.out.println((i+1) + ". " + recipes[i].getName());
        }
        String recipeToPurchaseString = inputOutput("Please select the number of the recipe to purchase.");
        int recipeToPurchase = stringToInt(recipeToPurchaseString) -1;
	    if(recipeToPurchase < 0) {
	    	mainMenu();
	    }
        
        String amountPaid = inputOutput("Please enter the amount you wish to pay");
        int amountToPay = stringToInt(amountPaid);
	    if(amountToPay < 0) {
	    	mainMenu();
	    }
        
        Recipe recipe = recipes[recipeToPurchase];
        int change = coffeeMaker.makeCoffee(recipe, amountToPay);
        
        System.out.println("Your change is: " + change );
        mainMenu();
    }
    
    /**
     * Method inputOutput.
     * @param message String
     * @return String
     */
    public  String inputOutput(String message) {
        System.out.println(message);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String returnString = "";
	    try {
	        returnString = br.readLine();
	    }
	    catch (IOException e){
	        System.out.println("Error reading in value");
	        mainMenu();
	    }
	    return returnString;
    }
    
    /**
     * Method stringToInt.
     * @param value String
     * @return int
     */
    private  int stringToInt(String value) {
        int returnInt = -1;
        try {
            returnInt = Integer.parseInt(value);
        }
        catch (NumberFormatException e) {
            System.out.println("Please input an integer");
        }
        return returnInt;
    }
    
    /**
     * Method main.
     * @param args String[]
     */
    public static void main(String[] args) {
	    coffeeMaker = new CoffeeMaker();
	    System.out.println("Welcome to the CoffeeMaker!");
	    mainMenu();
	    
	}
}
