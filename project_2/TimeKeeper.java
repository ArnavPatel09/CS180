package project_2;
import java.util.Scanner;
/**
* Project 2 - Time Keeper
* 
* The TimeKeeper class represents the menus for a user
* to navigate as they manage labs. There are 3 menus
* initialization, ongoing, and statistics.
* 
*
* Purdue University -- CS18000 -- Fall 2021 -- Project 02
*
* @author Arnav Patel L12
* @version October 16, 2021
*/
public class TimeKeeper {
    
    private static String welcomePrompt = "Welcome to the TimeKeeper application!";
    private static String invalidInput = "Invalid input. Please try again.";
    private static String enterLabCapacity = "Enter the capacity for Lab ";
    private static String enterLabLocation = "Enter the location for Lab "; 
    private static String labLocationPrompt = "Enter the location of the lab:"; 
    private static String reservationTimePrompt = "Enter the time of the reservation:"; 
    private static String reservationNamePrompt = "Enter the name of the reservation:";
    private static String reservationEnrollmentPrompt = "Enter the expected enrollment:"; 
    private static String reservationNameUpdate = "Enter the updated name of the reservation:";
    private static String reservationEnrollmentUpdate = "Enter the updated enrollment:"; 
    private static String totalCapacity = "Total Capacity: ";
    private static String totalUtilization = "Total Utilization: ";
    private static String availableSeats = "Available seats: "; 
    
    
    private static String initializeMenu = "1. Initialize Application\n" +
                                        "2. Exit";
    private static String ongoingMenu = "1. View Current Lab Schedule\n" +
                                "2. List Labs by Availability\n" +
                                "3. List Labs by Reservation\n" +
                                "4. Add a Reservation\n" +
                                "5. Remove a Reservation\n" +
                                "6. Modify a Reservation\n" +
                                "7. Calculate Statistics\n" +
                                "8. Exit";
    private static String statisticsMenu = "1. Total Capacity\n" +
                                            "2. Total Utilization\n" +
                                            "3. Available seats\n" +
                                            "4. Return to main menu";
    private static String exitMessage = "Thank you for using TimeKeeper!";

    
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	boolean restart = true;
    	boolean firstTime = true;
    	int menuAnswer;
    	
    	Lab labOne = new Lab(0, "");
		Lab labTwo = new Lab(0, "");
		Lab labThree = new Lab(0, "");
		LabManager manager = new LabManager(labOne, labTwo, labThree);
    	
    	System.out.println(welcomePrompt);
    	do { 
    		//printing out menu
    		if (firstTime) { 
    			do { 
    				System.out.println(initializeMenu);
    				menuAnswer = scan.nextInt();
    				if (menuAnswer != 1 && menuAnswer != 2) { 
    					System.out.println(invalidInput);
    				}
    			} while(menuAnswer != 1 && menuAnswer != 2);
    			if (menuAnswer == 1 && firstTime) {
        			//going through initialize application
        			int labOneCap = 0;
        			String labOneLoc = "";
        			int labTwoCap = 0;
        			String labTwoLoc = "";
        			int labThreeCap = 0;
        			String labThreeLoc = "";
        			
        			System.out.println(enterLabCapacity + "1");
        			labOneCap = scan.nextInt();
        			scan.nextLine();
        			System.out.println(enterLabLocation + "1");
        			labOneLoc = scan.nextLine();
        			
        			System.out.println(enterLabCapacity + "2");
        			labTwoCap = scan.nextInt();
        			scan.nextLine();
        			System.out.println(enterLabLocation + "2");
        			labTwoLoc = scan.nextLine();
        			
        			System.out.println(enterLabCapacity + "3");
        			labThreeCap = scan.nextInt();
        			scan.nextLine();
        			System.out.println(enterLabLocation + "3");
        			labThreeLoc = scan.nextLine();
        			
        			labOne = new Lab(labOneCap, labOneLoc);
        			labTwo = new Lab(labTwoCap, labTwoLoc);
        			labThree = new Lab(labThreeCap, labThreeLoc);
        			manager = new LabManager(labOne, labTwo, labThree);
        			firstTime = false;
        			menuAnswer = 0;
        		} else if (menuAnswer == 2 && firstTime) { 
        			//initial menu exit
        			break;
        		}
    		} else { 
    			do { 
    				System.out.println(ongoingMenu);
    				menuAnswer = scan.nextInt();
    				scan.nextLine();
    				if (menuAnswer != 1 && menuAnswer != 2 && 
    				    menuAnswer != 3 && menuAnswer != 4 && 
    				    menuAnswer != 5 && menuAnswer != 6 && 
    				    menuAnswer != 7 && menuAnswer != 8) 
    					System.out.println(invalidInput);
    			} while (menuAnswer != 1 && menuAnswer != 2 && 
    					menuAnswer != 3 && menuAnswer != 4 && 
    				    menuAnswer != 5 && menuAnswer != 6 && 
    				    menuAnswer != 7 && menuAnswer != 8);
    		}
    		//menu choice has been picked
    		if (menuAnswer == 1) { 
    			//view current lab schedule
    			System.out.println(labOne.toString());
    			System.out.println(labTwo.toString());
    			System.out.println(labThree.toString());
    		} else if (menuAnswer == 2) { 
    			//list labs by availability
    			System.out.println(manager.listAvailableLabs());
    		} else if (menuAnswer == 3) { 
    			//list labs by reservation
    			System.out.println(manager.listReservedLabs());
    		} else if (menuAnswer == 4) { 
    			//add reservation
    			System.out.println(labLocationPrompt);
    			String loc = scan.nextLine();
    			System.out.println(reservationTimePrompt);
    			String time = scan.nextLine();
    			System.out.println(reservationNamePrompt);
    			String name = scan.nextLine();
    			System.out.println(reservationEnrollmentPrompt);
    			int enrol = scan.nextInt();
    			
    			System.out.println(manager.addReservation(loc, time, name, enrol));
    		} else if (menuAnswer == 5) { 
    			//remove a reservation
    			System.out.println(labLocationPrompt);
    			String loc = scan.nextLine();
    			System.out.println(reservationTimePrompt);
    			String time = scan.nextLine();
    			
    			System.out.println(manager.removeReservation(loc, time));
    		} else if (menuAnswer == 6) { 
    			//modify a reservation
    			System.out.println(labLocationPrompt);
    			String loc = scan.nextLine();
    			System.out.println(reservationTimePrompt);
    			String time = scan.nextLine();
    			System.out.println(reservationNameUpdate);
    			String updateName = scan.nextLine();
    			System.out.println(reservationEnrollmentUpdate);
    			int updateEnrol = scan.nextInt();
    			
    			System.out.println(manager.modifyReservation(loc, time, updateName, updateEnrol));
    		} else if (menuAnswer == 7) { 
    			//calculate statistics
    			int menuSevenAnswer;
    			do { 
    				System.out.println(statisticsMenu);
    				menuSevenAnswer = scan.nextInt();
    				if (menuSevenAnswer != 1 && menuSevenAnswer != 2 && menuSevenAnswer != 3 && menuSevenAnswer != 4) { 
    					System.out.println(invalidInput);
    				} else if (menuSevenAnswer == 1) { 
    					//total capacity
        				System.out.println(totalCapacity + manager.calculateTotalCapacity());
        			} else if (menuSevenAnswer == 2) { 
        				//total utilization
        				System.out.println(totalUtilization + 
                                           String.format("%.2f", manager.calculateTotalUtilization()));
        			} else if (menuSevenAnswer == 3) { 
        				//available seats
        				System.out.println(availableSeats + manager.calculateAvailableSeats());
        			}
    			} while (menuSevenAnswer != 4);
    			
    			
    		} else if (menuAnswer == 8) { 
    			//exit
    			break;
    		}
    		
    	} while (restart);
    	
    	System.out.println(exitMessage);
    }
    
}