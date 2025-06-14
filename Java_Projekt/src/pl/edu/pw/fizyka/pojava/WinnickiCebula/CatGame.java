package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 * aplikacja gry
 * 
 * @author Marianka
 * @author Szymon
 */
public class CatGame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final String[] catNames = {"hela", "mordka", "syczek", "stefan"}; 
	private static final String[] catPNGs = {"hela.png", "mordka.png", "syczek.png", "stefan.png"};
	
	private JPanel cards;
	private MainPanel mainPanel;
	private MenuPanel menuPanel;
	private CatPanel catPanel1, catPanel2, catPanel3, catPanel4;
	private String command;
	private CardLayout cardLayout;
	private ImageIcon miniCat, newIcon;
	
	public CatGame(String title) {
		super(title);
		
		cardLayout = new CardLayout();
		cards = new JPanel(cardLayout);
		this.add(cards);
		
		menuPanel = new MenuPanel();
		cards.add(menuPanel, "menu");
		mainPanel = new MainPanel();
		cards.add(mainPanel, "main");
		catPanel1 = new CatPanel(catNames[0], catPNGs[0]);
		catPanel1.catNameButton.setActionCommand("catName1");
		cards.add(catPanel1, "cp1");
		catPanel2 = new CatPanel(catNames[1], catPNGs[1]);
		catPanel2.catNameButton.setActionCommand("catName2");
		cards.add(catPanel2, "cp2");
		catPanel3 = new CatPanel(catNames[2], catPNGs[2]);
		catPanel3.catNameButton.setActionCommand("catName3");
		cards.add(catPanel3, "cp3");
		catPanel4 = new CatPanel(catNames[3], catPNGs[3]);
		catPanel4.catNameButton.setActionCommand("catName4");
		cards.add(catPanel4, "cp4");
		
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
		catPanel1.catNameButton.addActionListener(this);
		catPanel2.catNameButton.addActionListener(this);
		catPanel3.catNameButton.addActionListener(this);
		catPanel4.catNameButton.addActionListener(this);
		
		mainPanel.catButton1.setToolTipText(catNames[0]);
		mainPanel.catButton2.setToolTipText(catNames[1]);
		mainPanel.catButton3.setToolTipText(catNames[2]);
		mainPanel.catButton4.setToolTipText(catNames[3]);
		
		cardLayout.show(cards, "menu");
		
		newIcon = new ImageIcon("minicat.png");
		Image img = newIcon.getImage();
		Image newImg = img.getScaledInstance( (int)( newIcon.getIconWidth() * 0.07 ), (int)( newIcon.getIconHeight() * 0.07 ), Image.SCALE_SMOOTH);
		miniCat = new ImageIcon(newImg);
		
		UIManager.put("OptionPane.background",new ColorUIResource(255, 132, 239));
		UIManager.put("Panel.background",new ColorUIResource(255, 132, 239));
		 
		Starvation(catPanel1);
		Starvation(catPanel2);
		Starvation(catPanel3);
		Starvation(catPanel4);
	}
	
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
		case "catName1":
			String newName1 = (String) JOptionPane.showInputDialog(this,"Enter new name:",catPanel1.cat.name, JOptionPane.QUESTION_MESSAGE, miniCat, null, catPanel1.cat.name);
			if(newName1 == null) {
				return;
			}
			else if(newName1.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Cat's name can't be empty", "name is null", JOptionPane.WARNING_MESSAGE,miniCat);
			}else {
			catPanel1.cat.rename(newName1);
			catPanel1.catNameButton.setText(newName1);
			mainPanel.catButton1.setToolTipText(newName1);
			}
			break;
		case "catName2":
			String newName2 = (String) JOptionPane.showInputDialog(this,"Enter new name:", catPanel2.cat.name, JOptionPane.QUESTION_MESSAGE, miniCat, null, catPanel2.cat.name);
			if(newName2 == null) {
				return;
			}
			else if(newName2.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this,"Cat's name can't be empty", "name is null", JOptionPane.WARNING_MESSAGE,miniCat);
			}else {
			catPanel2.cat.rename(newName2);
			catPanel2.catNameButton.setText(newName2);
			mainPanel.catButton2.setToolTipText(newName2);
			}
			break;
		case "catName3":
			String newName3 = (String) JOptionPane.showInputDialog(this,"Enter new name:", catPanel3.cat.name, JOptionPane.QUESTION_MESSAGE, miniCat, null, catPanel3.cat.name);
			if(newName3 == null) {
				return;
			}
			else if(newName3.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Cat's name can't be empty", "name is null", JOptionPane.WARNING_MESSAGE,miniCat);
			}else {
			catPanel3.cat.rename(newName3);
			catPanel3.catNameButton.setText(newName3);
			mainPanel.catButton3.setToolTipText(newName3);
			}
			break;
		case "catName4":
			String newName4 = (String) JOptionPane.showInputDialog(this,"Enter new name:", catPanel4.cat.name, JOptionPane.QUESTION_MESSAGE, miniCat, null, catPanel4.cat.name);
			if(newName4 == null) {
				return;
			}
			else if(newName4.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Cat's name can't be empty", "name is null", JOptionPane.WARNING_MESSAGE,miniCat);
			}else {
			catPanel4.cat.rename(newName4);
			catPanel4.catNameButton.setText(newName4);
			mainPanel.catButton4.setToolTipText(newName4);
			}
			break;
		}

	}
	
	public void Starvation(CatPanel catPanel) {
		 Timer timer = new Timer(5000, e -> {
			 catPanel.cat.levelOfHunger -= 2;
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

	public static void main(String[] args) {
		EventQueue.invokeLater(
				new Runnable(){
					public void run() {
						try {
							//System.out.println(UIManager.getSystemLookAndFeelClassName());
							UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
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