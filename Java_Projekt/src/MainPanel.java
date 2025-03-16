package pojava.GraOKotach.koty;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//ekran glowny gry
public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public JButton back;
	JPanel panelGorny;
	
	MainPanel(){
		super();

		//panel w panelu zeby miec taki gorny do guziczkow
		panelGorny = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelGorny.setBackground(Color.pink);

		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(new Insets(15, 15, 15, 15))); //to sa takie jakby marginesy
		
		this.add(panelGorny, BorderLayout.BEFORE_FIRST_LINE);
		
		back = new JButton("BACK");
		back.setActionCommand("back");
		back.setBounds(15,15,60,15); //rozmiar i miejsce guzika (x,y,szer,wys)
		panelGorny.add(back);
		
		this.setBackground(Color.PINK);
	}
	
}
