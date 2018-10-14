package org.q10viking.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImp extends JdbcDaoSupport implements IAccountDao {

	
	@Override
	public void insertAccount(String aname, double balance) {
		String sql = "INSERT INTO account(aname,balance) VALUES(?,?)";
		this.getJdbcTemplate().update(sql,aname,balance);
	}

	@Override
	public void updateAccount(String aname, double money, boolean isBuy) {
		//表示卖股票
		String sql = "UPDATE account SET balance=balance+? WHERE aname=?";
		//表示买股票
		if(isBuy)
			sql = "UPDATE account SET balance=balance-? WHERE aname=?";
		this.getJdbcTemplate().update(sql,money,aname);
	}

}
