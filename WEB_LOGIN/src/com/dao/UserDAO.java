package com.dao;

import java.sql.*;
import com.dao.*;
import java.util.ArrayList;

import com.bean.UserBean;
import com.dbConnection.ConnectionManager;
import com.mysql.cj.protocol.Resultset;
import com.service.UserInfo;

public class UserDAO implements UserInfo{
	
	@Override
	public ArrayList<UserBean> showUsers(UserBean userBean) {
		String username =  null;
		String email = null;
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();
		try(Connection conn = ConnectionManager.getConnection()) {
			if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
			String sql = "select * from user_registration";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				username = rs.getString(1);
				//System.out.println(username);
				email = rs.getString(3);
				userBean.setUsername(username);
				//System.out.println(userBean.getUsername());
				userBean.setEmail(email);
				arrayList.add(new UserBean(userBean.getUsername(),userBean.getEmail()));
			}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
		return arrayList;

}

	@Override
	public ArrayList<UserBean> searchUserByName(UserBean userBean) {
		String username =  null;
		String email = null;
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();
		try(Connection conn = ConnectionManager.getConnection()) {
			if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
			String sql = "select * from user_registration";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				if(userBean.getUsername().equals(rs.getString(1)))
				{
					username = rs.getString(1);
					System.out.println(username);
					email = rs.getString(3);
					userBean.setUsername(username);
					System.out.println(userBean.getUsername());
					userBean.setEmail(email);
					arrayList.add(new UserBean(userBean.getUsername(),userBean.getEmail()));
				}
				
			}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
		return arrayList;
	}

	@Override
	public ArrayList<UserBean> updateUser(UserBean userBean) {
		int id = userBean.getId();
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();
		String username, email, phoneNo, address, password = null;
		int uid = 0;
		try(Connection conn = ConnectionManager.getConnection()) {
			if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
			String sql = "select * from user_registration where id='"+id+"'";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				uid = rs.getInt(1);
				username = rs.getString(2);
				password = rs.getString(3);
				email = rs.getString(4);
				phoneNo =rs.getString(5);
				address = rs.getString(6);
				userBean.setId(uid);
				userBean.setUsername(username);
				userBean.setPassword(password);
				userBean.setEmail(email);
				userBean.setPhoneNo(phoneNo);
				userBean.setAddress(address);
				arrayList.add(new UserBean(userBean.getId(), userBean.getUsername(),userBean.getEmail(),userBean.getPhoneNo(),userBean.getAddress(),userBean.getPassword()));
			}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return arrayList;
}

	@Override
	public int updateUserInDb(UserBean userBean) {
		int id = userBean.getId();
		int i = 0;
		String username = userBean.getUsername();
		String email = userBean.getEmail();
		String password = userBean.getPassword();
		String phoneNo = userBean.getPhoneNo();
		String address = userBean.getAddress();
		try(Connection conn = ConnectionManager.getConnection()) {
			if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
			String sql = "update user_registration set id=?,username=?,password=?,email=?,phoneNo=?,address=? where id='"+id+"'";
			PreparedStatement pst = conn.prepareStatement(sql);
			while(true)
			{
				pst.setInt(1, id);
				pst.setString(2, username);
				pst.setString(3, password);
				pst.setString(4, email);
				pst.setString(5, phoneNo);
				pst.setString(6, address);
				i = pst.executeUpdate();
			}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
		return i;
	}
	
}
