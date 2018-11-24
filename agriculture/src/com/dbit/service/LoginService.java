package com.dbit.service;

import java.sql.SQLException;

import com.dbit.dao.LoginDao;
import com.dbit.to.LoginTo;

public class LoginService {
LoginDao loginDao;

public LoginService() {
	loginDao =new LoginDao();
}

public boolean login(LoginTo loginTo) throws SQLException
{
	boolean b=loginDao.login(loginTo);

	return b;
		}


}
