package org.q10viking.di05;

import java.util.*;

public class MyCollections {
	private School[] schools;
	private String[] strs;
	private List<School> myList;
	private Set<String> mySet;
	private Map<String,Integer> myMap;
	private Properties myPro;
	
	
	public void setSchools(School[] schools) {
		this.schools = schools;
	}
	

	public void setStrs(String[] strs) {
		this.strs = strs;
	}

	
	public void setMyList(List<School> myList) {
		this.myList = myList;
	}


	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}


	public void setMyMap(Map<String, Integer> myMap) {
		this.myMap = myMap;
	}


	public void setMyPro(Properties myPro) {
		this.myPro = myPro;
	}


	@Override
	public String toString() {
		return "MyCollections [myPro=" + myPro + "]";
	}

	
	

	
}
