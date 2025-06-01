package pl.edu.pw.fizyka.pojava.WinnickiCebula;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * ekran startowy gry
 * 
 * @author Marianka
 */
public class MenuPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private static final Color backgroundColor = new Color(255, 200, 251);
	private static final Color buttonColor = new Color(201, 253, 234);
	
	protected JButton start, exit, next;
	private BoxLayout boxLayout;
	private JPanel centerPanel, buttonPanel, titlePanel; 
	private JLabel label;
	private ImageIcon miniCat,newIcon;
	
	protected MenuPanel() {
		super();
		
		centerPanel = new JPanel(new BorderLayout()); 
		centerPanel.setBackground(backgroundColor);
		buttonPanel = new JPanel(new GridLayout(2,1,0,10));
		buttonPanel.setBackground(backgroundColor);
		titlePanel = new JPanel(new FlowLayout());
		titlePanel.setBackground(backgroundColor);
		
		start = new JButton("START");
		start.setBackground(buttonColor);
		start.setFont(new Font(null, Font.PLAIN, 50));
		start.setActionCommand("start");
		exit = new JButton("EXIT");
		exit.setBackground(buttonColor);
		exit.setFont(new Font(null, Font.PLAIN, 50));
		exit.setActionCommand("exit");
		
		buttonPanel.add(start); 
		buttonPanel.add(exit);
		
		label = new JLabel("Cat Game");
		label.setFont(new Font(null, Font.BOLD, 50));
		newIcon = new ImageIcon("minicat.png");
		Image img = newIcon.getImage();
		Image newImg = img.getScaledInstance( (int)( newIcon.getIconWidth() * 0.07 ), (int)( newIcon.getIconHeight() * 0.07 ), Image.SCALE_SMOOTH);
		miniCat = new ImageIcon(newImg);
		
		titlePanel.add(new JLabel(miniCat));
		titlePanel.add(label);
		
		centerPanel.add(titlePanel, BorderLayout.PAGE_START);
		centerPanel.add(buttonPanel, BorderLayout.CENTER);
		
		boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout); 
		this.setBorder(new EmptyBorder(new Insets(100, 100, 100, 100)));
		this.add(centerPanel);
		
		this.setBackground(backgroundColor);
	}

}
