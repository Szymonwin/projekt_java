//Autor: Marianna & Szymon
package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//ekran z pojedynczym kotem i jego statystykami
public class CatPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected JButton backToMainButton;
	private JPanel upperPanel, listOfFood;
	private JLabel catName;
	private JMenuBar food;
	private JMenu foodList;
	private JMenuItem food1,food2,food3;

	protected CatPanel(String cat){
		super();
		
		upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		upperPanel.setBackground(Color.MAGENTA);
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
		
		this.add(upperPanel, BorderLayout.BEFORE_FIRST_LINE);
		
		backToMainButton = new JButton("BACK");
		backToMainButton.setActionCommand("backToMain");
		backToMainButton.setBounds(15,15,60,15);
		upperPanel.add(backToMainButton);
		
		catName = new JLabel(cat);
		upperPanel.add(catName);
		
		listOfFood = new JPanel();
		listOfFood.setBackground(Color.YELLOW);
		this.add(listOfFood, BorderLayout.LINE_END);
		food = new JMenuBar();
		foodList = new JMenu("lista potraw");
		food1 = new JMenuItem("1");
		food2 = new JMenuItem("2");
		food3 = new JMenuItem("3");
		foodList.add(food1);
		foodList.add(food2);
		foodList.add(food3);
		food.add(foodList);
		listOfFood.add(food);
		
		this.setBackground(Color.PINK);
		
	}
}
