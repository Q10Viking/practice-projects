package org.q10viking.dao;

public interface IStockDao {

	void insertStock(String sname, int count);

	void updateStock(String sname, int count, boolean isBuy);

}
