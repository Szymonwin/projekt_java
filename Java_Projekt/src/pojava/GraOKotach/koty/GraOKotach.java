package pojava.GraOKotach.koty;

import java.awt.CardLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GraOKotach extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel cards;
	private MainPanel mainPanel;
	private MenuPanel menuPanel;
	private CatPanel catPanel;
	private String command;
	private CardLayout cardLayout;
	
	public GraOKotach(String title) {
		super(title);
		cardLayout = new CardLayout();
		cards = new JPanel(cardLayout);
		this.add(cards);
		//tworzymy panele i dodajemy je do cards
		menuPanel = new MenuPanel();
		cards.add(menuPanel, "1");
		mainPanel = new MainPanel();
		cards.add(mainPanel, "2");
		catPanel = new CatPanel();
		cards.add(catPanel, "3");
		
		//dodajemy actionListener do wszystkich guzikow
		menuPanel.start.addActionListener(this);
		menuPanel.exit.addActionListener(this);
		mainPanel.backToMenuButton.addActionListener(this);
		mainPanel.catButton.addActionListener(this);
		catPanel.backToMainButton.addActionListener(this);
		
		cardLayout.show(cards, "1");
	}
	
	//funckja onslugujaca wszystkie guziki w programie
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
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            System.out.print(isDefaultLookAndFeelDecorated());
        }
		
		GraOKotach okienko = new GraOKotach("kiciusie");
		okienko.setSize(500,500);
		okienko.setVisible(true);
		okienko.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}

