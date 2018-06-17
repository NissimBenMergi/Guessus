package Guessus;

/**
 * a single user class
 * @author  Lior Chausovski
 * @author  Nissim Ben-Mergi 
 * 
 */
public class User {

	/**
	 * string for user name
	 */
	private String name;
	/**
	 * string for user password
	 */
	private String pass;
	/**
	 * int for user score
	 */
	private int scroe;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getScroe() {
		return scroe;
	}
	public void setScroe(int scroe) {
		this.scroe = scroe;
	}
	
	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
		this.scroe = 0;
	}
	
	
	
}
