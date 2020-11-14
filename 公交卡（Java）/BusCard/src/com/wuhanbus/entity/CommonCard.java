package com.wuhanbus.entity;

import com.wuhanbus.control.Iprint;
import com.wuhanbus.dao.CommonCardDao;

public class CommonCard extends Card implements Iprint {
	private double money;

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String pay() {
		// TODO Auto-generated method stub
		this.money-=3;
		CommonCardDao dao=new CommonCardDao();
		dao.consume(this, 3);
		return "普通卡";
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		String info=String.format("消费3元，还剩%.2f元", this.money);
		return info;
	}
}
