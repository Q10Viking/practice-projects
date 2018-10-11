package org.q10viking.di08;


public class Student {
	private String sname;
	private int sage;
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", sage=" + sage + "]";
	}
}
