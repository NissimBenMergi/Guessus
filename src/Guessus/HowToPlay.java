package Guessus;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * This class opens help window
 * 
 *
 * @author  Lior Chausovski
 * @author  Nissim Ben-Mergi 
 * 
 */
public class HowToPlay extends JFrame {

	private JPanel contentPane;
    HowToPlay window=this;

	/**
	 * Create the frame.
	 */
	public HowToPlay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(485, 557, 80, 26);
		btnNewButton.setIcon(new ImageIcon(Level1.class.getResource("/Guessus/Pics/backtomenu.png")));
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				window.setVisible(false);
				Start.main_window.setVisible(true);
			}
		});
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 600, 600);
		label.setIcon(new ImageIcon(HowToPlay.class.getResource("/Guessus/Pics/helppage.png")));
		contentPane.add(label);
		this.setAlwaysOnTop(true);
	}
}
