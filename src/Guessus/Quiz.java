package Guessus;

import java.io.File;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

/**
 * This class creates a set made of questions
 * <p>
 *
 * @author  Lior Chausovski
 * @author  Nissim Ben-Mergi 
 * 
 */
    public class Quiz {
    	/**
    	 * contains all the questions
    	 */
	Set<Question> set = new HashSet<Question>();
	
	
	
	
	/**
	 * get a set of easy questions
	 * @return set with easy questions
	 */
	public Set getEasy() throws IOException 
	{
		
		Question question=new Question("adidas","aaidds","/Guessus/Pics/adidas.png");
		set.add(question);
		question=new Question("wifi","fiiw","/Guessus/Pics/wifi.png");
		set.add(question);
		question=new Question("kfc","fck","/Guessus/Pics/kfc.png");
		set.add(question);
		question=new Question("pepsi","eipps","/Guessus/Pics/pepsi.png");
		set.add(question);
		question=new Question("xbox","oxxb","/Guessus/Pics/xbox.png");
		set.add(question);
		return set;
	}
	
	/**
	 * get a set of casual questions
	 * @return set with casual questions
	 */
	public Set getCasual() throws IOException 
	{
		
		Question question=new Question("cartoon network","toracon krotwne","/Guessus/Pics/cartoon network.png");
		set.add(question);
		question=new Question("chicago bulls","icoghac llubs","/Guessus/Pics/chicago bulls.png");
		set.add(question);
		question=new Question("red bull","rde llub","/Guessus/Pics/redbull.png");
		set.add(question);
		question=new Question("seven eleven","eevns eenvl","/Guessus/Pics/seven e.png");
		set.add(question);
		question=new Question("sound cloud","nouds doulc","/Guessus/Pics/sound cloud.png");
		set.add(question);
		return set;
	}
	
	/**
	 * get a set of hard questions
	 * @return set with hard questions
	 */
	public Set getHard() throws IOException 
	{
		
		
	    Question question=new Question("java","aavj","/Guessus/Pics/java.png");
		set.add(question);
	    question=new Question("yamaha","amyhaa","/Guessus/Pics/yamaha.png");
		set.add(question);
		question=new Question("wella","allwe","/Guessus/Pics/wella.png");
		set.add(question);
		question=new Question("converse","ersceonv","/Guessus/Pics/Converse.png");
		set.add(question);
		question=new Question("blackberry","byekrlrcba","/Guessus/Pics/blackberry.png");
		set.add(question);
		return set;
	}
}
