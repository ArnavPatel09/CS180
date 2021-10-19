package homework4;
import java.util.Scanner; 

/**
 * A Food Truck order program.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 04 -- Debugging
 *
 * @author Purdue CS
 * @version August 23, 2021
 */
public class FoodTruck {
	public static void main(String args[]) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to place an order? (yes or no)");
        String orderStatus = scanner.nextLine();
        
        String category = "";
        String cookMethod = "";
        String dish = "";
        boolean cat = true;
        boolean method = true;
        
        if (orderStatus.equalsIgnoreCase("no")) {            
            System.out.println("Okay, have a nice day!");            
        } 
        else if (orderStatus.equalsIgnoreCase("yes")) {
        	System.out.println("What would you like to order?");
            
            System.out.println("1. Lamb"); 
            System.out.println("2. Pork");
            System.out.println("3. Chicken");
            System.out.println("4. Vegetables");
            
            int selection = scanner.nextInt();
            
            
            switch (selection) {
                case 1: 
                    category = "Lamb";
                    break;
                case 2: 
                    category = "Pork";
                    break;
                case 3: 
                    category = "Chicken";
                    break;
                case 4: 
                    category = "Vegetables";
                    break;
                default: 
                    System.out.println("Input Error! Valid menu options are from 1 - 4.");
                    cat = false;
            }
            
            
            if (cat) {
            	System.out.println("How would you like it cooked?");
            	System.out.println("1. Fried"); 
            	System.out.println("2. Boiled");

            	selection = scanner.nextInt();

            	switch (selection) { 
                	case 1: 
                		cookMethod = "Fried";
                		break;
                	case 2:
                		cookMethod = "Boiled"; 
                		break;
                	default: 
                		System.out.println("Input Error! Valid cooking options are 1 or 2.");
                		method = false;
            	}
            }
	            
            
            if(cat && method) {
            	dish = cookMethod + " " + category;
            	System.out.println("You have ordered " + dish + "!");
            }
            else
            	System.out.println("We couldn't complete the order, sorry!"); 	  

        }
        else { 
        	String err  = "Input Error! Valid options are yes or no.";
            System.out.println(err);
        }

	}
}