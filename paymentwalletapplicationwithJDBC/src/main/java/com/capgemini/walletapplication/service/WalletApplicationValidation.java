package com.capgemini.walletapplication.service;

public class WalletApplicationValidation {
	static boolean flag = true;

	public boolean validatecustomer(String customerName) {

		if (customerName.isEmpty()) {
			System.err.println("customerName should not be empty");
			return false;
		}
		for (int i = 0; i < 9; i++) {
			if (customerName.contains(Integer.toString(i))) {
				System.err.println("Name should not contain numbers");
				return false;

			}
		}

		return true;

	}

	public boolean validateuserName(String userName) {
		if (userName.isEmpty()) {
			System.err.println("username should not be empty");
			return false;
		}
		if (userName.contains(" ")) {
			System.err.println("username should not contain space");
			return false;

		} else {
			return true;
		}

	}

	public boolean validatepassword(String password) {
		if (password.isEmpty()) {
			System.err.println("password should not be empty");
			return false;
		}

		if (password.length() >= 8) {
			return true;
		} else {
			System.err.println("your password must contain minimum 8 characters");
			return false;
		}

	}

	public boolean validateAge(int age) {

		if (age >= 18) {
			return true;
		} else {
			System.err.println("To open  an account your age must be above 18 ");
			return false;
		}

	}

	public boolean validatecontact(String contact) {
		if (contact.isEmpty()) {
			System.err.println("contact must be entered");
			return false;
		}
		if (contact.length() == 10) {
			return true;
		} else {
			System.err.println("Enter existing  phone number");
			return false;
		}
	}

	public boolean validategender(String gender) {
		if (gender.isEmpty()) {
			System.err.println("Gender cannot be Empty");
			return false;
		}

		if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("m")
				|| gender.equalsIgnoreCase("f")) {

			return true;
		} else {
			System.err.println("Enter correct Gender");
			return false;
		}
	}

	public boolean validateemail(String email) {
		if (email.isEmpty()) {
			System.err.println("email should be empty");
			return false;

		}

		if (email.endsWith("@gmail.com")) {
			return true;
		} else {
			System.err.println("Email should be in format(*******@gmail.com)");
			return false;

		}

	}

	public boolean validateAmount(double amount) {

		if (amount > 0) {
			return true;
		} else {
			System.err.println("Amount should be greater than zero");
			return false;
		}

	}

	public boolean validateAccNum(long accNum) {

		return flag;

	}
}
