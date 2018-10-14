package org.q10viking.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StockDaoImp extends JdbcDaoSupport implements IStockDao {

	@Override
	public void insertStock(String sname, int count) {
		String sql = "INSERT INTO stock(sname,count) VALUES(?,?)";
		this.getJdbcTemplate().update(sql, sname,count);
	}

	@Override
	public void updateStock(String sname, int count, boolean isBuy) {
		//表示卖股票
		String sql = "UPDATE stock SET count=count-? WHERE sname=?";
		//表示买股票
		if(isBuy)
			sql = "UPDATE stock SET count=count+? WHERE sname=?";
		this.getJdbcTemplate().update(sql,count,sname);
	}

}
