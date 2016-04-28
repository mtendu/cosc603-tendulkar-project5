package edu.towson.cis.cosc603.project5.coffeemaker;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class InventoryTest.
 */
public class InventoryTest extends TestCase{
	
	/** The recipe. */
	private Recipe recipe;
	
	/** The inventory. */
	private Inventory inventory;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	
	public void setUp() throws Exception {
		recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setPrice(15);
		recipe.setAmtCoffee(2);
		recipe.setAmtMilk(2);
		recipe.setAmtSugar(1);
		recipe.setAmtChocolate(1);
		
		inventory = new Inventory();
		
	}
	
	/**
	 * Test set coffee with positive value
	 */
	
	public void testSetCoffee1(){
		inventory.setCoffee(4);
		assertEquals(4, inventory.getCoffee());
	}
	
	/**
	 * Test to check for zero and negative unit value of coffee.
	 * If unit value of coffee is negative, coffee is restored to previous value.
	 * Test set coffee.
	 */
	
	public void testSetCoffee2(){
		inventory.setCoffee(0);
		assertEquals(0, inventory.getCoffee());
		inventory.setCoffee(-4);
		assertEquals(0, inventory.getCoffee());
	}
	 
	/**
	 * Test to set milk with positive value
	 */
	public void testSetMilk1(){
			inventory.setMilk(4);
			assertEquals(4, inventory.getMilk());
	}
	/**
	 * Test to check for zero and negative unit value of milk.
	 * If unit value of milk is negative, milk is restored to previous value.
	 */
	
	public void testSetMilk2(){
		inventory.setMilk(0);
		assertEquals(0, inventory.getMilk());
		inventory.setMilk(-4);
		assertEquals(0, inventory.getMilk());
	}
	 
	/**
	 * Test to  set sugar with positive value
	 */

	public void testSetSugar1(){
		inventory.setSugar(4);
		assertEquals(4, inventory.getSugar());
	}		
	/**
	 * Test to check for zero and negative unit value of sugar.
	 * If unit value of sugar is negative, sugar is restored to previous value.
	 */
	
	public void testSetSugar2(){
		inventory.setSugar(0);
		assertEquals(0, inventory.getSugar());
		
		inventory.setSugar(-4);
		assertEquals(0, inventory.getSugar());
	}
	
	/**
	 * Test to  set chocolate with positive value
	 */
	
	public void testSetChocolate1(){
		inventory.setChocolate(4);
		assertEquals(4,inventory.getChocolate());
	}
	
	/**
	 * Test to check for zero and negative unit value of chocolate
	 * If unit value of chocolate is negative, chocolate is restored to previous value.
	 */
	public void testSetChocolate2(){
		inventory.setChocolate(0);
		assertEquals(0, inventory.getChocolate());
		
		inventory.setChocolate(-4);
		assertEquals(0, inventory.getChocolate());
	}
	
	
		/**
		 * Test enough ingredients1.
		 */
		
	public void testEnoughIngredients1() {
		assertTrue(inventory.enoughIngredients(recipe));
	}
		
	/**
	 * Test to check not enough coffee for recipe
	 * Test enough ingredients2.
	 */
	
	public void testEnoughIngredients2(){
	
			recipe.setAmtCoffee(17);
			assertFalse(inventory.enoughIngredients(recipe));
		}
	
	/**
	 * Test to check not enough milk for recipe
	 */

	public void testEnoughIngredients3(){
			
			recipe.setAmtMilk(17);
			assertFalse(inventory.enoughIngredients(recipe));
	}
	
	/**
	 * Test to check not enough sugar for recipe.
	 */

	public void testEnoughIngredients4(){
			
			recipe.setAmtSugar(17);
			assertFalse(inventory.enoughIngredients(recipe));
	}
	
	/**
	 * Test to check not enough chocolate for recipe
	 */
	public void testEnoughIngredients5(){
			
			recipe.setAmtChocolate(17);
			assertFalse(inventory.enoughIngredients(recipe));
	}
	
	/**
	 * Test exactly enough ingredients
	 * If Inventory.coffee < r.getAmtCoffee() is mutated to 
	 * Inventory.coffee <= r.getAmtCoffee()),
	 * then this test case will handle the scenario.
	 */
	
	public void testEnoughIngredients6(){
		recipe.setAmtCoffee(15);
		recipe.setAmtMilk(15);
		recipe.setAmtSugar(15);
		recipe.setAmtChocolate(15);
		assertTrue(inventory.enoughIngredients(recipe));
		
	}
	/**
	 * Test to string.
	 */
	
	public void testToString() {
		String result = inventory.toString();
		assertEquals("Coffee: 15\r\nMilk: 15\r\nSugar: 15\r\nChocolate: 15\r\n", result);
	}

}
