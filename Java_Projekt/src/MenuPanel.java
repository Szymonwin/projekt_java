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
	JPanel panelSrodkowy, panelZGuzikami; 
	JLabel napis;
	
	public MenuPanel() {
		super();
		panelSrodkowy = new JPanel(new BorderLayout());
		panelSrodkowy.setBackground(Color.PINK);
		panelZGuzikami = new JPanel(new GridLayout(2,1,0,10));
		panelZGuzikami.setBackground(Color.PINK);
		
		start = new JButton("START");
		start.setActionCommand("start");
		exit = new JButton("EXIT");
		exit.setActionCommand("exit");
		
		panelZGuzikami.add(start);
		panelZGuzikami.add(exit);
		
		napis = new JLabel("Gra o kotach");
		napis.setFont(new Font("Serif", Font.BOLD, 20));
		
		panelSrodkowy.add(napis, BorderLayout.PAGE_START);
		panelSrodkowy.add(panelZGuzikami, BorderLayout.CENTER);
		
		boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout);
		this.setBorder(new EmptyBorder(new Insets(100, 100, 100, 100)));
		this.add(panelSrodkowy);
		
		
		this.setBackground(Color.PINK);
	}

}
