import java.util.Stack;

public class Solution {

	private Stack solution;
	private Stack steps;
	
	public Solution(){
		
		solution = new Stack();
	}
	
	public void buildSteps(){
		
		steps = new Stack();
		Stack tempSolution = new Stack();
		tempSolution = solution;
		
		while(!solution.isEmpty()){
			
			steps.push(solution.pop());
			
		}
	}
	
		
	public Coordinate pop(){
		
		return (Coordinate) solution.pop();
	}
	
	public Coordinate peek(){
		
		return (Coordinate) solution.peek();
	}
	
	public Stack getSteps(){
		
		return steps;
	}

	public void push(Coordinate c) {
		// TODO Auto-generated method stub
		solution.push(c);
	}
}
