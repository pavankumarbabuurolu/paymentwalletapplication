package com.capgemini.walletapplication.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WalletApplication {

	private long accNum;
	private long tID;
	private LocalDateTime date;
	private double amount;
	private String acctype;
	private long aadharNo;
	private Details cust;
	private String branch;

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = cust.getAadharNum();
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	List<String> trans = new ArrayList();

	public List<String> getTrans() {
		return trans;
	}

	public void setTrans(List<String> trans) {
		this.trans = trans;
	}

	public long getAccNum() {
		return accNum;
	}

	public Details getCust() {
		return cust;
	}

	public void setCust(Details cust) {
		this.cust = cust;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public long gettID() {
		return tID;
	}

	public void settID(long tID) {
		this.tID = tID;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
