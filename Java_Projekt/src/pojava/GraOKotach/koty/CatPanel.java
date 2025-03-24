package pojava.GraOKotach.koty;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//ggggggggggg
//ekran z pojedynczym kotem i jego statystykami
public class CatPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected JButton backToMainButton;
	private JPanel upperPanel;
	private JLabel catName;

	protected CatPanel(String cat){
		super();
		
		upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		upperPanel.setBackground(Color.MAGENTA);
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15)));
		
		this.add(upperPanel, BorderLayout.BEFORE_FIRST_LINE);
		
		backToMainButton = new JButton("BACK");
		backToMainButton.setActionCommand("backToMain");
		backToMainButton.setBounds(15,15,60,15);
		upperPanel.add(backToMainButton);
		
		catName = new JLabel(cat);
		upperPanel.add(catName);
		
		
		this.setBackground(Color.PINK);
		
	}
}
