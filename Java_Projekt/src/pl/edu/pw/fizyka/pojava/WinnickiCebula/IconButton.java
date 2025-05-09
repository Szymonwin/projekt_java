package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconButton extends JButton {

	private static final long serialVersionUID = 1L;
	private String pngName, command;
	private int width, height;
	private float hToWRatio;
	private ImageIcon icon, newIcon;
	private Image img, newImg;
	
	public IconButton(String png, int w, int h, String com) {
		super();
		this.pngName = png;
		this.height = h;
		this.width = w;
		this.command = com;
		
		icon = new ImageIcon(pngName);
		img = icon.getImage();
		newImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		newIcon = new ImageIcon(newImg);
		
		this.setIcon(newIcon);
		this.setActionCommand(command);
		this.setBackground(null);
		this.setBorder(null);
		//lalala
	}
	
	/*
	public IconButton(String png, int h, String com) {
		super();
		this.pngName = png;
		this.height = h;
		this.command = com;
		
		icon = new ImageIcon(pngName);
		
		int he = icon.getIconHeight();
		int w = icon.getIconWidth();

		hToWRatio = he/ w;
		System.out.println(he + "\n" + w + "\n" + (he / w));
		
		this.width = (int)(height / hToWRatio);

		double p = height / hToWRatio;
		System.out.println(p + "\n" + width);
		
		img = icon.getImage();
		
		newImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		newIcon = new ImageIcon(newImg);
		
		this.setIcon(newIcon);
		this.setActionCommand(command);
		this.setBackground(null);
		this.setBorder(null);
	} */

}
