package com.Method;


public class BisectionMethod {

	private static final double EPSILON = 0;
	//private static double EXIT_SUCCESS;

	public static void main(String[] args) {
		
		double a=0, b=100;
		//final double EPSILON = 0.00001;
		
		System.out.printf("The root is:",bisection(a,b,EPSILON));
		//return(EXIT_SUCCESS);
	}

	public static double bisection(double a, double b, double ePSILON) {
		// TODO Auto-generated method stub
		int i=0;
		double mid = (a+b)/2;
		
		if(f(a) == 0)
			return 0;
		
		if(f(b) == 0)
			return 0;
		
		if(f(mid)<EPSILON)
			return mid;
		
		while(f(mid)>EPSILON){
			System.out.printf("Step: %2i a:%7.41f  b:%7.41f  mid:%7.41f  f(mid):%7.41f\n ",i,a,b,mid,f(mid));
			
			if(f(a)*f(b) < 0)
				b = mid;
			else 
				a = mid;
			
			mid = (a+b)/2;
			i++;
	
		}
		return mid;
		
	}
	
	private static double f(double x){
		
		return Math.pow(x, 2)-5;
	}
	
}
