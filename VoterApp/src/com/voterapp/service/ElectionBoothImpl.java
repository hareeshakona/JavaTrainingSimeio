package com.voterapp.service;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIDException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth {

	String[] localities = { "Brookefiled", "Sarjapura Road", "Marathahalli", "KRPuram", "Bannerghatta" };

	@Override
	public boolean checkEligibility(int age, String locality, int voterid) throws InValidVoterException {

		if (checkAge(age)) {
			if (checkLocality(locality)) {
				if (checkVoterId(voterid)) {
					return true;
				} else
					throw new NoVoterIDException("Voter ID doesn't exist");
			} else
				throw new LocalityNotFoundException("No such locality");
		} else
			throw new UnderAgeException("Age should be minimum 18 years");
	}

	private boolean checkAge(int age) {

		return (age < 18) ? false : true;

	}

	private boolean checkLocality(String locality) {

		for (String area : localities) {
			if (area.equals(locality))
				return true;
		}

		return false;

	}

	private boolean checkVoterId(int voterid) {

		return ((voterid >= 1000) && (voterid <= 9999)) ? true : false;

	}

}
