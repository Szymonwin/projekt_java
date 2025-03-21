package pojava.GraOKotach.koty;

import java.awt.CardLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraOKotach extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel cards;
	MainPanel mainP;
	MenuPanel menu;
	CatPanel catP;
	String command;
	CardLayout cardLayout;
	
	public GraOKotach(String title) {
		super(title);
		cardLayout = new CardLayout();
		cards = new JPanel(cardLayout);
		this.add(cards);
		
		menu = new MenuPanel();
		cards.add(menu, "1");
		
		mainP = new MainPanel();
		cards.add(mainP, "2");
		catP = new CatPanel();
		cards.add(catP, "3");
		
		menu.start.addActionListener(this);
		menu.exit.addActionListener(this);
		mainP.backToMenu.addActionListener(this);
		mainP.cat.addActionListener(this);
		catP.backToMain.addActionListener(this);
		
		cardLayout.show(cards, "1");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();
		
		switch(command) {
		case "start":
			cardLayout.show(cards, "2");
			break;
		case "exit":
			System.exit(0);
			break;
		case "menu":
			cardLayout.show(cards, "1");
			break;
		case "cat":
			cardLayout.show(cards, "3");
			break;
		case "backToMain":
			cardLayout.show(cards, "2");
			break;
		}

	}

	public static void main(String[] args) {
		GraOKotach okienko = new GraOKotach("kiciusie");
		okienko.setSize(500,500);
		okienko.setVisible(true);
		okienko.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}

