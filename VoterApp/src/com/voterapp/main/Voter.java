package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.service.ElectionBoothImpl;
import com.voterapp.service.IElectionBooth;

public class Voter {

	public static void main(String[] args) {

		IElectionBooth ielectionbooth = new ElectionBoothImpl();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter age :");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter locality :");
		String locality = sc.nextLine();
		System.out.println("Enter voter ID :");
		int voterid = sc.nextInt();
		sc.nextLine();

		try {
			if (ielectionbooth.checkEligibility(age, locality, voterid))
				System.out.println("All details valid. You can cast your vote");
		} catch (InValidVoterException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		sc.close();
	}

}
