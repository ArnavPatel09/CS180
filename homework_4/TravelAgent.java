package homework4;

import java.util.Scanner;

/**
 * A program that identifies a travel destination.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 04 -- Walkthrough
 *
 * @author Purdue CS
 * @version August 23, 2021
 */

public class TravelAgent {
    public static void main(String[] args) {
        String destination = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a number between 1-4 to select a destination!");

        int number = scanner.nextInt();
        
        switch (number) {
        case 1:
        	destination = "Great Pyramid of Giza, Egypt";
        	System.out.printf("Your travel destination: %s!\n", destination);
        	break;
        case 2:
        	destination = "Amazon Rainforest, Brazil";
        	System.out.printf("Your travel destination: %s!\n", destination);
        	break;
        case 3:
        	destination = "Eiffel Tower, France";
        	System.out.printf("Your travel destination: %s!\n", destination);
        	break;
        case 4:
        	destination = "Mt. Fuji, Japan";
        	System.out.printf("Your travel destination: %s!\n", destination);
        	break;
        default:
        	System.out.println("That's not a valid number! Guess we're not traveling...");
        	break;
        }

        
        scanner.close();

    }
}
