package com.lest.jsp.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.lest.jsp.common.MybatisSqlSessionFactory;
import com.lest.jsp.dao.MenuDAO;

public class MenuDAOImpl implements MenuDAO{
	private static Logger log = Logger.getLogger(MenuDAOImpl.class);
	@Override
	public List<Map<String,String>> selectMenuList() {
		try(SqlSession ss = MybatisSqlSessionFactory.getSSF().openSession()){
			return ss.selectList("menu.selectMenu");
		}catch(Exception e) {
			log.error("err => {}",e);
		}
		return null;
	}
	
	public static void main(String[] agrs) {
		MenuDAO mdao = new MenuDAOImpl();
		List<Map<String,String>> list = mdao.selectMenuList();
		for(Map<String,String> m:list){
			log.info("test m=>" + m);
		}
	}

}
