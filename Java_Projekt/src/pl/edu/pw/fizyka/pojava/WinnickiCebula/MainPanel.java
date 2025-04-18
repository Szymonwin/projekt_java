package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
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
	
	protected JButton backToMenuButton, catButton1, catButton2, catButton3, catButton4;
	private JPanel upperPanel, centerPanel;
	private ImageIcon backIcon;
	
	protected MainPanel(){
		super();
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
		this.setBackground(backgroundColor);
		
		//panel górny z przyciskiem powrotu do ekranu startowego 
		upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		upperPanel.setBackground(backgroundColor);
		
		backIcon = new ImageIcon("back.png");
		backToMenuButton = new JButton(backIcon);
		backToMenuButton.setActionCommand("menu");
		
		upperPanel.add(backToMenuButton);
		this.add(upperPanel, BorderLayout.BEFORE_FIRST_LINE);
		
		//panel środkowy z kotami
		centerPanel = new JPanel();
		centerPanel.setBackground(backgroundColor);
		
		//guziki-koty
		catButton1 = new JButton("cat1");
		catButton1.setActionCommand("cat1");
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