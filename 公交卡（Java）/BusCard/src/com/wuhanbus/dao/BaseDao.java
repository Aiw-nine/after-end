package com.wuhanbus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wuhanbus.entity.Card;

public abstract class BaseDao {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/buscard";
	private String username="root";
	private String password="";
	private static Connection con=null;
	private static PreparedStatement pst=null;
	private static ResultSet rs=null;
	
	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	//连接
	public Connection getConnect(){
		try {
			Class.forName(getDriver());
			con=DriverManager.getConnection(getUrl(), getUsername(), getPassword());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	//增删改
	public int executeUpdate(String sql,Object[] params){
		int num=0;
		con=getConnect();
		try {
			pst=con.prepareStatement(sql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			num=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	//查
	public ResultSet getResultSet(String sql,Object[] params){
		con=getConnect();
		try {
			pst=con.prepareStatement(sql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			rs=pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	//释放资源
	public void closeAll(){
		if(rs!=null){
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pst!=null){
			try {
				pst.close();
				pst=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//查询返回所用卡信息
	public abstract List<Card> getAllCards();
}

