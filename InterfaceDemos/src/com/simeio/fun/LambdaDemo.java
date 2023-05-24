package com.simeio.fun;

public class LambdaDemo {

	public static void main(String[] args) {
		
		IGames blockgames = ()->{
			System.out.println("block games");
		};
		blockgames.createApps();		
		
		IGames simulationgames = ()->{
			System.out.println("simulation games");
			
		};
		simulationgames.createApps();
		
		IGreeter greet = (username)-> {
			return ("welcome "+username);
		};
		System.out.println(greet.greetMessage("Hareesha"));		
		
		
		greet = (username)-> {
			return ("Hello "+username);
		};
		
		System.out.println(greet.greetMessage("Hareesha"));
		
		
		ICalculator calculator = (x,y)-> {
			return (x+y);
		};
		System.out.println("Sum is "+calculator.calculate(25, 35));
		
		calculator = (x,y)-> {
			return (x-y);
		};
		System.out.println("Difference is "+calculator.calculate(50, 30));
		
		calculator = (x,y)-> {
			return (x*y);
		};
		System.out.println("Product is "+calculator.calculate(25, 5));
		
		calculator = (x,y)-> {
			return (x/y);
		};
		System.out.println("Division is "+calculator.calculate(50, 10));
			
		
		
	}
	
	
}
