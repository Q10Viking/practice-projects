package org.q10viking.di08;

public class Person {
	private String pname;
	private int page;
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getPname() {
		return pname;
	}
	public int getPage() {
		return page;
	}
	public int computeAge() {
		return page>25? 25: page;
	}
	@Override
	public String toString() {
		return "Person [pname=" + pname + ", page=" + page + "]";
	}
}
