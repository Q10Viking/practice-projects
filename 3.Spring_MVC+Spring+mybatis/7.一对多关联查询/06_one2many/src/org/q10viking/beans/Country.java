package org.q10viking.beans;
import java.util.Set;
public class Country {
	private int cid;
	private String cname;
	//关联属性
	private Set<Minister> ministers;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	public Set<Minister> getMinisters() {
		return ministers;
	}
	public void setMinisters(Set<Minister> ministers) { 
		this.ministers = ministers;
	}
	
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + ", ministers=" + ministers + "]";
	}

	
	
	
}
