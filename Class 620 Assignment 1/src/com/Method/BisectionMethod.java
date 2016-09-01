package com.Method;

public class BisectionMethod {

	private static final double EPSILON = 0.000001;
	
	public static void main(String[] args) {
		
		double a=0, b=100;
					
		System.out.printf("The root by Bisetction Method is: %.4f",bisection(a,b,EPSILON));
		
	}

	public static double bisection(double a, double b, double ePSILON) {
		// TODO Auto-generated method stub
		int i=0;
		double mid = (a+b)/2;
		
		if(f(a) == 0)
			return 0;
		
		if(f(b) == 0)
			return 0;
		
		if(Math.abs(f(mid))<EPSILON)
			return mid;
		
		while(Math.abs(f(mid)) > EPSILON){
			
			System.out.printf("Step: %2d a:%.4f  b:%.4f  mid:%.4f  f(mid):%.4f \n ",i,a,b,mid,f(mid));
			
			if(f(a) * f(mid) < 0)
				b = mid;
			else 
				a = mid; 
			
			mid = (a + b)/2;
			i++;
	
		}
		
		return mid;
		
	}
	
	private static double f(double x){
		
		return 30 + 25 * x - 4 * Math.pow(x, 2) + 0.15 * Math.pow(x, 3);
	}
	
}
