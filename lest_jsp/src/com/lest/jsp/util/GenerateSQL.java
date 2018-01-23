package com.lest.jsp.util;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lest.jsp.common.MybatisSqlSessionFactory;

public class GenerateSQL {

	public static String generateSql(String tableName) {
		return "select * from" + tableName;
	}

	public static void main(String[] args) {
		try (SqlSession ss = MybatisSqlSessionFactory.getSSF().openSession()) {
			String tableName = "user_info";
			List<Map<String, String>> colList = ss.selectList("common.selectTable", tableName);
			String selectSql = "";
			String updateSql = "";
			String deleteSql = "";
			String insertSql = "";
			
			
			for(Map<String, String> m: colList) {			
				selectSql += m.get("colName") + ",";			
			}
			selectSql = "select " + selectSql.substring(0,selectSql.length()-1) + " from " + tableName;
			
			for(Map<String,String> m:colList) {
				if(m.get("isKey").equals("N"))  {
					
					updateSql +=m.get("colName") + "=#{" + m.get("colName") + "} ";
				}else {
				   updateSql +=m.get("colName") + "=#{" + m.get("colName") + "} ";
				}
			}
			System.out.println(updateSql);
			//updateSql = "update " + tableName + " set " + updateSql.substring(0,updateSql.length()-1) + " where " ; 
					
					
		//	deleteSql = "delete " + "from " + tableName + " where "	;	
			//insertSql = "insert" + " into " + tableName + insertSql.substring(0,selectSql.length()-1) + " values " ;
		//	System.out.println(selectSql);
			
		}
	}

}
