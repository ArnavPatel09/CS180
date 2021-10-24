package homework_5;

import java.util.Random;
import java.util.Scanner;

public class AutonomousRacecar {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int speed = 0;
        int seedValue;
        int current;
        int threshold;

        System.out.println("Please enter the seed for the random number generator:");
        seedValue = scan.nextInt();

        System.out.println("Please enter the threshold:");
        threshold = scan.nextInt();

        Random random = new Random(seedValue);

        System.out.println("Starting the car...");
        System.out.print("Current speed: ");

        do {
        	speed+=5;
        	current = random.nextInt((threshold * 10)) + 1 ;
        	System.out.print(speed + "...");
        } while(current>threshold);
        System.out.print("Done!");

        System.out.println("\nMaximum run speed: "  + speed);

    }
}
