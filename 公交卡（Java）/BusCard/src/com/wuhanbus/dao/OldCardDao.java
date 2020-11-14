package com.wuhanbus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wuhanbus.entity.Card;
import com.wuhanbus.entity.CommonCard;
import com.wuhanbus.entity.OldCard;

public class OldCardDao extends BaseDao {
	public String getDriver() {
		return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	}
	
	public String getUrl() {
		return "jdbc:sqlserver://localhost:1433;DataBaseName=buscard";
	}
	
	public String getUsername() {
		return "sa";
	}
	
	public String getPassword() {
		return "123456";
	}

	public boolean consume(OldCard card,int num){
		String sql="UPDATE OldCard SET num=num-? where id=?";
		Object[] params={num,card.getId()};
		return super.executeUpdate(sql, params)>0;
	}
	
	@Override
	public List<Card> getAllCards() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM OldCard";
		ResultSet rs=super.getResultSet(sql, null);
		List<Card> list=new ArrayList<Card>();
		try {
			while(rs.next()){
				OldCard c=new OldCard();
				c.setId(rs.getString("id"));
				c.setNum(rs.getInt("num"));
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
