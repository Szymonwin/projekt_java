package pl.edu.pw.fizyka.pojava.WinnickiCebula;

/**
 * klasa przechowująca informacje na temat kotów
 * 
 * @author Szymon
 */
public class Cat {
	
	protected static final int maxHappiness = 100, maxFood = 100;
	
	protected int levelOfHappiness, levelOfHunger;
	protected String[] foodRanking;
	protected String name;
	
	public Cat(String name) {
		this.name = name;
	}
	
	/**
	 * metoda karmiąca kota, 
	 * zmienia jego statystyki na podstawie podanego mu jedzenia
	 * @param food 
	 * @return nic
	 * @author Szymon
	 */
	public void feed(Food food) {
		levelOfHunger += food.foodPoints;
	}
	/**
	 * metoda ustawiająca losowy ranking jedzenia
	 * @return nic
	 * @param nic
	 * @author Szymon
	 */
	public void rankFood() {
		
	}
	/**
	 * metoda zmieniająca imię kota
	 * @param newName nowe imie
	 * @return nic
	 * @author Szymon
	 */
	public void rename(String newName) {
		this.name = newName;
	}

}