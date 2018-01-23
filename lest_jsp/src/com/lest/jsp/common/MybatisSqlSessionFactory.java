package com.lest.jsp.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	
	private static SqlSessionFactory ssf;
	static {
		
		try (InputStream is = Resources.getResourceAsStream("conf/mybatis-config.xml")){
			ssf = new SqlSessionFactoryBuilder().build(is);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSSF() {
		return ssf;
	}
	
	
}
