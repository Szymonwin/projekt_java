package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.util.ArrayList;
import java.util.Collections;

/**
 * klasa przechowująca informacje na temat kotów
 * 
 * @author Szymon
 */
public class Cat {
	
	protected static final int maxHappiness = 100, maxFood = 100;
	
	protected int levelOfHappiness, levelOfHunger;
	protected String name;
	protected ArrayList<Food> foodRanking;
	
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
		levelOfHappiness += 7 * (6 - foodRanking.indexOf(food));
		System.out.println(foodRanking.indexOf(food));
	}
	
	/**
	 * metoda ustawiająca =-losowy ranking jedzenia
	 * @return nic
	 * @param nic
	 * @author Szymon
	 */
	public void rankFood(ArrayList<Food> listOfFood) {
		this.foodRanking = listOfFood;
		Collections.shuffle(foodRanking);
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