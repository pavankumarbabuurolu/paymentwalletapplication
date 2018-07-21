package com.capgemini.walletapplication.dao;

import com.capgemini.walletapplication.bean.WalletApplication;

import junit.framework.TestCase;

public class WalletApplicationDaoTest extends TestCase {
	WalletApplicationDao  dao=new WalletApplicationDao();
	 WalletApplication   obj=new  WalletApplication();
	public void testCreateAcc() {
	
	assertNotNull(obj);
	assertTrue(true);
	}

	public void testLogin() {
		assertEquals(true, dao.login("rithish1","12345672"));
		assertTrue(true);
		assertEquals(true, dao.login("saikumar1","saikumar21"));
		
	}

	public void testShowbal() {
		assertEquals(30000,30000);
		assertNotNull(dao.showbal());
	}

	public void testDeposit() {
		assertEquals(1,dao.deposit(2000));
		assertTrue(true);
		
	}

	public void testWithdraw() {
		assertEquals(1,dao.withdraw(200));
		assertTrue(true);
	}

	public void testFundTransfer() {
		assertEquals(1,dao.fundTransfer(10301,400));
		assertEquals(0,dao.fundTransfer(103012,400));
	}


}
