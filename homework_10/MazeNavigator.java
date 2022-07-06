package homework_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * 
 * Homework 10 Challenge -- MazeNavigator
 *
 * This class will process a file input to navigate a maze for users.
 * The fields in this class include: currentRow, currentColumn, moveNumber,
 * started, maze, playerNumber, fileName, and SYNC.
 * The methods in this class include: a constructor with 2 parameters,
 * createMaze, updateMaze, printMaze, and run.
 * 
 * 
 * @author Arnav Patel, L12
 * @version November 3, 2021
 */

public class MazeNavigator extends Thread {
	private static int currentRow;
	private static int currentColumn;
	private static int moveNumber;
	private static boolean started;
	private static char[][] maze;
	private int playerNumber;
	private String fileName;
	private static final Object SYNC = new Object();
	
	
	public MazeNavigator(int playerNumber, String fileName) { 
		this.playerNumber = playerNumber;
		this.fileName = fileName;
		currentRow = 4;
		currentColumn = 4;
		moveNumber = 1;
		started = false;
		maze = new char [10][10];
		maze = createMaze();
	}
	
	public char[][] createMaze() { 
		//creates the maze with all spaces
		for (int i = 0; i < maze.length; i++) { 
			for (int j = 0; j < maze[i].length; j++) { 
				maze[i][j] = ' ';
			}
		}
		//replaces a space for the character X
		maze[currentRow][currentColumn] = 'X';
		
		return maze;
	}
	
	public void updateMaze() { 
		//if the user goes out of the boundaries they will teleport to the opposite to other side
		if (currentRow == -1) {
			currentRow = 9;
		} else if (currentRow == 10) { 
			currentRow = 0;
		} else if (currentColumn == -1) { 
			currentColumn = 9;
		} else if (currentColumn == 10) {
			 currentColumn = 0;
		}
		//updates the board
		createMaze();
		
	}
	
	public void printMaze() { 
		//adds the entire board onto the string
		String s = "";
		for (int i = 0; i < maze.length; i++) { 
			s += "[";
			for (int j = 0; j < maze[i].length; j++) { 
				s += String.valueOf(maze[i][j]) + ",";
			}
			s = s.substring(0,s.length()-1);
			s += "]\n";
		}
		//prints the string
		System.out.println(s);
	}
	
	
	public void run() {
		synchronized (SYNC) { 
			//makes sure this part is only run once
			if (!started) { 
				System.out.println("Welcome! Initial Maze:");
				started = true;
				printMaze();
			}
		}
		
		try {
			File fileT = new File(fileName);
			Scanner fileTwo = new Scanner(fileT);
			//checks if the file has lines left to read
			while (fileTwo.hasNextLine()) {
				//if so, it will read the line and then update the board accordingly
				String line = fileTwo.nextLine();

				synchronized (SYNC) { 
					if (line.equals("1")) {
						System.out.println("Move Number: " + moveNumber);
						System.out.println("Player: " + playerNumber);
						System.out.println("Move: Left");
						moveNumber++;
						//moves the character 'X' to the left
						currentColumn--;
						updateMaze();
						printMaze();
					} else if (line.equals("2")) { 
						System.out.println("Move Number: " + moveNumber);
						System.out.println("Player: " + playerNumber);
						System.out.println("Move: Right");
						moveNumber++;
						//moves the character 'X' to the right
						currentColumn++;
						updateMaze();
						printMaze();
					} else if (line.equals("3")) {
						System.out.println("Move Number: " + moveNumber);
						System.out.println("Player: " + playerNumber);
						System.out.println("Move: Up");
						moveNumber++;
						//moves the character 'X' up
						currentRow--;
						updateMaze();
						printMaze();
					} else if (line.equals("4")) { 
						System.out.println("Move Number: " + moveNumber);
						System.out.println("Player: " + playerNumber);
						System.out.println("Move: Down");
						moveNumber++;
						//moves the character 'X' down
						currentRow++;
						updateMaze();
						printMaze();
					} else { 
						System.out.println("Error, invalid input!");
					}
				}
			}
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (NullPointerException e) { 
			e.printStackTrace();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	
}