package homework_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Challenge 11 - StatisticsServer
 * The StatisticsServer class is the Server class that works
 * in tandem with StatisticsClient. This class does all of the
 * calculations (finding length, number of words, number of punctuation
 * marks, character count, number of digits, and number of letters)
 * and then sends it to the Statistics Client server.
 * 
 * @author Arnav Patel, L12
 * @version November 9, 2021
 *
 */
public class StatisticsServer {
	
	public static int findLength(String line) { 
		return line.length();
	}
	
	public static int numWords(String line) { 
		int words = 1;
		line = line.strip();
		while (line.contains(" ")) { 
			line = line.substring(line.indexOf(" ") + 1);
			++words;
		}
		
		return words;
	}
	
	public static int numPunct(String line) { 
		int num = 0;
		for (int i = 0; i < line.length(); i++) { 
			if ( (!Character.isLetterOrDigit(line.charAt(i))) && (!line.substring(i, i + 1).contains(" ")) ) { 
				num++;
			}
		}
		return num;
	}
	
	public static int charCount(String line) { 
		int charCount = line.length();
		while (line.contains(" ")) { 
			line = line.substring(line.indexOf(" ") + 1);
			--charCount;
		}
		
		return charCount;
	}
	
	public static int occur(String line, char character, int index) {
		int count = 0;
		
		if (index >= line.length())
			return 0;
		if (line.toLowerCase().charAt(index) == character) { 
			count++;
		}
		
		return count + occur(line, character, index + 1);
	}
	
	public static String numDigits(String line) { 
		int[] freq = new int[10];
		String numToString = "";
		freq[0] = occur(line, '0', 0);
		freq[1] = occur(line, '1', 0);
		freq[2] = occur(line, '2', 0);
		freq[3] = occur(line, '3', 0);
		freq[4] = occur(line, '4', 0);
		freq[5] = occur(line, '5', 0);
		freq[6] = occur(line, '6', 0);
		freq[7] = occur(line, '7', 0);
		freq[8] = occur(line, '8', 0);
		freq[9] = occur(line, '9', 0);
		
		for (int k = 0; k < freq.length; k++) { 
			if (freq[k] != 0) {
				numToString += String.format("%d-%d ", k, freq[k]);
			}
			if (k == 9)
				numToString.stripTrailing();
		}
		
		return numToString;
	}
	
	public static String numLetter(String line) { 
		int[] freq = new int[26];
		String letToString = "";
		freq[0] = occur(line, 'a', 0);
		freq[1] = occur(line, 'b', 0);
		freq[2] = occur(line, 'c', 0);
		freq[3] = occur(line, 'd', 0);
		freq[4] = occur(line, 'e', 0);
		freq[5] = occur(line, 'f', 0);
		freq[6] = occur(line, 'g', 0);
		freq[7] = occur(line, 'h', 0);
		freq[8] = occur(line, 'i', 0);
		freq[9] = occur(line, 'j', 0);
		freq[10] = occur(line, 'k', 0);
		freq[11] = occur(line, 'l', 0);
		freq[12] = occur(line, 'm', 0);
		freq[13] = occur(line, 'n', 0);
		freq[14] = occur(line, 'o', 0);
		freq[15] = occur(line, 'p', 0);
		freq[16] = occur(line, 'q', 0);
		freq[17] = occur(line, 'r', 0);
		freq[18] = occur(line, 's', 0);
		freq[19] = occur(line, 't', 0);
		freq[20] = occur(line, 'u', 0);
		freq[21] = occur(line, 'v', 0);
		freq[22] = occur(line, 'w', 0);
		freq[23] = occur(line, 'x', 0);
		freq[24] = occur(line, 'y', 0);
		freq[25] = occur(line, 'z', 0);
		
		for (int k = 0; k < freq.length; k++) { 
			if (freq[k] != 0) {
				letToString += String.format("%c-%d ", ((char) (k + 65)), freq[k]);
			}
			if (k == 9)
				letToString.stripTrailing();
		}
		return letToString;
	}
	
	public static void main(String[] args) throws IOException {
		boolean goAgain = true;
		ServerSocket serverSocket = new ServerSocket(4242);
    	Socket socket = serverSocket.accept();
  
    	BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	PrintWriter writer = new PrintWriter(socket.getOutputStream());
    	
    	
    	while (goAgain) {
    		//reads the string line
    		String line = reader.readLine();
    		if (line == null)
    			break;
    		//do the calculations
    		String length = "Length: " + findLength(line);   		
    		String words = "Number of words: " + numWords(line);    		
    		String punctuation = "Number of puncutation marks: " + numPunct(line);
    		String character = "Character count without spaces: " + charCount(line);
    		String digits = "Frequency of digits: " + numDigits(line);
    		String letters = "Frequency of letters: " + numLetter(line);
    		//send calculations to Client
    		writer.write(length);
    		writer.println();
    		writer.flush();
    		
    		writer.write(words);
    		writer.println();
    		writer.flush();
    		
    		writer.write(punctuation);
    		writer.println();
    		writer.flush();
    		
    		writer.write(character);
    		writer.println();
    		writer.flush();
    		
    		writer.write(digits);
    		writer.println();
    		writer.flush();
    		
    		writer.write(letters);
    		writer.println();
    		writer.flush();
    		
    		String again = reader.readLine();
    		if (again.equals("0")) { 
				goAgain = true;
			} else {
				goAgain = false;
			}
    	}
    	writer.close();
    	reader.close();	
	}
}
