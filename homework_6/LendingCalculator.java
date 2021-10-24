package homework_6;

import java.util.Scanner;
/*
* A program that prompts the user for input and uses Loan class to 
* make calculations on the loan that the user inputted
*
* Purdue University -- CS18000 -- Fall 2021 -- Homework 06 -- Challenge
*
* @author Arnav Patel L12
* @version October 4, 2021
*/
public class LendingCalculator { 
    // fields
    private static String welcomeMessage = "Welcome to the Lending Calculator!"; 
    private static String menu = "Menu";
    private static String initialMenu = "0. Quit\n1. Add a loan";
    private static String ongoingMenu = "0. Quit\n1. Modify Loan\n2. Calculate Total Interest";
    private static String exitMessage = "Thank you!";
    private static String durationMessage = "Enter the duration:";
    private static String rateMessage = "Enter the rate:";
    private static String amountMessage = "Enter the amount:"; 
    private static String amortizationPrompt = "Would you like to print the amortization schedule?"; 
    private static String amortizationMenu = "1. Yes\n2. No"; 
    private static String totalInterestMessage = "Total Interest: ";
    private static String errorMessage = "Error! Invalid input."; 
   
    
    public static void initial() {
    	//this function will be the initial stage of the menu where a user can choose to add or quit
    	System.out.println(menu);
    	System.out.println(initialMenu);
    }
    public static void ongoing() {
    	//this function will be the ongoing stage of the menu where a user can choose to add or quit
    	System.out.println(menu);
    	System.out.println(ongoingMenu);
    }
    
    public static void main(String[] args) {
    	// it exits after modifying the loan (should not do this)
    	// so i changed restart to true
    	Scanner scan = new Scanner(System.in);
    	boolean restart = true;
    	boolean firstTime = true;
    	int dur;
    	double amt;
        double rate;
    	int menuAnswer;
    	int ammortAnswer = 0;
    	double totalInterest;
    	Loan loan = new Loan(0, 0, 0);
    	//start of the program
    	System.out.println(welcomeMessage);
    	do { 
    		if (firstTime) { //do this because u only want to run initial menu once
    			do { 
    				initial();
    				menuAnswer = scan.nextInt();
    				if (menuAnswer != 0 && menuAnswer != 1)
    					System.out.println(errorMessage);
    			} while (menuAnswer != 0 && menuAnswer != 1);
    			firstTime = false;
    		} else { 
    			do { 
    				ongoing();
    				menuAnswer = scan.nextInt();
    				if (menuAnswer != 0 && menuAnswer != 1 && menuAnswer != 2)
    					System.out.println(errorMessage);
    			} while (menuAnswer != 0 && menuAnswer != 1 && menuAnswer != 2);
    		}
    		if (menuAnswer == 0)
    			break;
    		if (menuAnswer == 1) { 
    			System.out.println(durationMessage);
    			dur = scan.nextInt();
    			System.out.println(rateMessage);
    			rate = scan.nextDouble();
    			System.out.println(amountMessage);
    			amt = scan.nextDouble();
    			loan = new Loan(dur, rate, amt);
    			System.out.println(loan.toString());
    		} else if (menuAnswer == 2) { 
    			do { 
    				System.out.println(amortizationPrompt);
    				System.out.println(amortizationMenu);
        			ammortAnswer = scan.nextInt();
        			if (ammortAnswer != 1 && ammortAnswer != 2)
        				System.out.println(errorMessage);
    			} while (ammortAnswer != 1 && ammortAnswer != 2);
    			
    		}
    		if (ammortAnswer == 1) { 
    			totalInterest = loan.calculateTotalInterst(true);
    			System.out.println(totalInterestMessage + String.format("%.2f", totalInterest));
    		} else if (ammortAnswer == 2) { 
    			totalInterest = loan.calculateTotalInterst(false);
    			System.out.println(totalInterestMessage + String.format("%.2f", totalInterest));
    		}
    		
    	} while(restart);
    	
    	System.out.println(exitMessage);
    }
    
    
}