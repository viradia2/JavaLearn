package com.Method;

public class NewtonMethod {
	
	private static final double EPSILON = 0.000001;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double x0=15;
		
		System.out.printf("The root by Newton's Method is: %.4f",newton(x0,EPSILON));

	}
	
	private static double newton(double x0, double epsilon2) {
		// TODO Auto-generated method stub
		
		int i=0;
		double x1;
		
		System.out.printf("Step: %d x: %f f(x):%f\n",i,x0,f(x0));
		
		if(Math.abs(f(x0)) == 0)
			return x0;
				
		while(Math.abs(f(x0)) > EPSILON){
			
			i++;
			x1 = x0 - (f(x0)/prime(x0));
			System.out.printf("Step: %d x: %f f(x): %f \n",i,x1,f(x1));
			x0 = x1;
		}
		return x0;
	}

	private static double f(double x){
		
		return 30 + 25 * x - 4 * Math.pow(x, 2) + 0.15 * Math.pow(x, 3);
	}
	
	private static double prime(double x){
		
		return 25 - 8 * x + 0.15 * 3 * Math.pow(x, 2);
	}

}
