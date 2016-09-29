import java.io.FileNotFoundException;
import java.io.IOException;

public class driver {
	
	public static void main(String[] args){
		
		System.out.println("Start");
		
		testing t = new testing("C:\\Users\\vvviradia\\workspace\\620 Assignement 2\\src\\Maze.txt");
		try {
			t.fileReader();
			t.mazeSolving();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
				