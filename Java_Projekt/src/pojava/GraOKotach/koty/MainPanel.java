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
	
	public JButton backToMenuButton, catButton;
	JPanel upperPanel, centerPanel;
	
	MainPanel(){
		super();
		
		upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		upperPanel.setBackground(Color.pink);
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
		
		this.add(upperPanel, BorderLayout.BEFORE_FIRST_LINE);
		
		backToMenuButton = new JButton("BACK");
		backToMenuButton.setActionCommand("menu");
		backToMenuButton.setBounds(15,15,60,15);
		upperPanel.add(backToMenuButton);
		
		
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.pink);
		this.add(centerPanel, BorderLayout.CENTER);
		
		catButton = new JButton("cat");
		catButton.setActionCommand("cat");
		
		centerPanel.add(catButton);
		
		this.setBackground(Color.PINK);
	}
	
}