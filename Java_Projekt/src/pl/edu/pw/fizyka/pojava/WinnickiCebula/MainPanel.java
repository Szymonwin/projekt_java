package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//ekran glowny, na ktorym bedzie mozna wybrac kota
public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected JButton backToMenuButton, catButton1, catButton2, catButton3, catButton4;
	private JPanel upperPanel, centerPanel;
	
	protected MainPanel(){
		super();
		//inicjalizacja kolejnych paneli, zeby bylo ustawione estetycznie
		upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		upperPanel.setBackground(Color.MAGENTA);
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.YELLOW);
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
		
		this.add(upperPanel, BorderLayout.BEFORE_FIRST_LINE);
		this.add(centerPanel, BorderLayout.CENTER);
		
		backToMenuButton = new JButton("BACK");
		backToMenuButton.setActionCommand("menu");
		catButton1 = new JButton("cat1");
		catButton1.setActionCommand("cat1");
		catButton2 = new JButton("cat2");
		catButton2.setActionCommand("cat2");
		catButton3 = new JButton("cat3");
		catButton3.setActionCommand("cat3");
		catButton4 = new JButton("cat4");
		catButton4.setActionCommand("cat4");
		
		upperPanel.add(backToMenuButton);
		centerPanel.add(catButton1);
		centerPanel.add(catButton2);
		centerPanel.add(catButton3);
		centerPanel.add(catButton4);
		
		this.setBackground(Color.PINK);
	}
	
}