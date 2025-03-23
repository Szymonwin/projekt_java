package pojava.GraOKotach.koty;

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
	
	protected JButton backToMenuButton, catButton;
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
		catButton = new JButton("cat");
		catButton.setActionCommand("cat");
		
		centerPanel.add(catButton);
		upperPanel.add(backToMenuButton);
		
		this.setBackground(Color.PINK);
	}
	
}