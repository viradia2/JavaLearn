import java.util.LinkedList;

public class MazePathFinder {
	/* Store the structure of the Maze. */
	private static char[][] maze = null;
	
	private static int m = 0, n = 0;
	
	private static int startX = 0, startY = 0, goalX = 0, goalY = 0;
	
	private static boolean foundGoal = false;
	
	private static LinkedList<String> reversePath = new LinkedList<String>();
	
	private static String path;
	
	/*
	 * Constructor.
	 */
	@SuppressWarnings("static-access")
	public MazePathFinder(char[][] maze, int m, int n) {
		this.maze = maze;
		this.m = m;
		this.n= n;
	}
	
	/*
	 * This is a public method which will be called from outside of the class.
	 * This method runs the main flow of the approach.
	 */
	public void runMazePathFinder() {
		/* Call printMaze() method to print the input maze. */
		printMaze(maze);
		
		/* Call findStartAndGoal() method to find coordinates of start and goal. */
		findStartAndGoal(maze);
		
		/* Call findPath() method to find path. */
		findPath(startX, startY);
		
		/* Remark the coordinates of the start with 'S'. */
		maze[startX][startY] = 'S';
		System.out.println("==========");
		
		/* If found the goal. */
		if(foundGoal) {
			/* Print the solution and the path */
			
			System.out.println("\nSolution:");
			printMaze(maze);
			
			path = tracePath(reversePath);
			System.out.println("\nPath: " + path);
		}
		else {
			System.out.println("\nThere is no path from Start to Goal.");
		}
	}
	
	/*
	 * This method finds the path in a maze.
	 * It is a recursive method.
	 */
	private boolean findPath(int x, int y) {
		/* Outside maze */
		if(x<0 || x>m-1 || y<0 || y>n-1)
			return false;
		/* Goal */
		if(x==goalX && y==goalY) {
			foundGoal = true;
			reversePath.add(x + "," + y);
			return true;
		}
		/* Not open */
		if(maze[x][y] == '#')
			return false;
		/* Already checked */
		if(maze[x][y] == 'P')
			return false;
		
		/* Mark it */
		maze[x][y] = 'P';
		System.out.println("==========");
		/* Print the maze. */
		printMaze(maze);
		
		/* Check North */
		if(findPath(x-1, y)) {
			reversePath.add(x + "," + y);
			return true;
		}
		/* Check East */
		if(findPath(x, y+1)) {
			reversePath.add(x + "," + y);
			return true;
		}
		/* Check South */
		if(findPath(x+1, y)) {
			reversePath.add(x + "," + y);
			return true;
		}
		/* Check West */
		if(findPath(x, y-1)) {
			reversePath.add(x + "," + y);
			return true;
		}
		
		/* Unmark it */
		maze[x][y] = '?';
		System.out.println("==========");
		printMaze(maze);
		
		return false;
	}
	
	/*
	 * It traces the path from the start to the goal.
	 */
	private String tracePath(LinkedList<String> reversePath) {
		StringBuffer sb = new StringBuffer();
		String[] xAndY;
		
		for(int i = reversePath.size()-1; i >= 0; i--) {
			xAndY = reversePath.get(i).split(",");
			sb.append("Node[" + xAndY[0] + "][" + xAndY[1] + "]" + " --> ");
		}
		sb = new StringBuffer(sb.subSequence(0, sb.length() - 5));
		
		return sb.toString();
	}
	
	/*
	 * It finds the coordinates of start and goal.
	 */
	private void findStartAndGoal(char[][] maze) {
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length; j++) {			
				if(maze[i][j] == 'S') {
					startX = i;	startY = j;	}
				if(maze[i][j] == 'G') {
					goalX = i;	goalY = j;	}
			}
		}
	}
	
	/*
	 * It prints the maze.
	 */
	private void printMaze(char[][] maze) {
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.print("\n");
		}
	}
}