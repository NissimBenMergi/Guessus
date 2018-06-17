package Guessus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
/**
 * This class constructs a frame for the sign up screen
 * <p>
 * The class runs a sign up Jframe
 *
 * @author  Lior Chausovski
 * @author  Nissim Ben-Mergi 
 * 
 */
public class SignUp extends JFrame {

	
	private JPanel contentPane;
	private JTextField text_user;
	private JTextField text_pass;
	private JTextField text_pass2;
	

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 398);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		text_user = new JTextField();
		text_user.setForeground(new Color(255, 255, 255));
		text_user.setFont(new Font("Tahoma", Font.BOLD, 15));
		text_user.setBackground(new Color(51, 0, 153));
		text_user.setBounds(227, 20, 107, 20);
		contentPane.add(text_user);
		text_user.setColumns(10);
		
		JLabel lblUsername = new JLabel("User Name:");
		lblUsername.setFont(new Font("Arial Black", Font.ITALIC, 18));
		lblUsername.setBounds(47, 12, 132, 33);
		contentPane.add(lblUsername);
		
		text_pass = new JTextField();
		text_pass.setForeground(new Color(255, 255, 255));
		text_pass.setFont(new Font("Tahoma", Font.BOLD, 15));
		text_pass.setBackground(new Color(0, 0, 153));
		text_pass.setBounds(227, 58, 107, 20);
		contentPane.add(text_pass);
		text_pass.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial Black", Font.ITALIC, 18));
		lblPassword.setBounds(43, 58, 120, 17);
		contentPane.add(lblPassword);
		
		JButton btn_SignUp = new JButton("");
		btn_SignUp.setContentAreaFilled(false);
		btn_SignUp.setIcon(new ImageIcon(SignUp.class.getResource("/Guessus/Pics/singup.png")));
	
		btn_SignUp.setBounds(142, 251, 83, 37);
		contentPane.add(btn_SignUp);
		
		text_pass2 = new JTextField();
		text_pass2.setFont(new Font("Tahoma", Font.BOLD, 15));
		text_pass2.setForeground(new Color(255, 255, 255));
		text_pass2.setBackground(new Color(0, 0, 153));
		text_pass2.setBounds(227, 102, 107, 20);
		contentPane.add(text_pass2);
		text_pass2.setColumns(10);
		
		JLabel lblReapetPassword = new JLabel("Reapet Password:");
		lblReapetPassword.setFont(new Font("Arial Black", Font.ITALIC, 18));
		lblReapetPassword.setBounds(37, 93, 188, 34);
		contentPane.add(lblReapetPassword);
		
		JButton btn_back = new JButton("");
		btn_back.setContentAreaFilled(false);
		btn_back.setIcon(new ImageIcon(SignUp.class.getResource("/Guessus/Pics/backtomenu.png")));
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn_back.setBounds(142, 301, 83, 37);
		contentPane.add(btn_back);
		this.setAlwaysOnTop(true);
		SignUp window=this;
		btn_SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DB_Users data=new DB_Users();
				
				if(text_user.getText().toString().length()<3)
				{
					  int dialogButton = JOptionPane.CLOSED_OPTION;
				      int dialogResult = JOptionPane.showConfirmDialog (null, "User Name Too Short!","Warning",dialogButton);
				}
				else if(text_pass.getText().toString().length()<3)
				{
					  int dialogButton = JOptionPane.CLOSED_OPTION;
				      int dialogResult = JOptionPane.showConfirmDialog (null, "password Too Short!","Warning",dialogButton);
				}	
				else if(!text_pass.getText().toString().equals(text_pass2.getText().toString()))
				{
					  int dialogButton = JOptionPane.CLOSED_OPTION;
				      int dialogResult = JOptionPane.showConfirmDialog (null, "Passwords Dont Match!","Warning",dialogButton);
				}
				else if(!data.userFree(text_user.getText().toString()))
				{
					  int dialogButton = JOptionPane.CLOSED_OPTION;
				      int dialogResult = JOptionPane.showConfirmDialog (null, "User Name Taken!","Warning",dialogButton);
				}
				else {
				User user=new User(text_user.getText().toString(),text_pass.getText().toString());
				data.register(user);
				window.setVisible(false);
				}
			}
		});
	}
}
