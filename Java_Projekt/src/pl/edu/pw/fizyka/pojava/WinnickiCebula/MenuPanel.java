//Autor: Marianna
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

	private static final Color backgroundColor = new Color(255, 200, 251);
	protected JButton start, exit, next;
	private BoxLayout boxLayout;
	private JPanel centerPanel, buttonPanel; 
	private JLabel label;
	
	protected MenuPanel() {
		super();
		
		//panel srodkowy oraz panel z guzikami
		centerPanel = new JPanel(new BorderLayout()); 
		centerPanel.setBackground(backgroundColor);
		buttonPanel = new JPanel(new GridLayout(2,1,0,10));
		buttonPanel.setBackground(backgroundColor);
		
		start = new JButton("START");
		start.setActionCommand("start");
		exit = new JButton("EXIT");
		exit.setActionCommand("exit");
		
		buttonPanel.add(start); 
		buttonPanel.add(exit);
		
		label = new JLabel("Gra o kotach");
		label.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		centerPanel.add(label, BorderLayout.PAGE_START);
		centerPanel.add(buttonPanel, BorderLayout.CENTER);
		
		//walory estetyczne
		boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout); 
		this.setBorder(new EmptyBorder(new Insets(100, 100, 100, 100)));
		this.add(centerPanel);
		
		this.setBackground(backgroundColor);
	}

}
