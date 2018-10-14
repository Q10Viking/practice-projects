package org.q10viking.service;

import org.q10viking.dao.IAccountDao;
import org.q10viking.dao.IStockDao;

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

	@Override
	public void openAccount(String aname, double balance) {
		adao.insertAccount(aname,balance);
	}

	@Override
	public void openStock(String sname, int count) {
		sdao.insertStock(sname,count);
	}

	@Override
	public void buyStock(String aname, double money, String sname, int count) throws BuyStockException {
		boolean isBuy=true;
		adao.updateAccount(aname,money,isBuy);
		if(1==1)
			throw new BuyStockException("购买股票异常");
		sdao.updateStock(sname,count,isBuy);
	}

}
