package homework_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Challenge 11 - StatisticsClient
 * The StatisticsClient class is the Client class that works
 * in tandem with StatisticsServer. This class sends information
 * to the user using GUIs, and communicates with the server about
 * what the user inputted.
 * 
 * @author Arnav Patel, L12
 * @version November 9, 2021
 *
 */

public class StatisticsClient {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {  
		//print out welcome message
		JOptionPane.showMessageDialog(null, "Welcome to the String Statistics Program", "Welcome Message", JOptionPane.INFORMATION_MESSAGE);
		// ask for host name and port number
		String hostName = JOptionPane.showInputDialog(null, "Please enter the host name", "Host Name", JOptionPane.QUESTION_MESSAGE);
		
		//check if the user didn't click cancel or the close button
		boolean port = false;
		if (hostName != null) {
			//ask for the port number and display the appropriate message
			String portNumber = JOptionPane.showInputDialog(null, "Please enter the port number", "Port Number", JOptionPane.QUESTION_MESSAGE);
			if (portNumber != null && portNumber.equals("4242")) {
	    		JOptionPane.showMessageDialog(null, "Connection has been established", "Connection Message", JOptionPane.INFORMATION_MESSAGE);
	    		port = true;
	    	} else if (portNumber != null) {
	    		JOptionPane.showMessageDialog(null, "Connection has not been established", "Connection Message", JOptionPane.ERROR_MESSAGE);
	    	}
			
			
		}
		//create local variables if port was correct
		if (port) { 
			Scanner scan = new Scanner(System.in);
			Socket socket = new Socket(hostName, 4242);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			boolean goAgain = port;
			
			
			//String loop starts here
			while (goAgain) {
				//ask for the string
				String line = JOptionPane.showInputDialog(null, "Please enter String", "User Input", JOptionPane.QUESTION_MESSAGE);
				if (line == null) { 
					break;
				}
				//send the string to the Server
				writer.write(line);
				writer.println();
				writer.flush();
				
				//get the calculations back from the server
				String calculatedValues = reader.readLine() + "\n";
				calculatedValues += reader.readLine() + "\n";
				calculatedValues += reader.readLine() + "\n";
				calculatedValues += reader.readLine() + "\n";
				calculatedValues += reader.readLine() + "\n";
				calculatedValues += reader.readLine();
				//show the user the calculated details
				JOptionPane.showMessageDialog(null, calculatedValues, "Values calculated", JOptionPane.INFORMATION_MESSAGE);
				//prompt the user to enter another string
				int again = JOptionPane.showConfirmDialog(null, "Would you like to enter another String", "Go Again?", JOptionPane.YES_NO_OPTION);
				writer.write(Integer.toString(again));
				writer.println();
				writer.flush();
				if (again == 0) { 
					goAgain = true;
				} else {
					goAgain = false;
					JOptionPane.showMessageDialog(null, "Thank you for using the String Statistics Program, have a good day!", "Farewell Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			writer.close();
			reader.close();
			scan.close();
			socket.close();
		}
	}
	
	
	
}
