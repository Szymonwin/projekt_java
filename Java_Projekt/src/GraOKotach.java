package pojava.GraOKotach.koty;

import java.awt.CardLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//glowna klasa - okno z funckja main i actionlistenerem
public class GraOKotach extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel cards;
	MainPanel mainP;
	MenuPanel menu;
	String command;
	CardLayout cardLayout;
	int currentCard = 1; //zmienna okreslajaca ktora karta jest otwarta
	
	public GraOKotach(String title) {
		super(title);
		cardLayout = new CardLayout(); //cardlayout - panele jedebn pod drugim i mozna zmieniac
		cards = new JPanel(cardLayout); //panel do przechowywania "kart"
		this.add(cards);
		
		menu = new MenuPanel();
		cards.add(menu, "1"); //panel menu dodaje do kart z indeksem 1
		
		mainP = new MainPanel();
		cards.add(mainP, "2");
		
		menu.start.addActionListener(this); //dodaje actionlisterery do guzikow w dwoch pozostalych klasach
		menu.exit.addActionListener(this);
		mainP.back.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();
		
		switch(command) { //switch jest wuygodniejsze od for w tym przypadku, bo bedzie duzo guzikow
		case "start":
			currentCard = 2;
			cardLayout.show(cards, "" + currentCard); //wyswietlamy karte z indeksem 1
			break;
		case "exit":
			System.exit(0);
			break;
		case "back":
			currentCard = 1;
			cardLayout.show(cards, "" + currentCard); //wyswietlamy karte z indeksem 2
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

