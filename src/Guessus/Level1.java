package Guessus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.xml.crypto.Data;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

/**
 * This class constructs a frame for the easy level
 * <p>
 * The class runs an easy level frame
 *
 * @author  Lior Chausovski
 * @author  Nissim Ben-Mergi 
 * 
 */



public class Level1 extends JFrame {
	/**
	 * player score
	 */
	private int score=100;
	private JPanel contentPane;
	/**
	 * score text
	 */
	private JTextField text_score;
	/**
	 * the text displaying the level
	 */
	private JTextField text_level;
	/**
	 * new quiz instance
	 */
	Quiz mivhan=new Quiz();
	/**
	 * new question set
	 */
	Set<Question> set;
	/**
	 * variable to contain a single question
	 */
	Question question;
	/**
	 * answer text box
	 */
	private JTextField text_answer;
	/**
	 * current level
	 */
	int level=1;
	/**
	 * mute button
	 */
	private JButton btn_mute;
	/**
	 * clue text
	 */
	private JLabel label_clue;
	/**
	 * button to go back to main menu
	 */
	private JButton btn_main;
	/**
	 * -40pts icon
	 */
	private JLabel label_minus40;
	/**
	 * Create the frame.
	 */
	public Level1() {
		setSize(new Dimension(1100, 700));
		setBounds(new Rectangle(50, 50, 1100, 700));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Level1 window=this;
		//setBounds(100, 100, 1010, 543);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 1100, 700));
		contentPane.setSize(new Dimension(1100, 700));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton bte_check = new JButton("");
		bte_check.setContentAreaFilled(false);
		
		bte_check.setBorder(new LineBorder(Color.ORANGE));
		bte_check.setIcon(new ImageIcon(Level1.class.getResource("/Guessus/Pics/check2.png")));
		bte_check.setBounds(438, 532, 78, 41);
		contentPane.add(bte_check);
		
		text_score = new JTextField();
		text_score.setBorder(null);
		text_score.setHorizontalAlignment(SwingConstants.CENTER);
		text_score.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
		text_score.setText("100");
		text_score.setOpaque(false);
	    text_score.setBackground(new Color(0,0,0,0));
		text_score.setEditable(false);
		text_score.setBackground(UIManager.getColor("textHighlight"));
		text_score.setBounds(217, 28, 113, 53);
		contentPane.add(text_score);
		text_score.setColumns(10);
		
		JButton btn_clue = new JButton("");
		btn_clue.setContentAreaFilled(false);
		
		
		text_level = new JTextField();
		text_level.setBorder(null);
		text_level.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
		text_level.setHorizontalAlignment(SwingConstants.CENTER);
		text_level.setText("1");
		text_level.setOpaque(false);
		text_level.setBackground(new Color(0,0,0,0));
		text_level.setEditable(false);
		text_level.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		text_level.setBounds(140, 90, 50, 41);
		contentPane.add(text_level);
		text_level.setColumns(10);
		btn_clue.setIcon(new ImageIcon(Level1.class.getResource("/Guessus/Pics/clue2.png")));
		btn_clue.setBounds(438, 586, 78, 38);
		contentPane.add(btn_clue);
		
		text_answer = new JTextField();
		text_answer.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 23));
		text_answer.setBackground(new Color(255, 153, 51));
		text_answer.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		text_answer.setBounds(518, 532, 187, 38);
		contentPane.add(text_answer);
		text_answer.setColumns(10);
		
		label_clue = new JLabel("");
		label_clue.setForeground(new Color(255, 255, 255));
		label_clue.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 30));
		label_clue.setBounds(518, 586, 187, 38);
		contentPane.add(label_clue);
		
		btn_main = new JButton("");
		btn_main.setContentAreaFilled(false);
		btn_main.setIcon(new ImageIcon(Level1.class.getResource("/Guessus/Pics/backtomenu.png")));
		btn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				window.setVisible(false);
				Start.main_window.setVisible(true);
			}
		});
		btn_main.setBounds(1004, 13, 78, 38);
		contentPane.add(btn_main);
		
		label_minus40 = new JLabel("");
		label_minus40.setIcon(new ImageIcon(Level1.class.getResource("/Guessus/Pics/minus40.png")));
		label_minus40.setBounds(324, 13, 70, 81);
		contentPane.add(label_minus40);
		label_minus40.setVisible(false);

		
		JLabel label_minus10 = new JLabel("");
		label_minus10.setIcon(new ImageIcon(Level1.class.getResource("/Guessus/Pics/minu10.png")));
		label_minus10.setBounds(324, 13, 70, 81);
		contentPane.add(label_minus10);
		label_minus10.setVisible(false);
		
		JLabel label = new JLabel("");
		label.setBounds(new Rectangle(0, 0, 1100, 700));
		
		try {
			set=mivhan.getEasy();
			int size = set.size();
			int item = new Random().nextInt(size);
			int i = 0;
			
			for(Object obj : set)
			{
			    if (i == item)
			    	question=(Question) obj;
			    i++;
			}
		
			label.setIcon(new ImageIcon(Level1.class.getResource(question.getPic())));
			set.remove(question);
		}
		catch (Exception e) {
		    System.err.println("Caught IOException: " + e.getMessage());
		}

		label.setSize(new Dimension(1100, 700));
		label.setBounds(0, 0, 1100, 698);
		contentPane.add(label);
		
		bte_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_minus40.setVisible(false);
				if(text_answer.getText().toString().toLowerCase().equals(question.getAnswer()))
				{
					label_minus10.setVisible(false);
					int size = set.size();
					if(size==0)
					{
						DB_Users data=new DB_Users();
						if(score>data.getScore(Start.player))
						{
							data.scoreUpdate(Start.player, score);
							 int dialogButton = JOptionPane.CLOSED_OPTION;
						     int dialogResult = JOptionPane.showConfirmDialog (null, "NEW BEST SCORE!","Warning",dialogButton);
						}
						else if(score<data.getScore(Start.player)){
							int dialogButton = JOptionPane.CLOSED_OPTION;
						     int dialogResult = JOptionPane.showConfirmDialog (null, "You Did This Better Before","Warning",dialogButton);
							
						}
						
						window.setVisible(false);
						ScoreTable scoreScreen=new ScoreTable();
						scoreScreen.setVisible(true);
						return ;
						
					}
					int item = new Random().nextInt(size);
					int i = 0;
					
					for(Object obj : set)
					{
					    if (i == item)
					    	question=(Question) obj;
					    i++;
					}
				
					label.setIcon(new ImageIcon(Level1.class.getResource(question.getPic())));
					set.remove(question);
					text_answer.setText("");
					text_answer.setBackground(Color.WHITE);
					label_clue.setText("");
					level++;
					text_level.setText(""+level);
				}
				else
				{
					text_answer.setBackground(Color.RED);
					label_minus10.setVisible(true);
					score=score-10;
					if(score<=0)
					{
						int dialogButton = JOptionPane.CLOSED_OPTION;
					     int dialogResult = JOptionPane.showConfirmDialog (null, "You Lose!","Warning",dialogButton);
					     window.setVisible(false);
							ScoreTable scoreScreen=new ScoreTable();
							scoreScreen.setVisible(true);
							return ;
					}
					text_score.setText(""+score);
				}
				
			}
		});
		
		btn_clue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_minus10.setVisible(false);
				label_minus40.setVisible(true);
				label_clue.setText(question.getClue());
			score=score-40;
			if(score<=0)
			{
				int dialogButton = JOptionPane.CLOSED_OPTION;
			     int dialogResult = JOptionPane.showConfirmDialog (null, "You Lose!","Warning",dialogButton);
			     window.setVisible(false);
					ScoreTable scoreScreen=new ScoreTable();
					scoreScreen.setVisible(true);
					return ;
			}
			text_score.setText(""+score);
			}
		});
	}
}
