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
		recipe.setAmtChocolate(0);
		
	
	}

	/**
	 * Test to check negative unit value of chocolate
	 * Test set amt chocolate.
	 */
	@Test
	public void testSetAmtChocolate() {
		recipe.setAmtChocolate(-1);
		assertEquals(0,  recipe.getAmtChocolate());
		}

	/**
	 * Test to check negative unit value of sugar
	 * Test set amt sugar.
	 */
	@Test
	public void testSetAmtSugar() {
		recipe.setAmtSugar(-1);
		assertEquals(0,  recipe.getAmtSugar());
	}
	
	/**
	 * Test to check negative unit value of coffee
	 * Test set amt coffee.
	 */
	@Test
	public void testSetAmtCoffee() {
		recipe.setAmtCoffee(-1);
		assertEquals(0,  recipe.getAmtCoffee());
	}
	
	/**
	 * Test to check negative unit value of milk
	 * Test set amt milk.
	 */
	@Test
	public void testSetAmtMilk(){
		recipe.setAmtMilk(-1);
		assertEquals(0,  recipe.getAmtMilk());
		
	}

	/**
	 * Test to check negative price.
	 * Test set price.
	 */
	@Test
	public void testSetPrice() {
		recipe.setPrice(-1);
		assertEquals(0,  recipe.getPrice());
	}

}
