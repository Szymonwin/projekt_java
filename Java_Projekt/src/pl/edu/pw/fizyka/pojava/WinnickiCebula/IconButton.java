package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * guzik z obrazkiem
 * @author Marianka
 */
public class IconButton extends JButton {

	private static final long serialVersionUID = 1L;
	private String pngName, command;
	private int width, height;
	private ImageIcon icon, newIcon;
	private Image img, newImg;
	
	public IconButton(String png, int w, int h, String com) {
		super();
		this.pngName = png;
		this.height = h;
		this.width = w;
		this.command = com;
		
		icon = new ImageIcon(pngName);
		
		if( width != icon.getIconWidth() || height != icon.getIconHeight()) {
			img = icon.getImage();
			newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			newIcon = new ImageIcon(newImg);
			this.setIcon(newIcon);
		} else {
			this.setIcon(icon);
		}
		
		this.setActionCommand(command);
		this.setBackground(null);
		this.setBorder(null);
	}
	
	
	public IconButton(String png, double ratio, String com) {
		super();
		this.pngName = png;
		this.command = com;
		
		icon = new ImageIcon(pngName);
		
		if( ratio != 1) {
			img = icon.getImage();
			newImg = img.getScaledInstance( (int)( icon.getIconWidth() * ratio ), (int)( icon.getIconHeight() * ratio ), Image.SCALE_SMOOTH);
			newIcon = new ImageIcon(newImg);
			this.setIcon(newIcon);
		} else {
			this.setIcon(icon);
		}
		
		this.setActionCommand(command);
		this.setBackground(null);
		this.setBorder(null);
	} 
	
	/*public IconButton(String png, int h, String com) {
		super();
		this.pngName = png;
		this.command = com;
		
		icon = new ImageIcon(pngName);
		
		double r = h / icon.getIconHeight();
		
		if( r != 1) {
			img = icon.getImage();
			newImg = img.getScaledInstance( (int)( icon.getIconWidth() * r ), (int)( icon.getIconHeight() * r ), Image.SCALE_SMOOTH);
			newIcon = new ImageIcon(newImg);
			this.setIcon(newIcon);
		} else {
			this.setIcon(icon);
		}
		
		this.setActionCommand(command);
		this.setBackground(null);
		this.setBorder(null); 
	} */

}
