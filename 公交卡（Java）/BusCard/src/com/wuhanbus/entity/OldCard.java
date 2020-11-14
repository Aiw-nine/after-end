package com.wuhanbus.entity;

import com.wuhanbus.control.Iprint;
import com.wuhanbus.dao.CommonCardDao;
import com.wuhanbus.dao.OldCardDao;

public class OldCard extends Card implements Iprint {
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String pay() {
		// TODO Auto-generated method stub
		this.num-=1;
		OldCardDao dao=new OldCardDao();
		dao.consume(this, 1);
		return "���꿨";
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		String info=String.format("ˢ��1�Σ���ʣ%d��", this.num);
		return info;
	}
	
}
