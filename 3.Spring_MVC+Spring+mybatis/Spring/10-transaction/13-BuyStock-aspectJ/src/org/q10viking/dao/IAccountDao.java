package org.q10viking.dao;

public interface IAccountDao {

	void insertAccount(String aname, double balance);

	void updateAccount(String aname, double money, boolean isBuy);

}
