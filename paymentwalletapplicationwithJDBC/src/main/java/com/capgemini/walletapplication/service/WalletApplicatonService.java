package com.capgemini.walletapplication.service;

import java.util.List;

import com.capgemini.walletapplication.bean.WalletApplication;
import com.capgemini.walletapplication.dao.IWalletApplicationDao;
import com.capgemini.walletapplication.dao.WalletApplicationDao;

public class WalletApplicatonService implements IWalletApplicationDao {

	WalletApplicationDao dao = new WalletApplicationDao();

	public int createAcc(WalletApplication obj) {

		return dao.createAcc(obj);
	}

	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.login(username, password);
	}

	public double showbal() {
		// TODO Auto-generated method stub
		return dao.showbal();
	}

	public int deposit(double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}

	public int withdraw(double amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(amount);
	}

	public int fundTransfer(long accNum, double amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(accNum, amount);
	}

	public void printTransaction() {
		// TODO Auto-generated method stub
		dao.printTransaction();
	}

	public void closeConn() {
		// TODO Auto-generated method stub
		dao.closeConn();
	}

}
