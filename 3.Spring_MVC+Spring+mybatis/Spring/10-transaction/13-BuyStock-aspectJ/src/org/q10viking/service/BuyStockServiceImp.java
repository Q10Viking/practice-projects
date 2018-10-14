package org.q10viking.service;

import org.q10viking.dao.IAccountDao;
import org.q10viking.dao.IStockDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyStockServiceImp implements IBuyStockService {
	
	private IAccountDao adao;
	private IStockDao sdao;
	
	
	
	public IAccountDao getAdao() {
		return adao;
	}

	public void setAdao(IAccountDao adao) {
		this.adao = adao;
	}

	public IStockDao getSdao() {
		return sdao;
	}

	public void setSdao(IStockDao sdao) {
		this.sdao = sdao;
	}
	
	/*
	Spring事务的默认回滚方式是： 发生运行时异常回滚，发生受查异常时提交
	不过，对于受查异常，程序员也可以手工设置其回滚方式*/
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void openAccount(String aname, double balance) {
		adao.insertAccount(aname,balance);
	}
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void openStock(String sname, int count) {
		sdao.insertStock(sname,count);
	}

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=BuyStockException.class)
	@Override
	public void buyStock(String aname, double money, String sname, int count) throws BuyStockException {
		boolean isBuy=true;
		adao.updateAccount(aname,money,isBuy);
		if(1==1)
			throw new BuyStockException("购买股票异常");
		sdao.updateStock(sname,count,isBuy);
	}

}
