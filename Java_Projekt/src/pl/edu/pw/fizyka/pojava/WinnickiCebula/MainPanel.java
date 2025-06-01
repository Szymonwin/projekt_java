package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * panel główny gry
 * 
 * @author Marianka
 */
public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final Color backgroundColor = new Color(255, 200, 251);
	
	protected IconButton catButton1, catButton2, catButton3, catButton4;
	protected IconButton backToMenuButton;
	private JPanel upperPanel, centerPanel, bottomPanel;
	private ClockPanel clock;
	
	protected MainPanel(){
		super();
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		this.setBackground(backgroundColor);
		
		upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		upperPanel.setBackground(backgroundColor);
		
		backToMenuButton = new IconButton("guzik.png", 50, 50, "menu");
		upperPanel.add(backToMenuButton);
		
		this.add(upperPanel, BorderLayout.BEFORE_FIRST_LINE);
		
		centerPanel = new JPanel();
		centerPanel.setBackground(backgroundColor);
		
		catButton1 = new IconButton("hela.png", 0.3, "cat1");
		catButton2 = new IconButton("mordka.png", 0.25, "cat2");
		catButton3 = new IconButton("syczek.png", 0.25, "cat3");
		catButton4 = new IconButton("stefan.png", 0.25, "cat4");
		
		centerPanel.add(catButton1);
		centerPanel.add(catButton2);
		centerPanel.add(catButton3);
		centerPanel.add(catButton4);
		
		this.add(centerPanel, BorderLayout.CENTER);
		
		bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bottomPanel.setBackground(backgroundColor);
		clock = new ClockPanel();
		bottomPanel.add(clock);
		this.add(bottomPanel,BorderLayout.AFTER_LAST_LINE);
	}
	
}