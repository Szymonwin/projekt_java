package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JButton;
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
	
	protected JButton catButton2, catButton3, catButton4;
	protected IconButton catButton1;
	protected IconButton backToMenuButton;
	private JPanel upperPanel, centerPanel;
	
	protected MainPanel(){
		super();
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		this.setBackground(backgroundColor);
		
		//panel górny z przyciskiem powrotu do ekranu startowego 
		upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		upperPanel.setBackground(backgroundColor);
		
		backToMenuButton = new IconButton("guzik.png", 50, 50, "menu");
		upperPanel.add(backToMenuButton);
		
		this.add(upperPanel, BorderLayout.BEFORE_FIRST_LINE);
		
		//panel środkowy z kotami
		centerPanel = new JPanel();
		centerPanel.setBackground(backgroundColor);
		
		//guziki-koty
		catButton1 = new IconButton("stefan.png", 150, 200, "cat1");
		
		
		catButton2 = new JButton("cat2");
		catButton2.setActionCommand("cat2");
		catButton3 = new JButton("cat3");
		catButton3.setActionCommand("cat3");
		catButton4 = new JButton("cat4");
		catButton4.setActionCommand("cat4");
		
		centerPanel.add(catButton1);
		centerPanel.add(catButton2);
		centerPanel.add(catButton3);
		centerPanel.add(catButton4);
		
		this.add(centerPanel, BorderLayout.CENTER);
	}
	
}