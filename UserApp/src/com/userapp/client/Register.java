package com.userapp.client;

import java.util.Scanner;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;
import com.userapp.service.IValidationService;
import com.userapp.service.ValidationServiceImpl;

public class Register {

	public static void main(String[] args) {

		IValidationService ivalidationService = new ValidationServiceImpl();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name to register :");
		String name = sc.nextLine();

		try {
			if (ivalidationService.validateUsername(name)) {
				System.out.println("Enter password :");
				String password = sc.nextLine();
				if (ivalidationService.validatePassword(password))
					System.out.println("Welcome " + name);
			}
		} catch (NameExistsException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (TooLongException | TooShortException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		sc.close();
	}
}
