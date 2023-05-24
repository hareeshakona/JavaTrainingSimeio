package com.simeio.fun;

import java.util.Scanner;

public class CalLambdaDemo {

	public static void main(String[] args) {
		
		System.out.println("Enter option"+"\n"
							+" 1 - Add"+"\n"
							+ "2 - Subtract"+"\n"
							+ "3 - Multiply"+"\n"
							+ "4 - Divide");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		ICalculator calc = null;
		
		switch(option) {
		
		case 1 : {
			calc = (x,y)-> {
				return (x+y);
			};
			System.out.println("Addition -"+calc.calculate(10, 20));	
			break;
		}
		case 2 : {
			calc = (x,y)-> {
				return (x-y);
			};
			System.out.println(calc.calculate(10, 20));	
			break;
		}
		default : {
			
		}
			
		}
		
		
		sc.close();
		
	}

}
