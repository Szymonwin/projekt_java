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
	String command;
	CardLayout cardLayout;
	int currentCard = 1;
	
	public GraOKotach(String title) {
		super(title);
		cardLayout = new CardLayout();
		cards = new JPanel(cardLayout);
		this.add(cards);
		
		menu = new MenuPanel();
		cards.add(menu, "1");
		
		mainP = new MainPanel();
		cards.add(mainP, "2");
		
		menu.start.addActionListener(this);
		menu.exit.addActionListener(this);
		mainP.back.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();
		
		switch(command) {
		case "start":
			currentCard = 2;
			cardLayout.show(cards, "" + currentCard);
			break;
		case "exit":
			System.exit(0);
			break;
		case "back":
			currentCard = 1;
			cardLayout.show(cards, "" + currentCard);
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

