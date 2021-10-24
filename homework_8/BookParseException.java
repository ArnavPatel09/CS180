package homework_8;
/**
 * Homework 8 - BookParseException
 * <p>
 * Thrown when there is an error while parsing Books from the file.
 * 
 * @author Arnav Patel L12
 * @version October 17, 2021
 */
public class BookParseException extends java.lang.Exception{
	
	public BookParseException(String message) { 
		super(message);
	}
}
