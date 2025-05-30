package pl.edu.pw.fizyka.pojava.WinnickiCebula;


import javax.swing.Timer;

public class Starvation {

	public Starvation(CatPanel catPanel) {
		 Timer timer = new Timer(1000, e -> {
			 catPanel.cat.levelOfHunger -= 1;
			 catPanel.cat.levelOfHappiness -= 1;
			 if (catPanel.cat.levelOfHunger < 0) {
				 catPanel.cat.levelOfHunger = 0;
				 catPanel.cat.levelOfHappiness = 0;
			 }
			 if (catPanel.cat.levelOfHappiness <0) {
				 catPanel.cat.levelOfHappiness = 0;
			 }
			 catPanel.hungerBar.setValue(catPanel.cat.levelOfHunger);
			 catPanel.happinessBar.setValue(catPanel.cat.levelOfHappiness);
	     });
		 timer.setRepeats(true);
	     timer.start();	
	}

}
