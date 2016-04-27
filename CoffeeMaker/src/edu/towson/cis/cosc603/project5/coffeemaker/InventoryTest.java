package edu.towson.cis.cosc603.project5.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class InventoryTest.
 */
public class InventoryTest {
	
	/** The recipe. */
	private Recipe recipe;
	
	/** The inventory. */
	private Inventory inventory;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setPrice(15);
		recipe.setAmtCoffee(2);
		recipe.setAmtMilk(2);
		recipe.setAmtSugar(1);
		recipe.setAmtChocolate(0);
		
		inventory = new Inventory();
		
	}
	
	/**
	 * Test to check negative unit value of coffee.
	 * Test set coffee.
	 */
	@Test
	public void testSetCoffee(){
		inventory.setCoffee(-4);
		assertEquals(0, inventory.getCoffee());
	}
	
	/**
	 * Test to check negative unit value of milk.
	 * Test set milk.
	 */
	@Test
	public void testSetMilk(){
		inventory.setMilk(-4);
		assertEquals(0, inventory.getMilk());
	}
	
	/**
	 * Test to check negative unit value of sugar.
	 * Test set sugar.
	 */
	@Test
	public void testSetSugar(){
		inventory.setSugar(-4);
		assertEquals(0, inventory.getSugar());
	}
	
	/**
	 * Test to check negative unit value of chocolate
	 * Test set chocolate.
	 */
	@Test
	public void testSetChocolate(){
		inventory.setChocolate(-4);
		assertEquals(0, inventory.getChocolate());
	}
	
	
		/**
		 * Test enough ingredients1.
		 */
		@Test
	public void testEnoughIngredients1() {
		assertTrue(inventory.enoughIngredients(recipe));
	}
		
	/**
	 * Test to check enough ingredients
	 * Test enough ingredients2.
	 */
	@Test
	public void testEnoughIngredients2(){
			recipe.setAmtCoffee(17);
			
			assertFalse(inventory.enoughIngredients(recipe));
		}
	
	/**
	 * Test enough ingredients3.
	 */
	@Test
	public void testEnoughIngredients3(){
			
			recipe.setAmtMilk(17);
			assertFalse(inventory.enoughIngredients(recipe));
	}
	
	/**
	 * Test enough ingredients4.
	 */
	@Test
	public void testEnoughIngredients4(){
			
			recipe.setAmtSugar(17);
			assertFalse(inventory.enoughIngredients(recipe));
	}
	
	/**
	 * Test enough ingredients5.
	 */
	@Test
	public void testEnoughIngredients5(){
			
			recipe.setAmtChocolate(17);
			assertFalse(inventory.enoughIngredients(recipe));
	}
	
	/**
	 * Test to string.
	 */
	@Test
	public void testToString() {
		String result = inventory.toString();
		assertEquals("Coffee: 15\r\nMilk: 15\r\nSugar: 15\r\nChocolate: 15\r\n", result);
	}

}
