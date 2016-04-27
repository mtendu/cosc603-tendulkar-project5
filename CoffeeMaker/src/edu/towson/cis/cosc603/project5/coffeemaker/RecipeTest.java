package edu.towson.cis.cosc603.project5.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class RecipeTest.
 */
public class RecipeTest {
	
	/** The recipe. */
	private Recipe recipe;
	

	
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
		recipe.setAmtChocolate(2);
		
	
	}
	
	/**
	 * Test set amt chocolate with positive value
	 */
	@Test 
	
	public void testSetAmtChocolate1() {
		
		recipe.setAmtChocolate(1);
		assertEquals(1,recipe.getAmtChocolate());
		
		}
	/**
	 * Test to check for zero and negative unit value of chocolate
	 * If value is negative, amtChocolate is set to old value;
	 * Test set amt chocolate.
	 */
	@Test
	public void testSetAmtChocolate2() {
		recipe.setAmtChocolate(0);
		assertEquals(0,recipe.getAmtChocolate());
		
		
		recipe.setAmtChocolate(-1);
		assertEquals(0,recipe.getAmtChocolate());
		
		}
	
	/**
	 * Test set amtSugar with positive value
	 */
	@Test
	public void testSetAmtSugar1(){
		recipe.setAmtSugar(4);
		assertEquals(4,recipe.getAmtSugar());
	}
	/**
	 * 
	 * Test to check for zero and  negative unit value of sugar
	 * If value is negative, amtSugar is set to old value;
	 * Test set amt sugar.
	 */
	@Test
	public void testSetAmtSugar2() {
		recipe.setAmtSugar(0);
		assertEquals(0, recipe.getAmtSugar());
		
		recipe.setAmtSugar(-1);
		assertEquals(0,  recipe.getAmtSugar());
	}
	
	/**
	 * Test set amtCoffee with positive value
	 */
	@Test
	public void testSetAmtCoffee(){
		recipe.setAmtCoffee(4);
		assertEquals(4, recipe.getAmtCoffee());
	}
	/**
	 * Test to check for zero and negative unit value of coffee
	 * If value is negative, amtCoffee is set to old value;
	 * Test set amt coffee.
	 */
	@Test
	public void testSetAmtCoffee2() {
		recipe.setAmtCoffee(0);
		assertEquals(0, recipe.getAmtCoffee());
		
		recipe.setAmtCoffee(-1);
		assertEquals(0, recipe.getAmtCoffee());
	}
	
	/**
	 * Test set amtMilk with positive value.
	 */
	@Test
	public void testSetAmtMilk1(){
		recipe.setAmtMilk(4);
		assertEquals(4,  recipe.getAmtMilk());
	}
	
	/**
	 * Test to check for zero and negative unit value of milk
	 * If value is negative, amtMilk is set to old value
	 * 
	 */
	@Test
	public void testSetAmtMilk2(){
		recipe.setAmtMilk(0);
		assertEquals(0, recipe.getAmtMilk());
		recipe.setAmtMilk(-1);
		assertEquals(0,  recipe.getAmtMilk());
		
	}
	
	/**
	 * Test set price with positive value
	 */
	@Test
	public void testSetPrice1(){
		recipe.setPrice(4);
		assertEquals(4, recipe.getPrice());
	}
	/**
	 * Test to check for zero and negative price.
	 * If price is negative, then price is set to old price.
	 * Test set price.
	 */
	@Test
	public void testSetPrice2() {
		recipe.setPrice(0);
		assertEquals(0,  recipe.getPrice());
		
		recipe.setPrice(-1);
		assertEquals(0,  recipe.getPrice());
	}

}
