package pl.edu.pw.fizyka.pojava.WinnickiCebula;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ClockPanel extends JPanel{
	private JLabel clockLabel;
	private SimpleDateFormat dataFormat;
	private String currentTimeAndDate;
	
	private static final long serialVersionUID = 1L;
	
	public ClockPanel() {
		clockLabel = new JLabel("", SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(clockLabel, BorderLayout.CENTER);

        Timer timer = new Timer(500, e -> {
            dataFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            currentTimeAndDate = dataFormat.format(new Date());
            clockLabel.setText(currentTimeAndDate);
        });
        timer.setRepeats(true);
        timer.start();	
	}
}