package com.wuhanbus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wuhanbus.entity.Card;
import com.wuhanbus.entity.CommonCard;

public class CommonCardDao extends BaseDao {
	
	public boolean consume(CommonCard card,double money){
		String sql="UPDATE commoncard SET money=money-? where id=?";
		Object[] params={money,card.getId()};
		return super.executeUpdate(sql, params)>0;
	}

	@Override
	public List<Card> getAllCards() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM commoncard";
		ResultSet rs=super.getResultSet(sql, null);
		List<Card> list=new ArrayList<Card>();
		try {
			while(rs.next()){
				CommonCard c=new CommonCard();
				c.setId(rs.getString("id"));
				c.setMoney(rs.getDouble("money"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}

}
