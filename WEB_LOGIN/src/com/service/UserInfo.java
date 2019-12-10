package com.service;

import com.bean.*;
import java.util.ArrayList;

import com.bean.UserBean;

public interface UserInfo {
	public ArrayList<UserBean> showUsers(UserBean userBean);
	public ArrayList<UserBean> searchUserByName(UserBean userBean);
	public ArrayList<UserBean> updateUser(UserBean userBean);
	public int updateUserInDb(UserBean userBean);
}
