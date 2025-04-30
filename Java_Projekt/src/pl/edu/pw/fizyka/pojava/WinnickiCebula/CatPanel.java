package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
public class CatPanel extends JPanel implements ActionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;
	private static final Color backgroundColor = new Color(255, 200, 251);
	private static final int BoxMeasure = 200;
	private static final String[] foodNames = {"Food1", "Food2", "Food3", "Food4", "Food5", "Food6"};
	
	protected JButton backToMainButton, foodButton1, foodButton2, foodButton3, foodButton4, foodButton5, foodButton6;
	private JPanel upperPanel, barPanel, centerPanel, catImagePanel, foodPanel;
	private JLabel catNameLabel, CatpngLabel, happinessLabel,hungryLabel;
	private JMenuBar foodMenuBar;
	private Food food1, food2, food3, food4, food5, food6;
	private JMenu foodListMenu;
	private JMenuItem foodRanked1,foodRanked2,foodRanked3;
	private JProgressBar happinessBar, hungerBar;
	private ImageIcon backIcon;
	private Cat cat;

	protected CatPanel(Cat cat){
		super();
		this.setBackground(backgroundColor);
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
		
		this.cat = cat;
		
		food1 = new Food(foodNames[0],20);
		food2 = new Food(foodNames[1],5);
		food3 = new Food(foodNames[2],5);
		food4 = new Food(foodNames[3],5);
		food5 = new Food(foodNames[4],5);
		food6 = new Food(foodNames[5],5);
		
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
		upperPanel.add(Box.createHorizontalStrut(BoxMeasure));
		
		//imię kota
		catNameLabel = new JLabel(cat.name);
		catNameLabel.setToolTipText("click to change name");
		catNameLabel.addMouseListener(this);
		upperPanel.add(catNameLabel);
		upperPanel.add(Box.createHorizontalStrut(BoxMeasure));
		
		//lista ulubionych potraw kota
		foodMenuBar = new JMenuBar();
		foodListMenu = new JMenu("lista potraw");
		foodRanked1 = new JMenuItem("1");
		foodRanked2 = new JMenuItem("2");
		foodRanked3 = new JMenuItem("3");
		
		foodListMenu.add(foodRanked1);
		foodListMenu.add(foodRanked2);
		foodListMenu.add(foodRanked3);
		foodMenuBar.add(foodListMenu);
		upperPanel.add(foodMenuBar);
		
		//panel środkowy z obrazkiem kota oraz jego statystykami
		centerPanel = new JPanel();
		this.add(centerPanel,BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout());
		
		//panel ze statystykami kota
		barPanel = new JPanel();
		barPanel.setBackground(backgroundColor);
		
		happinessBar = new JProgressBar(0,100);
		happinessBar.setValue(50);
		hungerBar = new JProgressBar(0,100);
		hungerBar.setValue(20);
		barPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		happinessLabel = new JLabel("Happiness");
		hungryLabel = new JLabel("Hungry");
		
		barPanel.add(happinessLabel);
		barPanel.add(happinessBar);
		barPanel.add(hungryLabel);
		barPanel.add(hungerBar);
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
		
		foodButton1 = new JButton(foodNames[0]);
		foodButton1.setToolTipText(foodNames[0]);
		foodButton1.setActionCommand(foodNames[0]);
		foodButton1.addActionListener(this);
		foodButton2 = new JButton(foodNames[1]);
		foodButton2.setToolTipText(foodNames[1]);
		foodButton2.setActionCommand(foodNames[1]);
		foodButton2.addActionListener(this);
		foodButton3 = new JButton(foodNames[2]);
		foodButton3.setToolTipText(foodNames[2]);
		foodButton3.setActionCommand(foodNames[2]);
		foodButton3.addActionListener(this);
		foodButton4 = new JButton(foodNames[3]);
		foodButton4.setToolTipText(foodNames[3]);
		foodButton4.setActionCommand(foodNames[3]);
		foodButton4.addActionListener(this);
		foodButton5 = new JButton(foodNames[4]);
		foodButton5.setToolTipText(foodNames[4]);
		foodButton5.setActionCommand(foodNames[4]);
		foodButton5.addActionListener(this);
		foodButton6 = new JButton(foodNames[5]);
		foodButton6.setToolTipText(foodNames[5]);
		foodButton6.setActionCommand(foodNames[5]);
		foodButton6.addActionListener(this);
		
		foodPanel.add(foodButton1);
		foodPanel.add(foodButton2);
		foodPanel.add(foodButton3);
		foodPanel.add(foodButton4);
		foodPanel.add(foodButton5);
		foodPanel.add(foodButton6);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch(command){
		case "Food1":
			cat.feed(food1);
			hungerBar.setValue(cat.levelOfHunger);
			break;
		case "Food2":
			cat.feed(food2);
			hungerBar.setValue(cat.levelOfHunger);
			break;
		case "Food3":
			cat.feed(food3);
			hungerBar.setValue(cat.levelOfHunger);
			break;
		case "Food4":
			cat.feed(food4);
			hungerBar.setValue(cat.levelOfHunger);
			break;
		case "Food5":
			cat.feed(food5);
			hungerBar.setValue(cat.levelOfHunger);
			break;
		case "Food6":
			cat.feed(food6);
			hungerBar.setValue(cat.levelOfHunger);
			break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String newName = JOptionPane.showInputDialog("Enter new name:");
		cat.rename(newName);
		catNameLabel.setText(newName);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
