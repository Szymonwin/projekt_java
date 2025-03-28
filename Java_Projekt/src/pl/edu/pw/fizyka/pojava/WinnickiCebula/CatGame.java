//Autor: Marianna
package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class CatGame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel cards;
	private MainPanel mainPanel;
	private MenuPanel menuPanel;
	private CatPanel catPanel1, catPanel2, catPanel3, catPanel4;
	private String command;
	private CardLayout cardLayout;
	
	public CatGame(String title) {
		super(title);
		cardLayout = new CardLayout();
		cards = new JPanel(cardLayout);
		this.add(cards);
		//tworzymy panele i dodajemy je do cards
		menuPanel = new MenuPanel();
		cards.add(menuPanel, "menu");
		mainPanel = new MainPanel();
		cards.add(mainPanel, "main");
		catPanel1 = new CatPanel("cat1");
		cards.add(catPanel1, "cp1");
		catPanel2 = new CatPanel("cat2");
		cards.add(catPanel2, "cp2");
		catPanel3 = new CatPanel("cat3");
		cards.add(catPanel3, "cp3");
		catPanel4 = new CatPanel("cat4");
		cards.add(catPanel4, "cp4");
		
		//dodajemy actionListener do wszystkich guzikow
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
							UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
						}
						catch (Exception e) {
							System.out.print(isDefaultLookAndFeelDecorated());
						}
						CatGame frame = new CatGame("kitties");
						frame.setSize(500,500);
						frame.setVisible(true);
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}
				}
		);
	}
}