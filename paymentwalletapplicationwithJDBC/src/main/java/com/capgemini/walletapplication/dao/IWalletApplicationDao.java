package com.capgemini.walletapplication.dao;

import java.util.List;

import com.capgemini.walletapplication.bean.WalletApplication;

public interface IWalletApplicationDao {
	public int createAcc(WalletApplication obj);

	public boolean login(String userName, String password);

	public double showbal();

	public int deposit(double amount);

	public int withdraw(double amount);

	public int fundTransfer(long accNum, double amount);

	public void printTransaction();

	public void closeConn();

}
