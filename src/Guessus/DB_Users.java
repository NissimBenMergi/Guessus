package Guessus;


import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 * This class constructs a JDBC driver helper named DB_Users
 * <p>
 * The class contains all the variables and methods for an instance
 * of JDBC driver controller for connecting, creating  and querying
 * a database
 *
 * @author  Lior Chausovski
 * @author  Nissim Ben-Mergi 
 * 
 */

public class DB_Users {

	/**
	 * Url to MySQL server connection and database name
	 */
	private String jdbcUrl="jdbc:mysql://localhost:3306/user_db";
	
	/**
	 * Username for database connection
	 */
	String jdbcUser="root";
	/**
	 * Password for database connection
	 */
	String jdbcPass="root";

	/**
	 * Table name in DB
	 */
    private String table = "Users";
	
	/**
	 * Database connection instance
	 */
	private Connection connection;
	
	/**
	 * User login statement
	 */
	private PreparedStatement loginStatement;
	
	/**
	 * User register statement
	 */
	private PreparedStatement registerStatement;
	
	/**
	 * Check if user exists in DB statement
	 */
	private PreparedStatement checkStatement;
	
	/**
	 * find user statement
	 */
	private PreparedStatement findStatement;
	/**
	 * 
	 * find user score statement
	 */
	private PreparedStatement findScoreStatement;
	
	/**
	 * 
	 * update user score statement
	 */
	private PreparedStatement updateScoreStatement;
	
	/**
	 * 
	 * get  scores statement
	 */
	private PreparedStatement scoreListStatement;
	/**
	 * 
	 * get users statement
	 */
	private PreparedStatement userListStatement;
	
	/**
	 * DB_Users instance constructor that initiates all variables 
	 * with appropriate instances
	 */
	public DB_Users() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
			DatabaseMetaData meta = connection.getMetaData();
			ResultSet res = meta.getTables(null, null, table, new String[] { "TABLE" });
			if (!res.next()) {
				connection.createStatement()
						.executeUpdate("CREATE TABLE " + table + "(" 
								+ "username varchar(20) NOT NULL PRIMARY KEY,"
								+ "password varchar(22) NOT NULL,"
								+ "score int,"
								+ "UNIQUE(username)" 
								+ ");"
								);
			}
			loginStatement = connection
					.prepareStatement("SELECT username FROM Users WHERE username = ? AND password = ?;");
			registerStatement = connection.prepareStatement(
					"INSERT INTO " + table + " (username, password) " + "VALUES (?, ?);"
					);
			checkStatement = connection
					.prepareStatement("SELECT username FROM Users WHERE username = ?;");
			findStatement = connection
					.prepareStatement("SELECT * FROM Users WHERE username = ?;");
			findScoreStatement = connection
					.prepareStatement("SELECT score FROM Users WHERE username = ?;");
			updateScoreStatement = connection.prepareStatement(
					"UPDATE " + table + " SET "+"score=" + "?"+" WHERE username=?;"
					);
			scoreListStatement = connection
					.prepareStatement("SELECT score FROM Users ORDER BY score DESC;");
			userListStatement = connection
					.prepareStatement("SELECT username FROM Users ORDER BY score DESC;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Login method for registered user
	 * @param user an object with login details
	 * @return true if new user is added to DB
	 */
	public boolean login(User user) {
		try {
			loginStatement.setString(1, user.getName());
			loginStatement.setString(2, user.getPass());
			ResultSet res = loginStatement.executeQuery();
			if(res.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Register method for new users
	 * @param user an object with register details
	 * @return true if user does not exist yet
	 */
	public boolean register(User user) {
		try {
			checkStatement.setString(1, user.getName());
			ResultSet res = checkStatement.executeQuery();
			if(res.next()) {
				return false;
			}
			registerStatement.setString(1, user.getName());
			registerStatement.setString(2, user.getPass());
			registerStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * Check if username is not taken
	 * @param name a string with the username
	 * @return true if user name is free
	 */
	public boolean userFree(String name) {
		try {
			checkStatement.setString(1, name);
			ResultSet res = checkStatement.executeQuery();
			if(res.next()) {
				return false;
			}
		
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * Update score field in DB
	 * @param name a string with the username
	 * @param score a integer with the new score
	 * @return true if update was succesfull
	 */
	public boolean scoreUpdate(String name,int score) {
		try {

			updateScoreStatement.setInt(1,score);
			updateScoreStatement.setString(2,name);
			updateScoreStatement.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * get score field of user
	 * @param name a string with the username
	 * @return integer that is the score
	 */
	public int getScore(String name) {
		try {
			findScoreStatement.setString(1, name);
			ResultSet res = findScoreStatement.executeQuery();
			res.next();
			return res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * create username, score table from DB
	 * @return JTable that cointains username and score data
	 */
	public JTable getScoreList() {
		// Map <String, Integer>scores = new HashMap<String, Integer>();
		JTable table=null;
		 int i=0;
		 Object[][] data = new Object[10][2];  
		 String columnNames[] = { "Name", "Score" };
		 
		 
		try {
			ResultSet res1 = scoreListStatement.executeQuery();
			ResultSet res2 = userListStatement.executeQuery();
			while(res1.next()&&res2.next())
			{
			
				if(res2.getString(1).equals(Start.player))
				{
					data[i][0]="**  "+res2.getString(1)+"  **";
					data[i][1]="**  "+res1.getInt(1)+"  **";
				}
				else
				{
					data[i][0]=res2.getString(1);
					data[i][1]=res1.getInt(1);
				}
				i++;
			}
		table =new JTable(data,columnNames);
		table.setForeground(Color.BLACK);
		table.setAutoResizeMode(i);
		table.setBackground(Color.ORANGE);
		table.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 17));
		
		
		return table;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return table;
	}
	
	
}
