package edu.towson.cis.cosc603.project5.coffeemaker;

// TODO: Auto-generated Javadoc
/**
 * Recipe object for the coffee maker.
 *
 * @author Josh
 * @version $Revision: 1.0 $
 */
public class Recipe {
    
    /** The name. */
    private String name;
    
    /** The price. */
    private int price;
    
    /** The amt coffee. */
    private int amtCoffee;
    
    /** The amt milk. */
    private int amtMilk;
    
    /** The amt sugar. */
    private int amtSugar;
    
    /** The amt chocolate. */
    private int amtChocolate;
    
    /**
     * Method getAmtChocolate.
     * @return int
     */
    public int getAmtChocolate() {
        return amtChocolate;
    }
    /**
     * Method setAmtChocolate.
     * @param amtChocolate int
     */
    public void setAmtChocolate(int amtChocolate) {
    	
    	if(amtChocolate >= 0) {
    		this.amtChocolate = amtChocolate;
    	}
    	else
    		this.amtChocolate = this.getAmtChocolate();
    	
    }
    /**
     * Method getAmtCoffee.
     * @return int
     */
    public int getAmtCoffee() {
        return amtCoffee;
    }
    /**
     * Method setAmtCoffee.
     * @param amtCoffee int
     */
    public void setAmtCoffee(int amtCoffee) {
    	if(amtCoffee >= 0) {
    		this.amtCoffee = amtCoffee;
    	}
    	else {
    		this.amtCoffee = this.getAmtCoffee();
    	}
    }
    /**
     * Method getAmtMilk.
     * @return int
     */
    public int getAmtMilk() {
        return amtMilk;
    }
    /**
     * Method setAmtMilk.
     * @param amtMilk int
     */
    public void setAmtMilk(int amtMilk) {
    	if(amtMilk >= 0) {
    		this.amtMilk = amtMilk;
    	}
    	else {
    		this.amtMilk = this.getAmtMilk();
    	}
    }
    /**
     * Method getAmtSugar.
     * @return int
     */
    public int getAmtSugar() {
        return amtSugar;
    }
    /**
     * Method setAmtSugar.
     * @param amtSugar int
     */
    public void setAmtSugar(int amtSugar) {
    	if(amtSugar >= 0) {
    		this.amtSugar = amtSugar;
    	}
    	else {
    		this.amtSugar = this.getAmtSugar();
    	}
    }
    /**
     * Method getName.
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * Method setName.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method getPrice.
     * @return int
     */
    public int getPrice() {
        return price;
    }
    /**
     * Method setPrice.
     * @param price int
     */
    public void setPrice(int price) {
    	if(price >= 0) {
    		this.price = price;
    	}
    	else {
    		this.price = this.getPrice();
    		
    	}
    } 
    /**
     * Method equals.
     * @param r Recipe
     * @return boolean
     */
    public boolean equals(Recipe r) {
        if((r.getName() == null)|| (this.name == null)) {
	    	return false;
    	}	
        
        if((this.name).equals(r.getName())) {
            return true;
        }
        return false;
    }
    /**
     * Method toString.
     * @return String
     */
    public String toString() {
    	return name;
    }
}
