package pl.edu.pw.fizyka.pojava.WinnickiCebula;

/**
 * klasa przechowująca informacje na temat jedzenia
 * 
 * @author Szymon
 */
public class Food {
	
	protected String name;
	protected int foodPoints;
	
	public Food(String name, int foodPoints){
		this.name = name;
		this.foodPoints = foodPoints;
	}
}
