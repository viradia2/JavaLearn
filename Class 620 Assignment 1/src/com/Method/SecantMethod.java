package com.Method;

public class SecantMethod {

	private static final double EPSILON = 0.000001;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double x0=0,x1=100;
		
		System.out.printf("The root by Secant Method is %5.4f",secant(x0,x1,EPSILON));
		
	}

	private static double secant(double x0, double x1, double epsilon2) {
		// TODO Auto-generated method stub
		double x2 = 0;
		int i = 0;
		
		if(Math.abs(f(x0)) < EPSILON)
			return x0;
		if(Math.abs(f(x1)) < EPSILON)
			return x1;
		if(Math.abs(f(x2)) < EPSILON)
			return x2;
		
		
		while(Math.abs(f(x2)) > EPSILON){
			
			x2 = ((x0 * f(x1)) - (x1 * f(x0)))/(f(x1)-f(x0));
			System.out.printf("Step: %d x0: %5.4f x1: %5.4f x2: %5.4f \n",i,f(x0),f(x1),x2);
			
			x0 = x1;
			x1 = x2;				
			i++;
		}
		
			
		return x2;
	}
	
	private static double f(double x){
		return Math.pow(x, 2) - 5 ;
		
	}

}
