package com.capgemini.walletapplication.service;

import com.capgemini.walletapplication.bean.WalletApplication;

import junit.framework.TestCase;

public class WalletApplicationValidationTest extends TestCase {
	 WalletApplicationValidation  valid=new  WalletApplicationValidation();
	 WalletApplication  obj=new WalletApplication();
	public void testValidatecustomer() {
		
		assertEquals(true,valid.validatecustomer("pavan"));
		assertEquals(false,valid.validatecustomer("4pavan"));
		//assertEquals(false,valid.validatecustomer("@pavan"));
		assertEquals(false,valid.validatecustomer(""));
		
	}

	public void testValidateuserName() {
		
	
		assertEquals(false,valid.validateuserName(" pavan"));
		assertEquals(false,valid.validateuserName(""));
		assertEquals(true,valid.validateuserName("pava@"));
	}

	public void testValidatepassword() {
		
		assertEquals(false,valid.validatepassword(""));
		assertEquals(true,valid.validatepassword("pavan@123"));
		assertEquals(false,valid.validatepassword("pavan@1"));
	}

	public void testValidateAge() {
	
	assertEquals(true,valid.validateAge(75));
	assertEquals(false,valid.validateAge(6));
	
	}

	public void testValidatecontact() {
		
	assertEquals(true,valid.validatecontact("7702090511"));
	assertEquals(false,valid.validatecontact("7702090"));
	assertEquals(false,valid.validatecontact(""));
	
	}

	public void testValidategender() {
		
	assertEquals(true,valid.validategender("male"));
	assertEquals(true,valid.validategender("female"));
	assertEquals(true,valid.validategender("m"));
	assertEquals(true,valid.validategender("f"));
	assertEquals(false,valid.validategender(""));
	assertEquals(false,valid.validategender("maaa"));
	
	}

	public void testValidateemail() {
		
		assertEquals(true,valid.validateemail("pavan@gmail.com"));
		assertEquals(false,valid.validateemail("pavan@gmail"));
		assertEquals(false,valid.validateemail(""));}

}
