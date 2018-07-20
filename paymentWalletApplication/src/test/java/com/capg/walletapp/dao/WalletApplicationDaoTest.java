package com.capg.walletapp.dao;

import com.capg.walletapp.bean.WalletApplication;

import junit.framework.TestCase;

public class WalletApplicationDaoTest extends TestCase {

	WalletApplicationDao dao = new WalletApplicationDao();
	WalletApplication obj = new WalletApplication();

	public void testCreateAcc() {
		assertEquals(1, dao.createAcc(obj));
		assertNotNull(obj);
		assertTrue(true);
	}

	public void testLogin() {
		assertEquals(true, dao.login("pavan","12345678"));
		assertTrue(true);
	}

	public void testShowBal() {
		assertEquals(3000, 3000);
		assertNotNull(dao.showBal());

	}

	public void testDeposit() {
		obj.setBalance(10000);
		assertEquals(1, dao.deposit(obj.getBalance()));
		assertTrue(true);
	}

	public void testWithdraw() {
		obj.setBalance(500);
		assertEquals(1, dao.deposit(obj.getBalance()));
		assertTrue(true);
	}

	public void testFundTransfer() {
		assertEquals(1, dao.fundTransfer(obj.getAccNum(), obj.getBalance()));
		assertTrue(true);
	}

	public void testPrintTrans() {
		assertEquals(null, dao.printTrans());
		// assertNotNull(dao.printTrans(bean.gettID()));
	}

}
