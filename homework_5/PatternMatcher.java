package homework_5;

import java.util.Scanner;
/**
 * A program that allows the user to play a pattern game. The user selects the difficulty
 * and the first value of the pattern. Then program prints the first 4 values of the pattern
 * and then asks the user to enter the next 3 values of the pattern and lets the user
 * know if the values they inputted are correct or not
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 05 -- Challenge
 *
 * @author Arnav Patel L12
 * @version September 22, 2021
 */

public class PatternMatcher {
    
    public static void main(String[] args) {
        
        String chooseLevel = "Choose Level Difficulty:" +
                "\n1. Easy\n2. Medium\n3. Hard";
        String startNumber = "Enter a number to start the pattern:";
        String nextThree = "Enter the next 3 numbers in the pattern:";
        String congratulations = "Congrats! Your answer was correct!";
        String sorry = "Sorry! Your answer was incorrect!";
        String again = "Play Game Again? (y/n)";
        String ending = "Ending Pattern Matcher...";
        
        Scanner scan = new Scanner(System.in);
        
        String repeat = "";
        int level = 0;
        int startPattern = 0;
        int [] lastThree = new int[3]; //will contain the last 3 values that the user inputs
        boolean correct = true;
        
        
        // If the user inputs an invalid option while selecting the level, print the menu again
        // print end program when user inputs anything other than y when prompted with "Play Game Again"
        do { 
        	do { 
        		System.out.println(chooseLevel);
        		level = scan.nextInt();
        	} while(level != 1 && level != 2 && level != 3);
        	
        	System.out.println(startNumber);
        	startPattern = scan.nextInt();
        	System.out.println(nextThree);
        	switch(level) { 
        		case 1:
        			for(int i = 0; i<4; i++) { 
        				System.out.print(startPattern);
        				if(i != 3)
        					System.out.print(" ");
        				startPattern += 2;
        			}
        			for(int i = 0; i<3; i++) { 
        				lastThree[i] = startPattern;
        				startPattern += 2;
        			}
        			break;
        		case 2:
        			for(int i = 0; i<4; i++) {
        				System.out.print(startPattern);
        				if(i != 3)
        					System.out.print(" ");
        				startPattern *= 4;
        			}
        			for(int i = 0; i<3; i++) { 
        				lastThree[i] = startPattern;
        				startPattern *= 4;
        			}
        			break;
        		case 3:
        			int computedVal = startPattern*startPattern + 1;
        			for(int i = 0; i<4; i++) { 
        				System.out.print(computedVal);
        				if(i != 3)
        					System.out.print(" ");
        				++startPattern;
        				computedVal = startPattern*startPattern + 1;
        			}
        			for(int i = 0; i<3; i++) { 
        				lastThree[i] = computedVal;
        				++startPattern;
        				computedVal = startPattern*startPattern + 1;
        			}
        			break;
        	}
        	System.out.println();
        	for(int i = 0; i<lastThree.length; i++) { 
        		if(lastThree[i] != scan.nextInt())
        			correct = false;
        	}
        	if(correct)
        		System.out.println(congratulations);
        	else
        		System.out.println(sorry);
        	System.out.println(again);
        	repeat = scan.next();
        	
        } while(repeat.equalsIgnoreCase("y"));
        
        System.out.print(ending);

    }
}