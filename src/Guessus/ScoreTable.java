package Guessus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
/**
 * This class constructs a frame the score screen
 * <p>
 * The class runs a score table Jframe
 *
 * @author  Lior Chausovski
 * @author  Nissim Ben-Mergi 
 * 
 */
public class ScoreTable extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("");
	/**
	 * holds this window instance
	 */
    ScoreTable window = this;
    private final JLabel label = new JLabel("");

	/**
	 * Create the frame.
	 */
	public ScoreTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		DB_Users data=new DB_Users();
		JTable table=data.getScoreList();
	    contentPane.setLayout(null);
	    JScrollPane sp=new JScrollPane(table);   
	    sp.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 25));
	    sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    sp.setViewportBorder(null);
	    sp.setLocation(13, 10);
	    sp.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 153, 51)));
	    sp.setSize(456,194);
	    contentPane.add(sp);
	    btnNewButton.setIcon(new ImageIcon(ScoreTable.class.getResource("/Guessus/Pics/close2.png")));
	    btnNewButton.setBounds(195, 250, 77, 39);
	    
	    	    btnNewButton.addActionListener(new ActionListener() {
	    	    	public void actionPerformed(ActionEvent arg0) {
	    	    		window.setVisible(false);
	    	    		Start.main_window.setVisible(true);
	    	    	}
	    	    });
	    	    contentPane.add(btnNewButton);
	    	    label.setBounds(-13, 0, 499, 388);
	    	    contentPane.add(label);
	    	    label.setIcon(new ImageIcon(ScoreTable.class.getResource("/Guessus/Pics/5680024-blue-background.jpg")));
	    this.setSize(492,349);    
	    this.setVisible(true);    
	}

}
