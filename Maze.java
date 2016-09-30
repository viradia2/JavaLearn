import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
	/* Store the structure of the Maze. */
	private static char[][] maze = null;
	
	private static int m = 0, n = 0;
	
	/* Object of the MazePathFinder class. */
	private static MazePathFinder mazePathFinder;
	
	/*
	 * Main method.
	 */
	public static void main(String[] args) {
		// Scanner to read from the console.
		Scanner consoleScanner = new Scanner(System.in);
		// Scanner to read from the file.
		Scanner fileScanner = null;
		
		System.out.print("Enter the file containing the maze: ");
		String inputFileName = consoleScanner.nextLine();
		
		/*
		 * Try block.
		 */
		try {
			File inputFile = new File(inputFileName);
			fileScanner = new Scanner(inputFile);
			
			// Read the no. of rows and columns.
			if(fileScanner.hasNextInt())
				m = fileScanner.nextInt();
			if(fileScanner.hasNextInt())
				n = fileScanner.nextInt();
			
			System.out.println("Your maze has " + m + " rows and " + n + " columns");
			
			// Initiate the maze.
			maze = new char[m][n];
			for(int i = 0; i < m; i++) {
				if(fileScanner.hasNext())
					maze[i] = fileScanner.next().toCharArray();
			}
			
			mazePathFinder = new MazePathFinder(maze, m, n);
			
			mazePathFinder.runMazePathFinder();
		}
		/*
		 * Catch block.
		 */
		catch(FileNotFoundException fileNotFoundException) {
			System.out.println("File not found.");
		}
		/*
		 * Catch block.
		 */
		catch(Exception exception) {
			System.out.println("Exception occured: ");
			exception.printStackTrace();
		}
		/*
		 * Finally block.
		 */
		finally {
			if(consoleScanner != null)	consoleScanner.close();
			if(fileScanner != null)	fileScanner.close();
		}
	}
}