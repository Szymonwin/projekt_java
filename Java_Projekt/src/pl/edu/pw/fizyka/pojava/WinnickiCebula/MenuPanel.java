package pl.edu.pw.fizyka.pojava.WinnickiCebula;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//ekran startowy gry
public class MenuPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected JButton start, exit, next;
	private BoxLayout boxLayout;
	private JPanel centerPanel, buttonPanel; 
	private JLabel label;
	
	protected MenuPanel() {
		super();
		//inicjalizacja kolejnych paneli, zeby bylo ustawione estetycznie
		centerPanel = new JPanel(new BorderLayout()); 
		centerPanel.setBackground(Color.YELLOW);
		buttonPanel = new JPanel(new GridLayout(2,1,0,10));
		buttonPanel.setBackground(Color.MAGENTA);
		
		start = new JButton("START");
		start.setActionCommand("start");
		exit = new JButton("EXIT");
		exit.setActionCommand("exit");
		
		buttonPanel.add(start); 
		buttonPanel.add(exit);
		
		label = new JLabel("Gra o kotach");
		label.setFont(new Font("Serif", Font.BOLD, 20));
		
		centerPanel.add(label, BorderLayout.PAGE_START);
		centerPanel.add(buttonPanel, BorderLayout.CENTER);
		
		//koenieczne do zachowania estetyki
		boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout); //zeby wypelnic maksymanlnie gora - dol
		this.setBorder(new EmptyBorder(new Insets(100, 100, 100, 100)));
		this.add(centerPanel);
		
		this.setBackground(Color.PINK);
	}

}
