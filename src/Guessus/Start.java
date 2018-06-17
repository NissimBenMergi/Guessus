package Guessus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
/**
 * This starts the game
 * it holds the main menu frame
 *
 * @author  Lior Chausovski
 * @author  Nissim Ben-Mergi 
 * 
 */
public class Start extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	/**
	 * a user filed username field
	 */
	private JTextField text_user;
	/**
	 * a user filed password field
	 */
	private JTextField text_pass;
	/**
	 *to remember username
	 */
	public static String player;
	/**
	 *holds the main (start)  window instance
	 */
	static Start main_window;
	/**
	 * Launch the application.
	 */
	 
	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Start frame = new Start();
					frame.setVisible(true);
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
					frame.setBounds(0, 0, 1100, 700);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		Sound music=new Sound();
     	music.run();
		setResizable(false);
		
		
		
		setBounds(new Rectangle(0, 0, 1100, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 1920, 1105, 723);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(50, 50, 1100, 700));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		main_window=this;
		
		
	 
		JButton btn_close = new JButton("");
		btn_close.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/exit.jpg")));
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		btn_close.setBounds(989, 606, 80, 32);
		contentPane.add(btn_close);
		
		JButton btn_in = new JButton("");
	
		btn_in.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/login.jpg")));
		btn_in.setBounds(590, 448, 80, 32);
		contentPane.add(btn_in);
		
		JButton btn_up = new JButton("");
		btn_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     SignUp window=new SignUp();
			     window.setVisible(true);
			}
		});
		btn_up.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/singup.png")));
		btn_up.setBounds(22, 606, 80, 37);
		contentPane.add(btn_up);
		
		
		text_user = new JTextField();
		text_user.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 23));
		text_user.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		text_user.setBackground(new Color(255, 153, 51));
		text_user.setBounds(549, 348, 167, 37);
		contentPane.add(text_user);
		text_user.setColumns(10);
		
		text_pass = new JTextField();
		text_pass.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 23));
		text_pass.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		text_pass.setBackground(new Color(255, 153, 51));
		text_pass.setColumns(10);
		text_pass.setBounds(549, 398, 167, 37);
		contentPane.add(text_pass);
		
		JButton btn_mute = new JButton("");
		btn_mute.setSize(new Dimension(30, 10));
		btn_mute.setPreferredSize(new Dimension(30, 10));
		btn_mute.setBorder(null);
		btn_mute.setContentAreaFilled(false);
		btn_mute.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/stopmusic2.png")));
		btn_mute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			music.stop();
				
			}
		});
		btn_mute.setBounds(85, 13, 41, 50);
		contentPane.add(btn_mute);
		
		JButton btn_resume = new JButton("");
		btn_resume.setSize(new Dimension(30, 10));
		btn_resume.setPreferredSize(new Dimension(30, 10));
		btn_resume.setContentAreaFilled(false);
		btn_resume.setBorder(null);
		btn_resume.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/playmusic2.png")));
		btn_resume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				music.resume();
			}
		});
		btn_resume.setBounds(32, 13, 50, 50);
		contentPane.add(btn_resume);
		
		JButton btn_plus = new JButton("");
		btn_plus.setContentAreaFilled(false);
		btn_plus.setBorder(null);
		btn_plus.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/high.png")));
		btn_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				music.up();
			}
		});
		btn_plus.setBounds(143, 23, 50, 37);
		contentPane.add(btn_plus);
		
		JButton btn_minus = new JButton("");
		btn_minus.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/low.png")));
		btn_minus.setBorder(null);
		btn_minus.setContentAreaFilled(false);
		btn_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				music.down();
			}
		});
		btn_minus.setBounds(193, 23, 41, 34);
		contentPane.add(btn_minus);
		
	
		
		JLabel label_name = new JLabel("User Name:");
		label_name.setFont(new Font("Stanger Cursive", Font.BOLD, 25));
		label_name.setBounds(369, 347, 168, 37);
		contentPane.add(label_name);
		
		JLabel label_pass = new JLabel("Password:");
		label_pass.setFont(new Font("Stanger Cursive", Font.BOLD, 25));
		label_pass.setBounds(369, 397, 168, 37);
		contentPane.add(label_pass);
		
		JLabel label_new = new JLabel("New user ?");
		label_new.setForeground(Color.WHITE);
		label_new.setFont(new Font("Stanger Cursive", Font.BOLD, 19));
		label_new.setBounds(12, 570, 133, 45);
		contentPane.add(label_new);
	
		JLabel Background = new JLabel("");
		Background.setBounds(new Rectangle(0, 0, 1100, 700));
		Background.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		Background.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/Main2.png")));
		Background.setBounds(-12, -12, 1124, 722);
		contentPane.add(Background);
		btn_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user=new User(text_user.getText().toString(),text_pass.getText().toString());
				DB_Users data=new DB_Users();
				if(data.login(user))
				{
				player=text_user.getText().toString();
				text_user.setVisible(false);
				text_pass.setVisible(false);
				btn_in.setVisible(false);
				btn_up.setVisible(false);
				label_name.setVisible(false);
				label_pass.setVisible(false);
				label_new.setVisible(false);
		
			
				JButton btn_easy = new JButton("");
				btn_easy.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/easy.png")));
				btn_easy.setBounds(510, 346, 80, 39);
				contentPane.add(btn_easy);
				
				JButton btn_casual = new JButton("");
				btn_casual.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/casual.png")));
				btn_casual.setBounds(510, 398, 80, 38);
				contentPane.add(btn_casual);
				
				JButton btn_hard = new JButton("");
				btn_hard.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/hard.png")));
				btn_hard.setBounds(510, 448, 80, 37);
				contentPane.add(btn_hard);
				
				JButton btn_scores = new JButton("");
			
				btn_scores.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/scores.png")));
				btn_scores.setBounds(510, 493, 80, 37);
				contentPane.add(btn_scores);
				
				JButton btn_help = new JButton("");
				btn_help.setIcon(new ImageIcon(Start.class.getResource("/Guessus/Pics/helpbutton.png")));
				btn_help.setBounds(510, 541, 80, 37);
				contentPane.add(btn_help);
		
				btn_scores.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						main_window.setVisible(false);
						ScoreTable scoreScreen=new ScoreTable();
						scoreScreen.setVisible(true);
					}
				});
				
				
				btn_easy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Level1 window=new Level1();
						window.setVisible(true);
						main_window.setVisible(false);
					}
				});
				
				btn_casual.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Level2 window=new Level2();
						window.setVisible(true);
						main_window.setVisible(false);
					}
				});
				
				btn_hard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Level3 window=new Level3();
						window.setVisible(true);
						main_window.setVisible(false);
					}
				});
				btn_help.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						HowToPlay window=new HowToPlay();
						window.setVisible(true);
					}
				});
				}
				else
				{
					if(data.userFree(text_user.getText().toString()))
					{
						 int dialogButton = JOptionPane.CLOSED_OPTION;
					     int dialogResult = JOptionPane.showConfirmDialog (null, "User Name Does Not Exsist","Warning",dialogButton);
					}
					else {
				     int dialogButton = JOptionPane.CLOSED_OPTION;
				     int dialogResult = JOptionPane.showConfirmDialog (null, "Wrong password","Warning",dialogButton);
					}
					
				}
				
				
				
				
				
				repaint();
			}
		});
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
