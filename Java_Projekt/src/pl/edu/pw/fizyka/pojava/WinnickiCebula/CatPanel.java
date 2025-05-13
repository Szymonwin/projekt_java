package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

/**
 * Panel z widokiem kota
 * 
 * @author Szymon
 * @author Marianka
 */
public class CatPanel extends JPanel implements ActionListener/*, ComponentListener*/{
	
	private static final long serialVersionUID = 1L;
	private static final Color backgroundColor = new Color(255, 200, 251);
	private static final Color buttonColor = new Color(201, 253, 234);
	private static final String[] foodNames = {"Fish", "Chicken", "Carrot", "Milk", "Muffin", "Cake"};
	
	protected IconButton backToMainButton,foodButton1, foodButton2, foodButton3, foodButton4, foodButton5, foodButton6;
	protected JButton catNameButton;
	protected Cat cat;
	private JPanel upperPanel, barPanel, centerPanel, catImagePanel, foodPanel, foodListPanel, namePanel, backButtonPanel;
	private JLabel catpngLabel, happinessLabel,hungryLabel;
	private JMenuBar foodMenuBar;
	private Food food1, food2, food3, food4, food5, food6;
	private JMenu foodListMenu;
	private JMenuItem foodRanked1, foodRanked2, foodRanked3, foodRanked4, foodRanked5, foodRanked6;
	private JProgressBar happinessBar, hungerBar;
	private ArrayList<Food> listOfFood;
	private ImageIcon catIcon, happinessIcon, hungerIcon, miniIcon, miniCat;

	protected CatPanel(String catName, String catPNG){
		super();
		this.setBackground(backgroundColor);
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
		
		//this.addComponentListener(this);
		
		cat = new Cat(catName);
		
		food1 = new Food(foodNames[0],13);
		food2 = new Food(foodNames[1],13);
		food3 = new Food(foodNames[2],5);
		food4 = new Food(foodNames[3],5);
		food5 = new Food(foodNames[4],10);
		food6 = new Food(foodNames[5],20);
		
		listOfFood = new ArrayList<Food>();
		listOfFood.add(food1);
		listOfFood.add(food2);
		listOfFood.add(food3);
		listOfFood.add(food4);
		listOfFood.add(food5);
		listOfFood.add(food6);
		
		cat.rankFood(listOfFood);
		
		//panel górny z przyciskiem powrotu do MainPanel, imieniem kota oraz listą ulubionych potraw
		upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout());
		upperPanel.setBackground(backgroundColor);
		
		this.add(upperPanel, BorderLayout.BEFORE_FIRST_LINE);
		
		//przycisk powrotu
		backToMainButton = new IconButton("guzik.png", 50, 50, "backToMain");
		backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		backButtonPanel.setBackground(backgroundColor);
		backButtonPanel.add(backToMainButton);
		upperPanel.add(backButtonPanel);
		
		
		//imię kota
		catNameButton = new JButton(cat.name);
		catNameButton.setFont(new Font("Helvetica", Font.BOLD, 40));
		namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		namePanel.setBackground(backgroundColor);
		catNameButton.setToolTipText("click to change name");
		catNameButton.setBorder(null);
		catNameButton.setBackground(null);
		namePanel.add(catNameButton);
		upperPanel.add(namePanel);
		
		//lista ulubionych potraw kota
		foodMenuBar = new JMenuBar();
		foodListMenu = new JMenu("Favourite foods");
		foodMenuBar.setBackground(buttonColor);
		foodListMenu.setBackground(buttonColor);
		
		foodRanked1 = new JMenuItem("1 "+listOfFood.get(0).name);
		foodRanked2 = new JMenuItem("2 "+listOfFood.get(1).name);
		foodRanked3 = new JMenuItem("3 "+listOfFood.get(2).name);
		foodRanked4 = new JMenuItem("4 "+listOfFood.get(3).name);
		foodRanked5 = new JMenuItem("5 "+listOfFood.get(4).name);
		foodRanked6 = new JMenuItem("6 "+listOfFood.get(5).name);
		foodRanked1.setBackground(buttonColor);
		foodRanked2.setBackground(buttonColor);
		foodRanked3.setBackground(buttonColor);
		foodRanked4.setBackground(buttonColor);
		foodRanked5.setBackground(buttonColor);
		foodRanked6.setBackground(buttonColor);
		
		foodListPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		foodListPanel.setBackground(backgroundColor);
		
		foodListMenu.add(foodRanked1);
		foodListMenu.add(foodRanked2);
		foodListMenu.add(foodRanked3);
		foodListMenu.add(foodRanked4);
		foodListMenu.add(foodRanked5);
		foodListMenu.add(foodRanked6);
		foodMenuBar.add(foodListMenu);
		foodListPanel.add(foodMenuBar);
		upperPanel.add(foodListPanel);
		
		//panel środkowy z obrazkiem kota oraz jego statystykami
		centerPanel = new JPanel();
		this.add(centerPanel,BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout());
		
		//panel ze statystykami kota
		barPanel = new JPanel();
		barPanel.setBackground(backgroundColor);
		
		happinessBar = new JProgressBar(0,100);
		happinessBar.setValue(cat.levelOfHappiness);
		hungerBar = new JProgressBar(0,100);
		hungerBar.setValue(cat.levelOfHunger);
		barPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		happinessIcon = new ImageIcon("happiness.png");
		Image hapImg = happinessIcon.getImage();
		Image newHapImg = hapImg.getScaledInstance( (int)( happinessIcon.getIconWidth() * 0.04 ), (int)( happinessIcon.getIconHeight() * 0.04 ), Image.SCALE_SMOOTH);
		ImageIcon newHapIcon = new ImageIcon(newHapImg);
		
		hungerIcon = new ImageIcon("hunger.png");
		Image hunImg = hungerIcon.getImage();
		Image newHunImg = hunImg.getScaledInstance( (int)( hungerIcon.getIconWidth() * 0.06 ), (int)( hungerIcon.getIconHeight() * 0.06 ), Image.SCALE_SMOOTH);
		ImageIcon newHunIcon = new ImageIcon(newHunImg);
		
		happinessLabel = new JLabel(newHapIcon);
		hungryLabel = new JLabel(newHunIcon);
		
		barPanel.add(happinessLabel);
		barPanel.add(happinessBar);
		barPanel.add(hungryLabel);
		barPanel.add(hungerBar);
		centerPanel.add(barPanel, BorderLayout.PAGE_START);
		
		//panel z obrazkiem kota
		
		//jest to bardzo robocze rozwiazanie chwilowo
		catIcon = new ImageIcon(catPNG);
		Image img = catIcon.getImage();
		Image newImg = img.getScaledInstance( (int)( catIcon.getIconWidth() * 0.35 ), (int)( catIcon.getIconHeight() * 0.35 ), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		
		catImagePanel = new JPanel();
		catpngLabel = new JLabel(newIcon);
		catImagePanel.setBackground(backgroundColor);
		
		catImagePanel.add(catpngLabel);
		centerPanel.add(catImagePanel,BorderLayout.CENTER);
		
		//panel dolny z listą dostępnych potraw
		foodPanel = new JPanel();
		foodPanel.setBackground(backgroundColor);
		foodPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(foodPanel,BorderLayout.PAGE_END);
		
		foodButton1 = new IconButton("fish.png", 168, 100, foodNames[0]);
		foodButton1.setToolTipText(foodNames[0]);
		foodButton1.addActionListener(this);
		
		foodButton2 = new IconButton("chicken.png", 98, 100, foodNames[1]);
		foodButton2.setToolTipText(foodNames[1]);
		foodButton2.addActionListener(this);
		
		foodButton3 = new IconButton("carrot.png", 100, 100, foodNames[2]);
		foodButton3.setToolTipText(foodNames[2]);
		foodButton3.addActionListener(this);
		
		foodButton4 = new IconButton("milk.png", 153, 100, foodNames[3]);
		foodButton4.setToolTipText(foodNames[3]);
		foodButton4.addActionListener(this);
		
		foodButton5 = new IconButton("muffin.png", 97, 100, foodNames[4]);
		foodButton5.setToolTipText(foodNames[4]);
		foodButton5.addActionListener(this);

		foodButton6 = new IconButton("cake.png", 93, 100, foodNames[5]);
		foodButton6.setToolTipText(foodNames[5]);
		foodButton6.addActionListener(this);
		
		
		foodPanel.add(foodButton1);
		foodPanel.add(foodButton2);
		foodPanel.add(foodButton3);
		foodPanel.add(foodButton4);
		foodPanel.add(foodButton5);
		foodPanel.add(foodButton6); 
		
		miniIcon = new ImageIcon("minicat.png");
		Image miniImg = miniIcon.getImage();
		Image newMiniImg = miniImg.getScaledInstance( (int)( miniIcon.getIconWidth() * 0.07 ), (int)( miniIcon.getIconHeight() * 0.07 ), Image.SCALE_SMOOTH);
		miniCat = new ImageIcon(newMiniImg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		try {
			switch(command){
			case "Fish":
				cat.feed(food1);
				break;
			case "Chicken":
				cat.feed(food2);
				break;
			case "Carrot":
				cat.feed(food3);
				break;
			case "Milk":
				cat.feed(food4);
				break;
			case "Muffin":
				cat.feed(food5);
				break;
			case "Cake":
				cat.feed(food6);
				break;
			}
		} catch (HatedFoodException hfe) {
			JOptionPane.showMessageDialog(null, "Cat hates this food", "Informacja", JOptionPane.WARNING_MESSAGE,miniCat);
		} catch (TooMuchFoodException tmfx) {
			JOptionPane.showMessageDialog(null, "Cat is full", "Informacja", JOptionPane.WARNING_MESSAGE,miniCat);
		} catch (TooMuchHappinessException tmhe) {}

		hungerBar.setValue(cat.levelOfHunger);
		happinessBar.setValue(cat.levelOfHappiness);
		
		
	}
	
	
	
	//to chwilowo nie dziala xdd
	
	/*
	public ImageIcon setCatSize(ImageIcon catIcon) {
		
		int pWidth = super.getWidth();
		int pHeight = super.getHeight();
		
		double ratio = Math.min((catIcon.getIconWidth() / pWidth)*200000, (catIcon.getIconHeight() / pHeight)*200000);
		Image img = catIcon.getImage();
		Image newImg = img.getScaledInstance((int)(ratio*catIcon.getIconWidth()), (int)(ratio*catIcon.getIconHeight()), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		return newIcon;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		catpngLabel.setIcon(setCatSize(catIcon));
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	} */
	
}
