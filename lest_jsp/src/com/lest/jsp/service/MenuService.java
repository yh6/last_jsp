package com.lest.jsp.service;

import javax.servlet.http.HttpServletRequest;

public interface MenuService extends Service{
	
	public void getMenuList(HttpServletRequest req);

}
