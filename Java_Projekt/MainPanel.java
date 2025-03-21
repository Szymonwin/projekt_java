package pojava.GraOKotach.koty;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public JButton backToMenu, cat;
	JPanel panelGorny, panelSrodkowy;
	
	MainPanel(){
		super();
		
		panelGorny = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelGorny.setBackground(Color.pink);
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
		
		this.add(panelGorny, BorderLayout.BEFORE_FIRST_LINE);
		
		backToMenu = new JButton("BACK");
		backToMenu.setActionCommand("menu");
		backToMenu.setBounds(15,15,60,15);
		panelGorny.add(backToMenu);
		
		
		panelSrodkowy = new JPanel();
		panelSrodkowy.setBackground(Color.pink);
		this.add(panelSrodkowy, BorderLayout.CENTER);
		
		cat = new JButton("cat");
		cat.setActionCommand("cat");
		
		panelSrodkowy.add(cat);
		
		this.setBackground(Color.PINK);
	}
	
}