package com.example.model;

public class Customer {
	private int acno;
	private int withdraw;
	private String dateoftx;
	private int credit;

	public String getDateoftx() {
		return dateoftx;
	}

	public void setDateoftx(String dateoftx) {
		this.dateoftx = dateoftx;
	}

	public int getCredit() {
		return credit;
	}

	

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}
}
