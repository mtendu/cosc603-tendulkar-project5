package edu.towson.cis.cosc603.project5.coffeemaker;

// TODO: Auto-generated Javadoc
/**
 * Inventory for the coffee maker.
 *
 * @author Josh
 * @version $Revision: 1.0 $
 */
public class Inventory {
    
    /** The coffee. */
    private  static int coffee = 15 ;
    
    /** The milk. */
    private static int milk = 15 ;
    
    /** The sugar. */
    private  static int sugar = 15 ;
    
    /** The chocolate. */
    private static int chocolate = 15;   
    
    /**
     * Instantiates a new inventory.
     */
    
    public Inventory() {
    	
        	setCoffee(15);
        	setMilk(15);
        	setSugar(15);
        	setChocolate(15);
        }
        
    
    
    /**
     * Method getChocolate.
     * @return int
     */
    public int getChocolate() {
        return chocolate;
    }
    /**
     * Method setChocolate.
     * @param chocolate int
     */
    public void setChocolate(int chocolate) {
    	
    	if(chocolate >= 0) {
    		Inventory.chocolate = chocolate;
    	}
    	else {
    		Inventory.chocolate = getChocolate();
    	}
        
    }
    /**
     * Method getCoffee.
     * @return int
     */
    public int getCoffee() {
        return coffee;
    }
    /**
     * Method setCoffee.
     * @param coffee int
     */
    public void setCoffee(int coffee) {
    	if(coffee >= 0) {
    		Inventory.coffee = coffee;
    	}
    	else{
    		Inventory.coffee = getCoffee();
    	}
    }
    /**
     * Method getMilk.
     * @return int
     */
    public int getMilk() {
        return milk;
    }
    /**
     * Method setMilk.
     * @param milk int
     */
    public void setMilk(int milk) {
    	if(milk >= 0) {
    		Inventory.milk = milk;
    	}
    	else {
    		Inventory.milk = getMilk();
    	}
    }
    /**
     * Method getSugar.
     * @return int
     */
    public int getSugar() {
        return sugar;
    }
    /**
     * Method setSugar.
     * @param sugar int
     */
    public void setSugar(int sugar) {
    	if(sugar >= 0) {
    		Inventory.sugar = sugar;
    	}
    	else {
    		Inventory.sugar = getSugar();
    	}
    }
    
    /**
     * Returns true if there are enough ingredients to make
     * the beverage.
     *
     * @param r the r
     * @return boolean
     */
    public boolean enoughIngredients(Recipe r) {
        
        if ((Inventory.coffee < r.getAmtCoffee())
        		|| (Inventory.milk < r.getAmtMilk())
        		|| (Inventory.sugar < r.getAmtSugar())
        		|| (Inventory.chocolate < r.getAmtChocolate())) {
            return false;        	
        }
        return true;
    }
    
    /**
     * Method toString.
     * @return String
     */
    public String toString() {
    	return "Coffee: " + this.getCoffee() + System.getProperty("line.separator") +
			"Milk: " + getMilk() +System.getProperty("line.separator")   +
			"Sugar: " + getSugar() + System.getProperty("line.separator")  +
			"Chocolate: " + getChocolate() + System.getProperty("line.separator") ;
    }
}
