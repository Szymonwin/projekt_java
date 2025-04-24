package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

/**
 * Panel z widokiem kota
 * 
 * @author Szymon
 * @author Marianka
 */
public class CatPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final Color backgroundColor = new Color(255, 200, 251);
	
	protected JButton backToMainButton, foodButton1, foodButton2, foodButton3, foodButton4, foodButton5, foodButton6;
	private JPanel upperPanel, barPanel, centerPanel, catImagePanel, foodPanel;
	private JLabel catNameLabel, CatpngLabel, happinessLabel,hungryLabel;
	private JMenuBar foodMenu;
	private JMenu foodList;
	private JMenuItem food1,food2,food3;
	private JProgressBar happiness, hunger;
	private ImageIcon backIcon;
	private int BoxMesure = 200;

	protected CatPanel(String cat){
		super();
		this.setBackground(backgroundColor);
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
		
		//panel górny z przyciskiem powrotu do MainPanel, imieniem kota oraz listą ulubionych potraw
		upperPanel = new JPanel();
		upperPanel.setLayout(new BoxLayout(upperPanel,BoxLayout.X_AXIS));
		upperPanel.setBackground(backgroundColor);
		
		this.add(upperPanel, BorderLayout.BEFORE_FIRST_LINE);
		
		//przycisk powrotu
		backIcon = new ImageIcon("back.png");
		backToMainButton = new JButton(backIcon);
		backToMainButton.setActionCommand("backToMain");
		upperPanel.add(backToMainButton);
		upperPanel.add(Box.createHorizontalStrut(BoxMesure));
		
		//imię kota
		catNameLabel = new JLabel(cat);
		upperPanel.add(catNameLabel);
		upperPanel.add(Box.createHorizontalStrut(BoxMesure));
		
		//lista ulubionych potraw kota
		foodMenu = new JMenuBar();
		foodList = new JMenu("lista potraw");
		food1 = new JMenuItem("1");
		food2 = new JMenuItem("2");
		food3 = new JMenuItem("3");
		
		foodList.add(food1);
		foodList.add(food2);
		foodList.add(food3);
		foodMenu.add(foodList);
		upperPanel.add(foodMenu);
		
		//panel środkowy z obrazkiem kota oraz jego statystykami
		centerPanel = new JPanel();
		this.add(centerPanel,BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout());
		
		//panel ze statystykami kota
		barPanel = new JPanel();
		barPanel.setBackground(backgroundColor);
		
		happiness = new JProgressBar(0,100);
		happiness.setValue(50);
		hunger = new JProgressBar(0,100);
		hunger.setValue(20);
		barPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		happinessLabel = new JLabel("Happiness");
		hungryLabel = new JLabel("Hungry");
		
		barPanel.add(happinessLabel);
		barPanel.add(happiness);
		barPanel.add(hungryLabel);
		barPanel.add(hunger);
		centerPanel.add(barPanel, BorderLayout.PAGE_START);
		
		//panel z obrazkiem kota
		catImagePanel = new JPanel();
		CatpngLabel = new JLabel("Cat.PNG");
		catImagePanel.setBackground(backgroundColor);
		
		catImagePanel.add(CatpngLabel);
		centerPanel.add(catImagePanel,BorderLayout.CENTER);
		
		//panel dolny z listą dostępnych potraw
		foodPanel = new JPanel();
		foodPanel.setBackground(backgroundColor);
		foodPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(foodPanel,BorderLayout.PAGE_END);
		
		foodButton1 = new JButton("Food1");
		foodButton1.setToolTipText("Food1");
		foodButton2 = new JButton("Food2");
		foodButton2.setToolTipText("Food2");
		foodButton3 = new JButton("Food3");
		foodButton3.setToolTipText("Food3");
		foodButton4 = new JButton("Food4");
		foodButton4.setToolTipText("Food4");
		foodButton5 = new JButton("Food5");
		foodButton5.setToolTipText("Food5");
		foodButton6 = new JButton("Food6");
		foodButton6.setToolTipText("Food6");
		
		foodPanel.add(foodButton1);
		foodPanel.add(foodButton2);
		foodPanel.add(foodButton3);
		foodPanel.add(foodButton4);
		foodPanel.add(foodButton5);
		foodPanel.add(foodButton6);
	}
}
