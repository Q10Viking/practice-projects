package org.q10viking.beans;

public class Minister {
	private int mid;
	private String mname;
	//关联属性
	private Country country;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	@Override
	public String toString() {
		return "Minister [mid=" + mid + ", mname=" + mname + ", country=" + country + "]";
	}

	
}
