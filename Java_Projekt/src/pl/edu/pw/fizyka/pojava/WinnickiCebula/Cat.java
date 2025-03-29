//Autor: Szymon
package pl.edu.pw.fizyka.pojava.WinnickiCebula;

public class Cat {
	
	protected static final int maxHappiness = 100, maxFood = 100;
	protected int levelOfHappiness, levelOfHunger;
	protected String[] foodRanking;
	protected String name;
	
	public Cat(String name) {
		this.name = name;
	}
	
	public void feed(Food food) {
		
	}
	
	public void rankFood() {
		
	}
	
	public void rename(String newName) {
		this.name = newName;
	}

}