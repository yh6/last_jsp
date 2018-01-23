package com.lest.jsp.factory;

import java.util.HashMap;
import java.util.Map;

import com.lest.jsp.service.Service;
import com.lest.jsp.service.impl.MenuServiceImpl;
import com.lest.jsp.service.impl.UserServiceImpl;

public class ServiceFactory {
	
	private ServiceFactory() {
		
	}
	public static ServiceFactory getInstance() {
		return new ServiceFactory();
	}
	
	private static Map<String,Service> serviceMap; 
	
	static {
		serviceMap = new HashMap<String,Service>(); //어플리케이션(서버
	}
	
	private void initInstance(String servcieName) {
		if(servcieName.equals("menu")) {
			serviceMap.put(servcieName, new MenuServiceImpl());
		}else if(servcieName.equals("user")) {
			serviceMap.put(servcieName, new UserServiceImpl());
		}
	}
	
	public Service getService(String serviceName) {
		if(!serviceMap.containsKey(serviceName)) {
			initInstance(serviceName);
		}
		return serviceMap.get(serviceName);
	}
}
