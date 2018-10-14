package org.q10viking.beans;

public class Acount {
	private Integer aid;
	private String aname;
	private Integer balance; //余额
	
	public Acount() {
		super();
	}

	public Acount(String aname, Integer balance) {
		super();
		this.aname = aname;
		this.balance = balance;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Acount [aid=" + aid + ", aname=" + aname + ", balance=" + balance + "]";
	}

}
