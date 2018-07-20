package com.capg.walletapp.service;

import com.capg.walletapp.bean.WalletApplication;

import junit.framework.TestCase;

public class ApplicationDataValidateTest extends TestCase {

	WalletApplication obj = new WalletApplication();
	ApplicationDataValidate validate = new ApplicationDataValidate();

	public void testValidateAge() {

		assertEquals(true, validate.validateAge(19));
		assertEquals(false, validate.validateAge(5));

	}

	public void testValidateMail() {

		assertEquals(true, validate.validateMail("kumar@gmail.com"));
		assertEquals(false, validate.validateMail("kumar@gmail"));
		assertEquals(false, validate.validateMail(""));
	}

	public void testValidateUsername() {

		assertEquals(true, validate.validateUsername("pavan"));
		assertEquals(false, validate.validateUsername(" pavan"));
		assertEquals(false, validate.validateUsername(""));
	}

	public void testValidatePassword() {

		assertEquals(true, validate.validatePassword("876543212"));
		assertEquals(false, validate.validatePassword("123"));
		assertEquals(false, validate.validatePassword(" 1235678"));
		assertEquals(false, validate.validatePassword(""));
	}

	public void testValidateContact() {

		assertEquals(true, validate.validateContact("966731945"));
		assertEquals(false, validate.validateContact("93242"));
		assertEquals(false, validate.validateContact(""));
	}

	public void testValidateGender() {

		assertEquals(true, validate.validateGender("male"));
		assertEquals(true, validate.validateGender("m"));
		assertEquals(true, validate.validateGender("female"));
		assertEquals(true, validate.validateGender("f"));
		assertEquals(false, validate.validateGender("ma3"));
	}

	public void testValidateAmount() {

		assertEquals(true, validate.validateBalance(461));
		assertEquals(false, validate.validateBalance(-453));
	}

	public void testValidateCustomerName() {

		assertEquals(true, validate.validateCustomerName("pavan"));
		assertEquals(false, validate.validateCustomerName("8pavan"));
		assertEquals(false, validate.validateCustomerName("@pavan"));
		assertEquals(false, validate.validateCustomerName(""));
	}

}
