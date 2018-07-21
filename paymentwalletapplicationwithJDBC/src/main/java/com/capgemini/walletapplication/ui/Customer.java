package com.capgemini.walletapplication.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

import com.capgemini.walletapplication.bean.Details;
import com.capgemini.walletapplication.bean.WalletApplication;
import com.capgemini.walletapplication.exepction.UserNotFound;
import com.capgemini.walletapplication.service.WalletApplicationValidation;
import com.capgemini.walletapplication.service.WalletApplicatonService;

public class Customer {
	static int b;
	static double c;
	static boolean a;
	static int key, ch;

	public static void createAccount() {
		long aID = (long) (Math.random() * 1234 + 9999);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WalletApplicationValidation valid = new WalletApplicationValidation();

		WalletApplicatonService service = new WalletApplicatonService();

		WalletApplication wallet = new WalletApplication();
		Details det = new Details();

		try {
			System.out.println("Enter  the customername: ");
			String customerName = br.readLine();
			System.out.println("Enter the username:  ");
			String userName = br.readLine();
			System.out.println("Enter the password  ");
			String password = br.readLine();
			System.out.println("Enter the contact number:  ");
			String contact = br.readLine();
			System.out.println("Enter the email address of user:  ");
			String email = br.readLine();
			System.out.println("Enter the age of user  ");
			int age = Integer.parseInt(br.readLine());
			System.out.println("Enter the gender: ");
			String gender = br.readLine();
			System.out.println("Enter your aadharNumber: ");
			long aadharNo = Long.parseLong(br.readLine());
			System.out.println("Enter the minimum balance:  ");
			double balance = Double.parseDouble(br.readLine());

			det.setCustomerName(customerName);
			det.setUserName(userName);
			det.setPassword(password);
			det.setContact(contact);
			det.setEmail(email);
			det.setAge(age);
			det.setGender(gender);
			det.setAadharNum(aadharNo);
			wallet.setCust(det);
			wallet.setAccNum(aID);
			wallet.setAcctype("Savings");
			wallet.setAmount(balance);
			wallet.setBranch("Financial");

			boolean isValidCustomerName = valid.validatecustomer(customerName);

			boolean isValidUserName = valid.validateuserName(userName);
			boolean isValidPassword = valid.validatepassword(password);
			boolean isValidContact = valid.validatecontact(contact);
			boolean isValidEmail = valid.validateemail(email);
			boolean isValidAge = valid.validateAge(age);
			boolean isValidGender = valid.validategender(gender);

			if (isValidUserName && isValidPassword && isValidContact && isValidEmail && isValidAge && isValidGender) {
				b = service.createAcc(wallet);

			} else {
				System.out.println("enter valid data");
			}
			if (b == 1) {
				System.out.println("Your account is created successfully and your  account number is: " + aID);
			} else {
				System.out.println("account not created");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void loginAcc() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WalletApplicatonService service = new WalletApplicatonService();
		WalletApplicationValidation valid = new WalletApplicationValidation();
		// Details det=new Details();

		System.out.println("Enter the username:  ");
		try {
			String username = br.readLine();

			System.out.println("Enter the password  ");
			String password = br.readLine();

			boolean isValidUserName = valid.validateuserName(username);
			boolean isValidPassword = valid.validatepassword(password);

			if (isValidUserName && isValidPassword) {

				a = service.login(username, password);
			} else {
				try {

					throw new UserNotFound();

				} catch (Exception e) {
					System.out.println("Enter valid userName");
				}
			}
			if (a) {
				System.out.println("your login is successful");

				do {
					// loginAcc();
					System.out.println("1.show Balance");
					System.out.println("2.Deposit ");
					System.out.println("3.Withdraw");
					System.out.println("4.Fund Transfer");
					System.out.println("5.Print Transactions");
					System.out.println("6.logout");
					System.out.println("enter your choice");

					try {
						key = Integer.parseInt(br.readLine());

						switch (key) {
						case 1:
							showBlance();
							break;

						case 2:
							deposit();
							break;
						case 3:
							withDraw();
							break;
						case 4:
							fundTransfer();
							break;
						case 5:
							printTransactions();
							break;
						case 6:
							System.out.println("Thank you");
							close();
							m2();

						default:
							System.out.println("Enter correct choice");
							break;

						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (key != 6);

			} else {
				System.out.println("Enter valid data");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void showBlance() {
		WalletApplicatonService service = new WalletApplicatonService();
		double balance = service.showbal();
		System.out.println("Your balance is : " + balance);

	}

	public static void close() {
		WalletApplicatonService service = new WalletApplicatonService();
		service.closeConn();
	}

	public static void withDraw() {
		WalletApplicatonService service = new WalletApplicatonService();
		WalletApplicationValidation valid = new WalletApplicationValidation();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the amount to withdraw:  ");
		try {
			double with = Double.parseDouble(br.readLine());

			boolean isValidAmount = valid.validateAmount(with);
			if (isValidAmount) {
				service.withdraw(with);
			} else {
				System.out.println("Enter valid amount to withdraw");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deposit() {
		WalletApplicatonService service = new WalletApplicatonService();
		WalletApplicationValidation valid = new WalletApplicationValidation();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the amount to deposit:  ");
		try {
			double dep = Double.parseDouble(br.readLine());

			boolean isValidAmount = valid.validateAmount(dep);
			if (isValidAmount) {
				service.deposit(dep);
			} else {
				System.out.println("Enter valid amount to deposit");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void fundTransfer() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WalletApplicatonService service = new WalletApplicatonService();
		WalletApplicationValidation valid = new WalletApplicationValidation();
		System.out.println("Enter receiver's Account number");
		try {
			long accNum = Long.parseLong(br.readLine());
			System.out.println("Enter the amount to transfer");
			double amount = Double.parseDouble(br.readLine());
			boolean isValidAmount = valid.validateAmount(amount);
			boolean isValidAccNum = valid.validateAccNum(accNum);
			if (isValidAmount && isValidAccNum) {
				int trans = service.fundTransfer(accNum, amount);
				if (trans == 1) {
					System.out.println("FundTranser is successful");
				} else {
					System.out.println("Transaction is failure");

				}
			}

			else {
				System.out.println("Enter the valid data");
			}
		}

		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void printTransactions() {

		WalletApplicatonService service = new WalletApplicatonService();

		service.printTransaction();

	}

	public static void main(String[] args) {

		m2();

	}

	public static void m2() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {

			System.out.println("Welcome to XYZ Bank Paymentwallet Application");
			System.out.println("1.Create account");
			System.out.println("2.Login ");
			System.out.println("enter your choice");
			try {
				ch = Integer.parseInt(br.readLine());

				switch (ch) {
				case 1:
					createAccount();
					break;

				case 2:

					loginAcc();

					break;
				case 3:
					System.out.println("Thank you");
					System.exit(0);

				default:
					System.out.println("Enter correct choice");
					break;
				}

			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} while (ch != 3);
	}
}
