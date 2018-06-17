package Guessus;

import java.awt.image.BufferedImage;

/**
 * This class constructs a single question
 * <p>
 *
 * @author  Lior Chausovski
 * @author  Nissim Ben-Mergi 
 * 
 */

public class Question {

	/**
	 * the right answer
	 */
	String answer;
	/**
	 * the clue
	 */
	String clue;
	/**
	 * picture path
	 */
	String pic;
	
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getClue() {
		return clue;
	}
	public void setClue(String clue) {
		this.clue = clue;
	}
	public String getPic() {
		return pic;
	}
	public void String(String pic) {
		this.pic = pic;
	}
	
	public Question(String answer, String clue, String pic) {
		this.answer = answer;
		this.clue = clue;
		this.pic = pic;
	}
	
	
}
