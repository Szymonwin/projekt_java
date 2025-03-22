package pojava.GraOKotach.koty;


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

public class MenuPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public JButton start, exit, next;
	BoxLayout boxLayout;
	JPanel centerPanel, buttonPanel; 
	JLabel label;
	
	public MenuPanel() {
		super();
		centerPanel = new JPanel(new BorderLayout());
		centerPanel.setBackground(Color.PINK);
		buttonPanel = new JPanel(new GridLayout(2,1,0,10));
		buttonPanel.setBackground(Color.PINK);
		
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
		
		boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout);
		this.setBorder(new EmptyBorder(new Insets(100, 100, 100, 100)));
		this.add(centerPanel);
		
		
		this.setBackground(Color.PINK);
	}

}
