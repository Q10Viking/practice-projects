package org.q10viking.service;

public interface IBuyStockService {
	//开一个用户账户
	void openAccount(String aname,double balance);
	//开一个股票账户
	void openStock(String sname,int count);
	//用户购买股票
	void buyStock(String aname,double money,String sname,int count) throws BuyStockException;
}
