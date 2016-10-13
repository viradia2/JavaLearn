import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Shortpath {
	
	 private static int[][] matrix;
	    
	    private static int startingVertex = 0, m = 0;
	    
	    public Shortpath(int[][] matrix, int startingVertex, int m) {
			this.matrix = matrix;
			this.startingVertex = startingVertex;
			this.m= m;
		}
	
	public void dijkstra(int matrix[][], int startingVertex)
	    {
			
			int[] vertex = new int[m] ;
			int path[] = new int[m];
			int u;
	        int dist[] = new int[m]; //Distance Array
	        int prev[] = new int[m];
 	        Queue<Integer> Q = new LinkedList<Integer>();
       
	        for (int i = 0; i < m; i++)
	        {
	        	path[0] = -1;
	            dist[i] = Integer.MAX_VALUE;
	            prev[i] = 0;
	            Q.offer(i);
	        }
	 
	        dist[startingVertex] = 0;
	        
	        while(!Q.isEmpty()){
	        	
	        	// get first node from Q
	        	//u = Q.peek();
	        	
	        	// remove u from Q
	        	u = Q.remove();
	        	
	        	Iterator<Integer> vIterator = findAllNeighbours(u);
	        	while(vIterator.hasNext()){
	        		int v = vIterator.next();
	        		
	        		int alt = 0;
	        		
	        		if(u<v)
	        			alt = ((dist[u]==Integer.MAX_VALUE)?0:dist[u]) + length(u,v);
	        		else
	        			alt = ((dist[u]==Integer.MAX_VALUE)?0:dist[u]) + length(v,u);
	        		
	        		if(alt<dist[v]){
	        			path[v] = u;
	        			dist[v] = alt;
	        			prev[v] = u;
	        		}
	        		
	        		if(u<v){
		        		// don't change value 
		        		if(length(u, v)==0)
		        			dist[v]=Integer.MAX_VALUE;
	        		}else{
	        			// don't change value 
		        		if(length(v, u)==0)
		        			dist[v]=Integer.MAX_VALUE;
	        		}
	        	}
	        }
	        
	        printSoultion(dist, m, path, startingVertex);
	    }

	private Iterator<Integer> findAllNeighbours(int vertex){
		List<Integer> list = new LinkedList<>();
		
		for(int i=0;i<m;i++){
			if(vertex < i){
				if(matrix[vertex][i] != 0){
					list.add(i);
				}
			}else {
				if(matrix[i][vertex] != 0){
					list.add(i);
				}
			}
		}
		
		return list.iterator();
	}
	
	private void printSoultion(int[] dist, int m2, int[] path,int startingVertex) {
		// TODO Auto-generated method stub
		 System.out.println("Vertex, Distance and Path from Source");
	        for (int i = 0; i < m; i++){
	        	System.out.println("");
	            System.out.printf("%d---->%d---->%d---->%d,",startingVertex,i,dist[i],startingVertex);
	            printPath(path, i);
	        }
	          
		
	}
	
	 void printPath(int path[], int p)
	    {
	        if(path[p] == -1 ){
	        	return;
	        }
	           	printPath(path, path[p]);
	        	System.out.printf("%d,", p);

	    }

	private int length(int u, int v) {
		return matrix[u][v];
	}

}
