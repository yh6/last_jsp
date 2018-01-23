package com.lest.jsp.service;

import javax.servlet.http.HttpServletRequest;

public interface UserService extends Service{

	public void getUserList(HttpServletRequest req);
}
