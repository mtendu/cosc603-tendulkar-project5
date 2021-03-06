package edu.towson.cis.cosc603.project5.coffeemaker;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class CoffeeMakerTest.
 */
public class CoffeeMakerTest extends TestCase {
	
	/** The cm. */
	private CoffeeMaker cm;
	
	/** The i. */
	private Inventory i;
	
	/** The r1. */
	private Recipe r1;
	
	/** The r2. */
	private Recipe r2;
	
	/** The r3. */
	private Recipe r3;
	
	/** The r4. */
	private Recipe r4;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(1);
		
		r2= new Recipe();
	}

	/**
	 * Test add recipe1.
	 */
	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}
	/** 
	 * Test to add already exist recipe
	 * Test add recipe2.
	 */
	public void testAddRecipe2() {
		assertTrue(cm.addRecipe(r1));
		assertFalse("Recipe already exist",cm.addRecipe(r1));
	}
	
	/**
	 * Test to add recipe with negative price.
	 * 
	 */
	public void testAddRecipe3(){
		r2.setPrice(-50);
		assertFalse(cm.addRecipe(r2));
		
	}
	
	
	/**
	 * Test to add more than 3 recipes.
	 * Test add recipe4.
	 */
	public void testAddRecipe4(){
		
		assertTrue(cm.addRecipe(r1));
			r2 = new Recipe();
		 	r2.setName("Latte");
			r2.setPrice(50);
			r2.setAmtCoffee(6);
			r2.setAmtMilk(1);
			r2.setAmtSugar(1);
			r2.setAmtChocolate(0);
			assertTrue(cm.addRecipe(r2));
			
			r3 = new Recipe();
			r3.setName("Ice Coffee");	
			r3.setPrice(50);
			r3.setAmtCoffee(6);
			r3.setAmtMilk(1);
			r3.setAmtSugar(1);
			r3.setAmtChocolate(0);
			assertTrue(cm.addRecipe(r3));
			
			r4 = new Recipe();
			r4.setName("Choco Coffee");
			r4.setPrice(50);
			r4.setAmtCoffee(6);
			r4.setAmtMilk(1);
			r4.setAmtSugar(1);
			r4.setAmtChocolate(0); 
			assertFalse("Only three recipes can be added", cm.addRecipe(r4));

		
	}
	


	/**
	 * Test delete recipe1.
	 */
	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		
		assertTrue(cm.deleteRecipe(r1));
		
	}
	
	/**
	 * Test to delete null recipe.
	 * Test delete recipe2.
	 */
	public void testDeleteRecipe2(){
			assertFalse("Cannot delete null recipe",cm.deleteRecipe(null));
	}
	
	/**This test case will handle following if-statement is negate mutated
	 *   if(r.getName().equals(recipeArray[i].getName())) 
	 * Test delete recipe3.
	 */
	public void testDeleteRecipe3(){
		cm.addRecipe(r1);
		r2 = new Recipe();
		r2.setName("Latte");
		assertFalse(cm.deleteRecipe(r2));
	}

	/**
	 * Test edit recipe1.
	 */
	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	/** Test to edit recipe with negative price
	 * Test edit recipe2.
	 */
	public void testEditRecipe2() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setPrice(-10);
		assertEquals(50, newRecipe.getPrice());
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	/**
	 * Test to edit null recipe
	 * Test edit recipe3.
	 */
	public void testEditRecipe3(){
		cm.addRecipe(r2);
		Recipe newRecipe = new Recipe();
		newRecipe = r2;
		r2.setName("Latte");
		assertFalse("Cannot edit null recipe", cm.editRecipe(r1, newRecipe));
	}
		
	
	/**
	 * Test add inventory1.
	 * Also handles mutation of addition to subtraction in
	 * inventory.setCoffee(inventory.getCoffee() + amtCoffee);
	 */
	public void testAddInventory1(){
		assertEquals(true,cm.addInventory(10,10,10,10));
		assertTrue(i.getChocolate()> 15);
		assertTrue(i.getCoffee()> 15);
		assertTrue(i.getMilk()> 15);
		assertTrue(i.getSugar()> 15);
		
	}
	
	/**
	 * Test to add inventory with negative unit value
	 * Test add inventory2.
	 */
	public void testAddInventory2(){
		assertEquals("Unit of ingredients should be positive",false, cm.addInventory(-1,2,3,4));
		
	}
	
	/**
	 * Test add inventory with zero values
	 */
	public void testAddInventory3(){
		assertEquals(true, cm.addInventory(0,0,0,0));
		
	}
	/**
	 * Test check inventory.
	 */
	public void testCheckInventory(){
		assertEquals(i, cm.checkInventory());
	}
	
	/**
	 * Test make coffee 
	 * This test case also handles 
	 * inventory.setCoffee(inventory.getCoffee() + amtCoffee);
	 * if addition is mutated to subtraction
	 */
	public void testMakeCoffee1(){
		cm.addRecipe(r1);
		int amtPaid = 52;
		assertTrue(amtPaid >= r1.getPrice());
		assertEquals(2, cm.makeCoffee(r1, 52));
		assertEquals(9, i.getCoffee());
		assertEquals(14, i.getMilk());
		assertEquals(14, i.getSugar());
		assertEquals(14, i.getChocolate());
		
		assertEquals(0, cm.makeCoffee(r1, 50));
		
	}
	
	/** Test to make coffee without enough money.
	 * Test make coffee2.
	 */
	public void testMakeCoffee2(){
		cm.addRecipe(r1);
		assertEquals("Not enough money to purchase", 48, cm.makeCoffee(r1, 48));
	}
	
	
}