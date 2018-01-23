package com.lest.jsp.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lest.jsp.dao.MenuDAO;
import com.lest.jsp.dao.impl.MenuDAOImpl;
import com.lest.jsp.service.MenuService;

public class MenuServiceImpl implements MenuService {
	private MenuDAO mdao = new MenuDAOImpl();
	@Override
	public void getMenuList(HttpServletRequest req) {
		req.getServletContext().setAttribute("menuList", mdao.selectMenuList());
		

	}
	@Override
	public void printCalssName() {
		
		
	}

}
