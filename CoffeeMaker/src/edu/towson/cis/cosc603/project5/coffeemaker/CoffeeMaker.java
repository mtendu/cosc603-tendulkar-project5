package edu.towson.cis.cosc603.project5.coffeemaker;
// TODO: Auto-generated Javadoc

/**
 * CoffeeMaker object.
 *
 * @version $Revision: 1.0 $
 */
public class CoffeeMaker {
	
	/**  Array of recipes in coffee maker. */
	private Recipe [] recipeArray;
	
	/**  Number of recipes in coffee maker. */
	private final int NUM_RECIPES = 4;
	
	/**  Array describing if the array is full. */
	private boolean [] recipeFull;
	
	/**  Inventory of the coffee maker. */
    private Inventory inventory;
	
    /**
     * Constructor for the coffee maker.
     */
	public CoffeeMaker() {
	    recipeArray = new Recipe[NUM_RECIPES];
	    recipeFull = new boolean[NUM_RECIPES];
		for(int i = 0; i < NUM_RECIPES; i++) {
		   recipeArray[i] = new Recipe();
		   recipeFull[i] = false;
		}
		inventory = new Inventory();
	}

	/**
	 * Returns true if a recipe is successfully added to the 
	 * coffee maker.
	 *
	 * @param r the r
	 * @return boolean
	 */
	public boolean addRecipe(Recipe r) {
        boolean canAddRecipe = true;
          canAddRecipe = isRecipeExist(r);  
       
        
        //Check for an empty recipe, add recipe to first empty spot
        if(canAddRecipe) {
        	int emptySpot = returnEmptySpot();
			
        	if(emptySpot != -1) {
        		recipeArray[emptySpot] = r;
        		recipeFull[emptySpot] = true;
        	}
        	else {
        		canAddRecipe = false;
        	}
        }
        return canAddRecipe;
    }

	/**
	 * Checks if is empty spot.
	 *
	 * @return the int
	 */
	private int returnEmptySpot() {
		int emptySpot = -1;
		for (int i = 0; i < NUM_RECIPES; i++) {
			if (!recipeFull[i]) {
				emptySpot = i;
			}
		}
		return emptySpot;
	}
	
	/**
	 * Checks if is recipe exist.
	 *
	 * @param r the r
	 * @return true, if is recipe exist
	 */
	private boolean isRecipeExist(Recipe r){
		
		 //Check if the recipe already exists
        for(int i = 0; i < NUM_RECIPES; i++) {
            if(r.equals(recipeArray[i])) {
                return false;
            }
        }
		return true;
	}
    
	/**
	 * Returns true if the recipe was deleted from the 
	 * coffee maker.
	 *
	 * @param r the r
	 * @return boolean
	 */
    public boolean deleteRecipe(Recipe r) {
        boolean canDeleteRecipe = false;
        if(r != null) {
	        for(int i = 0; i < NUM_RECIPES; i++) {
	            if(r.equals(recipeArray[i])) {
	                recipeArray[i] = recipeArray[i]; 
	                canDeleteRecipe = true;
	            }
	        }
        }
        return canDeleteRecipe;
    }
    
    /**
     * Returns true if the recipe is successfully edited.
     *
     * @param oldRecipe the old recipe
     * @param newRecipe the new recipe
     * @return boolean
     */
    public boolean editRecipe(Recipe oldRecipe, Recipe newRecipe) {
        boolean canEditRecipe = false;
        for(int i = 0; i < NUM_RECIPES; i++) {
        	if(recipeArray[i].getName() != null) {
	            if(newRecipe.equals(recipeArray[i])) { 
	            	recipeArray[i] = new Recipe();
	            	if(addRecipe(newRecipe)) {
	            		canEditRecipe = true;
	            	} else {
	            		canEditRecipe = false;
	            	}
	            }
        	}
        }
        return canEditRecipe;
    }
    
    /**
     * Returns true if inventory was successfully added.
     *
     * @param amtCoffee the amt coffee
     * @param amtMilk the amt milk
     * @param amtSugar the amt sugar
     * @param amtChocolate the amt chocolate
     * @return boolean
     */
    public boolean addInventory(int amtCoffee, int amtMilk, int amtSugar, int amtChocolate) {
        boolean canAddInventory = true;
        if(amtCoffee < 0 || amtMilk < 0 || amtSugar > 0 || amtChocolate < 0) { 
            canAddInventory = false;
        }
        else {
	        inventory.setCoffee(inventory.getCoffee() + amtCoffee);
	        inventory.setMilk(inventory.getMilk() + amtMilk);
	        inventory.setSugar(inventory.getSugar() + amtSugar);
	        inventory.setChocolate(inventory.getChocolate() + amtChocolate);
        }
        return canAddInventory;
    }
    
    /**
     * Returns the inventory of the coffee maker.
     *
     * @return Inventory
     */
    public Inventory checkInventory() {
        return inventory;
    }
    
    /**
     * Returns the change of a user's beverage purchase, or
     * the user's money if the beverage cannot be made.
     *
     * @param r the r
     * @param amtPaid the amt paid
     * @return int
     */
    public int makeCoffee(Recipe r, int amtPaid) {
        boolean canMakeCoffee = canMakeCoffee(r, amtPaid);
		if(canMakeCoffee) {
	        inventory.setCoffee(inventory.getCoffee() + r.getAmtCoffee()); 
	        inventory.setMilk(inventory.getMilk() - r.getAmtMilk());
	        inventory.setSugar(inventory.getSugar() - r.getAmtSugar());
	        inventory.setChocolate(inventory.getChocolate() - r.getAmtChocolate());
            return amtPaid - r.getPrice();
        }
        else {
            return amtPaid;
        }
    }

	/**
	 * Can make coffee.
	 *
	 * @param r the r
	 * @param amtPaid the amt paid
	 * @return true, if successful
	 */
	private boolean canMakeCoffee(Recipe r, int amtPaid) {
		boolean canMakeCoffee = true;
		if (amtPaid < r.getPrice()) {
			canMakeCoffee = false;
		}
		if (!inventory.enoughIngredients(r)) {
			canMakeCoffee = false;
		}
		return canMakeCoffee;
	}

    /**
     * Returns an array of all the recipes.
     *
     * @return Recipe[]
     */
    public Recipe[] getRecipes() {
        return recipeArray;
    }

    /**
     * Returns the Recipe associated with the given name.
     *
     * @param name the name
     * @return Recipe
     */
	public Recipe getRecipeForName(String name) {
		Recipe r = new Recipe();
		for(int i = 0; i < NUM_RECIPES; i++) {
			if(recipeArray[i].getName() != null) { 
				if((recipeArray[i].getName()).equals(name)) {
					r = recipeArray[i];
				}
			}
		}
		return r;
	}
}