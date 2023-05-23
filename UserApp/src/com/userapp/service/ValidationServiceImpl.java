package com.userapp.service;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public class ValidationServiceImpl implements IValidationService {

	@Override
	public boolean validateUsername(String username) throws NameExistsException {

		String[] usernames = { "Jacob", "Riya", "Mira", "John", "Ravi" };
		for (String name : usernames) {
			if (name.equals(username))
				throw new NameExistsException("Username exists");
		}
		return true;
	}

	@Override
	public boolean validatePassword(String password) throws TooShortException, TooLongException {
		if (password.length() < 6)
			throw new TooShortException("Password is too short");
		else if (password.length() > 15)
			throw new TooLongException("Password is too long");
		else
			return true;
	}

}
