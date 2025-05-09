package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * aplikacja gry
 * 
 * @author Marianka
 * @author Szymon
 */
public class CatGame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final String[] catNames = {"stefan", "mordka", "syczek", "hela"};
	//private static final String[] foodNames = {"Food1", "Food2", "Food3", "Food4", "Food5", "Food6"};
	
	private JPanel cards;
	private MainPanel mainPanel;
	private MenuPanel menuPanel;
	private Cat cat1, cat2, cat3, cat4;
	//private Food food1, food2, food3, food4, food5, food6;
	private CatPanel catPanel1, catPanel2, catPanel3, catPanel4;
	private String command;
	private CardLayout cardLayout;
	//private ArrayList<Food> listOfFood;
	
	public CatGame(String title) {
		super(title);
		
		cardLayout = new CardLayout();
		cards = new JPanel(cardLayout);
		this.add(cards);
		
		/*food1 = new Food(foodNames[0], 5);
		food2 = new Food(foodNames[1], 5);
		food3 = new Food(foodNames[2], 5);
		food4 = new Food(foodNames[3], 5);
		food5 = new Food(foodNames[4], 5);
		food6 = new Food(foodNames[5], 5);
		
		listOfFood = new ArrayList<Food>();
		listOfFood.add(food1);
		listOfFood.add(food2);
		listOfFood.add(food3);
		listOfFood.add(food4);
		listOfFood.add(food5);
		listOfFood.add(food6);*/
		
		/*cat1 = new Cat(catNames[0]);
		cat2 = new Cat(catNames[1]);
		cat3 = new Cat(catNames[2]);
		cat4 = new Cat(catNames[3]);*/
		
		//ogarnięcie CardLayoutu
		menuPanel = new MenuPanel();
		cards.add(menuPanel, "menu");
		mainPanel = new MainPanel();
		cards.add(mainPanel, "main");
		catPanel1 = new CatPanel("Stefan");
		cards.add(catPanel1, "cp1");
		catPanel2 = new CatPanel("Mordka");
		cards.add(catPanel2, "cp2");
		catPanel3 = new CatPanel("Syczek");
		cards.add(catPanel3, "cp3");
		catPanel4 = new CatPanel("Hela");
		cards.add(catPanel4, "cp4");
		
		//actionListener do wszystkich guzikow
		menuPanel.start.addActionListener(this);
		menuPanel.exit.addActionListener(this);
		mainPanel.backToMenuButton.addActionListener(this);
		mainPanel.catButton1.addActionListener(this);
		mainPanel.catButton2.addActionListener(this);
		mainPanel.catButton3.addActionListener(this);
		mainPanel.catButton4.addActionListener(this);
		catPanel1.backToMainButton.addActionListener(this);
		catPanel2.backToMainButton.addActionListener(this);
		catPanel3.backToMainButton.addActionListener(this);
		catPanel4.backToMainButton.addActionListener(this);
		
		cardLayout.show(cards, "menu");
	}
	
	//funckja onslugujaca wszystkie guziki w programie
	@Override
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();
		
		switch(command) {
		case "start":
			cardLayout.show(cards, "main");
			break;
		case "exit":
			System.exit(0);
			break;
		case "menu":
			cardLayout.show(cards, "menu");
			break;
		case "cat1":
			cardLayout.show(cards, "cp1");
			break;
		case "cat2":
			cardLayout.show(cards, "cp2");
			break;
		case "cat3":
			cardLayout.show(cards, "cp3");
			break;
		case "cat4":
			cardLayout.show(cards, "cp4");
			break;
		case "backToMain":
			cardLayout.show(cards, "main");
			break;
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(
				new Runnable(){
					public void run() {
						try {
							//System.out.println(UIManager.getSystemLookAndFeelClassName());
							UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
						}
						catch (Exception e) {
							System.out.print(isDefaultLookAndFeelDecorated());
							e.printStackTrace();
						}
						CatGame frame = new CatGame("kitties");
						frame.setSize(800,700);
						frame.setVisible(true);
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}
				}
		);
	}
}