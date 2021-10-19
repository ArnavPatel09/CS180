package homework4;
import java.util.Scanner;

/**
 * A program that determines the price of a custom-made toy.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 04 -- Challenge
 *
 * @author Arnav Patel L12
 * @version September 15, 2021 
 */

public class ToySeller {

    private static String welcomeMessage = "Welcome to the Custom Toy Builder!\nOur store can custom-design " +
            "3 different types of toys.";
    private static String startMessage = "Which would you like to create? (Enter a number)\n" +
            "1. Superman figurine\n" +
            "2. Robotic cyclops\n" +
            "3. Cat-shaped lamp\n" +
            "4. EXIT";
    private static String endProgram = "Thanks for using the Custom Toy Builder!";

    private static String sizeQuestion = "What size toy would you like? (Enter S, M, or L)";
    private static String supermanQ1 = "Do you want Superman to talk? (Enter Y or N)";
    private static String supermanQ2 = "Do you want to add a cape? (Enter Y or N)";
    private static String roboticCyclopsQ1 = "Do you want the Robotic Cyclops to move? (Enter Y or N)";
    private static String roboticCyclopsQ2 = "What color eye do you want? (Enter 1, 2, or 3)\n" +
            "1. Red\n" +
            "2. Yellow\n" +
            "3. Blue";
    private static String catLampQ1 = "What color Cat-shaped Lamp do you want? (Enter 1, 2, 3, or 4)\n" +
            "1. Gold\n" +
            "2. Pink\n" +
            "3. Blue\n" +
            "4. No Color";
    private static String catLampQ2 = "Do you want the Cat-shaped Lamp to glow? (Enter Y or N)";

    private static String supermanCost = "Your Superman figurine costs";
    private static String roboticCyclopsCost = "Your Robotic Cyclops costs";
    private static String catLampCost = "Your Cat-shaped Lamp costs";


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalPrice = 0; //will store the cost of the toy
        int toyType = 0; //stores the toy type
        String size = "a"; //stores the size of the toy
        String move = "a"; //stores whether or not the user wants to add mobility to the toy
        String q1 = ""; //stores the user input for the 1st toy specific question
        String q2 = ""; //stores the user input for the 2nd toy specific question
        

        //start
        System.out.println(welcomeMessage);
        System.out.println(startMessage);
        
        //user inputs the type of toy
        toyType = scan.nextInt();
        //scan.next();
        //checks if the input is valid
        switch(toyType) {
        	case 1:
        		break;
        	case 2:
        		break;
        	case 3:
        		break;
        	default:
        		toyType = 0;
        		
        }
       //if the user selected a valid toy type it will continue to ask questions
       //otherwise it will just print the end program statement
        if (toyType != 0) { 
        	System.out.println(sizeQuestion);
        	size = scan.next().substring(0, 1).toLowerCase(); 
        	//this takes the first character, converts it to lower case, and assigns it to the variable size
        	switch (size) {
        	//checks if the input is valid
	        	case "s":
	        		totalPrice += 5; 
	        		break;
	        	case "m":
	        		totalPrice += 10;
	        		break;
	        	case "l":
	        		totalPrice += 15;
	        		break;
	        	default:
	        		size = "a";
        	}        	
        	
        }
        
        //separation by toy type
        //this is for Superman
        if (toyType == 1) {
        	System.out.println(supermanQ1);
        	q1 = scan.next().substring(0, 1).toLowerCase(); 
        	//checks the input
        	switch (q1) {
	        	case "y":
	        		totalPrice += 8;
	        		break;
	        	case "n":
	        		totalPrice += 4;
	        		break;
	        	default:
	        		q1 = "a";
        	}
        	if (!q1.equals("a")) {
        		System.out.println(supermanQ2);
        		q2 = scan.next().substring(0, 1).toLowerCase();
        		if (q2.equals("y")) { 
        			totalPrice += 5;
        		}
        	}
        	if (!q1.equals("a") && !q2.equals("a")) {
        		System.out.printf("%s $%d!\n", supermanCost, totalPrice);
        	}
        }
        //this is for Robotic Cyclops 
        else if (toyType == 2) { 
        	System.out.println(roboticCyclopsQ1);
        	q1 = scan.next().substring(0, 1).toLowerCase();
        	
        	//checks the input
        	switch (q1) {
	        	case "y":
	        		totalPrice += 5;
	        		break;
	        	case "n":
	        		totalPrice += 3;
	        		break;
	        	default:
	        		q1 = "a";
        	}
        	if (!q1.equals("a")) {
        		System.out.println(roboticCyclopsQ2);
        		//int rcq2 = scan.nextInt();
        		q2 = scan.next().substring(0, 1);
        		//scan.next();
        		switch (q2) {
	        		case "1":
	        			totalPrice += 5;
	        			break;
	        		case "2":
	        			totalPrice += 6;
	        			break;
	        		case "3":
	        			totalPrice += 7;
	        			break;
	        		default:
	        			q2 = "a";
        		}
        	}
        	if (!q1.equals("a") && !q2.equals("a")) {
        		System.out.printf("%s $%d!\n", roboticCyclopsCost, totalPrice);
        	}
        }
        //this is for cat-shaped Lamp
        else if (toyType == 3) {
        	System.out.println(catLampQ1);
        	//checks the input
        	q1 = scan.next().substring(0, 1);
    		//scan.next();
    		switch (q1) {
	    		case "1":
	    			totalPrice += 10;
	    			break;
	    		case "2":
	    			totalPrice += 7;
	    			break;
	    		case "3":
	    			totalPrice += 7;
	    			break;
	    		case "4":
	    			totalPrice += 5;
	    			System.out.printf("%s $%d!\n", catLampCost, totalPrice);
	    		default:
	    			q1 = "a";
    		}	
        	if (!q1.equals("a")) {
        		System.out.println(catLampQ2);
        		q2 = scan.next().substring(0, 1).toLowerCase();
        		switch (q2) {
	        		case "y":
	        			totalPrice += 10;
	        			break;
	        		case "n":
	        			break;
	        		default:
	        			q2 = "a";
        		}
        		
        		if (!q1.equals("a") && !q2.equals("a")) {
        			System.out.printf("%s $%d!\n", catLampCost, totalPrice);
        		}
        	}
        }
        System.out.println(endProgram);
    }
}