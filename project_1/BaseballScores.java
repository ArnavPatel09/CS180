package project_1;

import java.util.Scanner;

/**
 * Purdue University -- CS18000 -- Fall 2021 -- Project 01 --
 *
 * This project is a program that takes 2 teams and a string of scores and 
 * computes who won, the score difference, the amount each team scored,
 * which team won each inning, and the number of perfect innings for both teams
 * 
 * 
 * @author Arnav Patel
 * @version September 26, 2021
 */
public class BaseballScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter Team One Name:");
        String teamOne = scanner.nextLine();
        System.out.println("Enter Team Two Name:");
        String teamTwo = scanner.nextLine();
        System.out.println("Enter Inning Scores:");
        String scores = scanner.nextLine();


        scanner.close();

        // The scores for each inning are calculated and stored in the variables below. 
        int currentScoreIndex = 0;
        int teamOneInningOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));


        currentScoreIndex += 3;
        int teamOneInningNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        // finding the final score of the game
        int teamOneScore = teamOneInningOne + teamOneInningTwo + teamOneInningThree
        		+ teamOneInningFour + teamOneInningFive + teamOneInningSix + teamOneInningSeven
        		+ teamOneInningEight + teamOneInningNine;
        int teamTwoScore = teamTwoInningOne + teamTwoInningTwo + teamTwoInningThree
        		+ teamTwoInningFour + teamTwoInningFive + teamTwoInningSix + teamTwoInningSeven
        		+ teamTwoInningEight + teamTwoInningNine;
        if (teamOneScore > teamTwoScore)
        	System.out.println("The winner is: " + teamOne + ", with a score differential of "
        			+ (teamOneScore - teamTwoScore));
        else
        	System.out.println("The winner is: " + teamTwo + ", with a score differential of "
        			+ (teamTwoScore - teamOneScore));
        
        // printing how many runs each team got
        System.out.println(teamOne + " scored " + teamOneScore + " points.");
        System.out.println(teamTwo + " scored " + teamTwoScore + " points.");
        
        // looping through each inning to see which team won/lost & check for perfect innings
        // making an array instead of using IntegerParse or using many if statements
        String teamOneLog = teamOne + " Game Log: ";
        String teamTwoLog = teamTwo + " Game Log: ";
        int teamOnePerfect = 0;
        int teamTwoPerfect = 0;
        
        int [] teamOneArray = {teamOneInningOne, teamOneInningTwo, teamOneInningThree,
        		teamOneInningFour, teamOneInningFive, teamOneInningSix, teamOneInningSeven,
        		teamOneInningEight, teamOneInningNine};
        int [] teamTwoArray = {teamTwoInningOne, teamTwoInningTwo, teamTwoInningThree,
        		teamTwoInningFour, teamTwoInningFive, teamTwoInningSix, teamTwoInningSeven,
        		teamTwoInningEight, teamTwoInningNine};
        
        for (int i = 0; i < 9; i++) { 
	        if (teamOneArray[i] > teamTwoArray[i]) { 
	        	teamOneLog += "W-";
	        	teamTwoLog += "L-";
	       		if(teamTwoArray[i] == 0)
	       			teamOnePerfect += 1;
	       	}
	       	else if (teamOneArray[i] < teamTwoArray[i]) { 
	       		teamOneLog += "L-";
	       		teamTwoLog += "W-";
	       		if(teamOneArray[i] == 0)
	       			teamTwoPerfect += 1;
        	}	        	
	       	else { 
	       		teamOneLog += "T-";
	       		teamTwoLog += "T-";
	       	}
        }
        // get rid of the last dash
        teamOneLog = teamOneLog.substring(0, teamOneLog.length()-1);
        teamTwoLog = teamTwoLog.substring(0, teamTwoLog.length()-1);
        
        //printing out the Game Log and Perfect Innings
        System.out.println(teamOneLog);
        System.out.println(teamTwoLog);
        System.out.println(teamOne + " Perfect Innnings: " + teamOnePerfect);
        System.out.println(teamTwo + " Perfect Innings: " + teamTwoPerfect);
        System.out.println();
    }
}
