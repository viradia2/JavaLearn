import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class testing {
	
		
	private String fileName = "";
	//final static String OPEN = "*";
	//final static String WALL = "#";
	//final static String GOAL = "G";
	//final static String VISITED = "P";
	private static char[][] maze = null;
	private static int rows = 0;
	private static int cols = 0;
	private static int xStart = 0;
	private static int yStart = 0;
	private Coordinate startCoordinate;
	private int[][] mazeArray;
	private int numRows;
	private int numCols;
	private boolean isSolved;
	private Solution solution;
	private Stack steps;
	
	public testing(String InputFile){
		
		fileName = InputFile;
		isSolved = false;
		solution = new Solution();
	}

	//public void fileReader(){
		
	
		
	//}
//
/*
	public void Maze() throws IOException
	{
	    File InputFile = new File ("C:\\620 Assignment 2\\Maze.txt");
	    BufferedReader reader = new BufferedReader(new FileReader(InputFile));

	    Scanner lineOfFile = new Scanner(reader.readLine());

	    rows = lineOfFile.nextInt(); //get the number of rows of the maze
	    cols = lineOfFile.nextInt(); // get the number of columns of the maze
	    maze = new char[rows][cols]; //create a char array of the proper size

	    //For loops to iterate the rows and col to find the start/enterance of the maze as it pertains to the first char in the row
	    for (int y = 0; y < cols; y ++)
	    {
	        lineOfFile = new Scanner(reader.readLine());
	        for(int x = 0; x < rows; x++)
	        {
	            char start = lineOfFile.next().charAt(0);
	            maze[x][y] = start;

	            //statement to set the starting coorinates for the maze
	            if (start == '.')
	            {
	                xStart = x;
	                yStart = y;
	            }

	        }
	    }
	}
*/
	
	public void mazeSolving(){
		
		Coordinate current = new Coordinate(0,0);
		current = startCoordinate;
		solution.push(current);
		Coordinate retrived = new Coordinate(0,0);
		
		while(!isSolved){
			
			retrived = FindNorth(current);
			if(!(checkSameSpot(retrived, current))){
				
				mazeArray[current.getRow()][current.getCol()] = 1;
				current = retrived;
				solution.push(current);
				isSolved = checkFinished(current);
				continue;
			}
			retrived = FindEast(current);
			if(!(checkSameSpot(retrived, current))){
				
				mazeArray[current.getRow()][current.getCol()] = 1;
				current = retrived;
				solution.push(current);
				isSolved = checkFinished(current);
				continue;
			}
			retrived = FindSouth(current);
			if(!(checkSameSpot(retrived, current))){
				
				mazeArray[current.getRow()][current.getCol()] = 1;
				current = retrived;
				solution.push(current);
				isSolved = checkFinished(current);
				continue;
			}
			retrived = FindWest(current);
			if(!(checkSameSpot(retrived, current))){
				
				mazeArray[current.getRow()][current.getCol()] = 1;
				current = retrived;
				solution.push(current);
				isSolved = checkFinished(current);
				continue;
			}
			
			//spot wiil be the same if we are here
			mazeArray[current.getRow()][current.getCol()] = 2;
			solution.pop();
			current = solution.peek();
			isSolved = checkFinished(current);
		}
		solution.buildSteps();
		steps = solution.getSteps();
	}
	
		
	private Coordinate FindNorth(Coordinate c){
		
		if((c.getRow() - 1) < 0){
			return c;
		}
		else{
			Coordinate spot = new Coordinate(c.getRow() - 1, c.getCol());
			if(checkSafe(spot))	
				return spot;
			else
				return c;
		}
	}
	
	private Coordinate FindEast(Coordinate c){
		
		if((c.getCol() + 1) == numCols){
			return c;
		}
		else{
			Coordinate spot = new Coordinate(c.getRow(), c.getCol() + 1);
			if(checkSafe(spot))	
				return spot;
			else
				return c;
		}
	}

	private Coordinate FindSouth(Coordinate c){
	
		if((c.getRow() + 1) == numRows){
			return c;
		}
		else{
			Coordinate spot = new Coordinate(c.getRow() + 1, c.getCol());
			if(checkSafe(spot))	
				return spot;
			else
				return c;
		}
	}

	private Coordinate FindWest(Coordinate c){
	
		if((c.getCol() - 1) < 0){
			return c;
		}
		else{
			Coordinate spot = new Coordinate(c.getRow(), c.getCol() - 1);
			if(checkSafe(spot))	
				return spot;
			else
				return c;
		}
	}
	
	private boolean checkSafe(Coordinate c){
		if(mazeArray[c.getRow()][c.getCol()] == 0)
			return true;
		else 
			return false;
	}
	
	private boolean checkSameSpot(Coordinate a, Coordinate b){
		
		if((a.getRow()==b.getRow()) && (a.getCol()==b.getCol()))
			return true;		
		else
			return false;
		
	}

	private boolean checkFinished(Coordinate c){
		
		if(checkSameSpot(c, startCoordinate))
			return false;
		else{
			if(c.getCol() == 0 || c.getCol() == (numCols - 1)){
				return true;
			}
			if(c.getRow() == 0 || c.getRow() == (numRows - 1)){
				return true;
			}
		}
		return false;
	}

	public void fileReader() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	/*	 Scanner myScanner = new Scanner(new File("C:\\620 Assignment 2\\Maze.txt"));
         int numRows = myScanner.nextInt();
         System.out.println(numRows);
         int numCols = myScanner.nextInt();
         myScanner.nextLine();

         int startX = 0;
         int startY = 0;

         // New maze
         char[][] maze = new char[numRows][numCols];

         for (int i = 0; i < numRows; i++) {
             String nextLine = myScanner.nextLine();
             for (int j = 0; j < numCols; j++) {
                 char nextChar = nextLine.charAt(j);
                 maze[i][j] = nextChar;
                 System.out.print(nextChar);
            }
             System.out.println();
         }
		
         for (int i = 0; i < numRows; i++) {
             for (int j = 0; j < numCols; j++) {
                 if (maze[i][j] == 'S') {
                     System.out.println("Starting coordinates: "+ i + ", " + j);
                     startX = i;
                     startY = j;
                 }
             }
         }
         
         Coordinate startCoordinate = new Coordinate(startX,startY);
		*/
		String lineBuffer = "";
		String[] mazeLineBuffer;
		int lineCounter = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			lineBuffer = br.readLine();
			mazeLineBuffer = lineBuffer.split(" ");
			numRows = Integer.parseInt(mazeLineBuffer[0]);
			numCols = Integer.parseInt(mazeLineBuffer[0]);
			
			mazeArray = new int[numRows][numCols];
			
			while(br.ready()){
				
				lineBuffer = br.readLine();
				mazeLineBuffer = lineBuffer.split(" ");
				
				if(lineCounter < numRows){
				for(int i = 0; i < mazeLineBuffer.length; i++){
					
					mazeArray[lineCounter][i] = Integer.parseInt(mazeLineBuffer[i]);
					System.out.println(mazeArray[lineCounter][i]);
				}
				}else if(lineCounter == numRows){
					startCoordinate = new Coordinate(Integer.parseInt(mazeLineBuffer[0]),Integer.parseInt(mazeLineBuffer[1]));
				}
				lineCounter++;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

