package com.lest.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lest.jsp.factory.ServiceFactory;
import com.lest.jsp.service.MenuService;
import com.lest.jsp.service.UserService;
import com.lest.jsp.service.impl.MenuServiceImpl;
import com.lest.jsp.util.URIParser;



@WebServlet("/view/*")
public class JspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceFactory sf = ServiceFactory.getInstance();
	private static Logger log = Logger.getLogger(JspServlet.class);	
    public JspServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.getWriter().append("Served at: ").append(req.getRequestURI());
		doprocess(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doprocess(req, res);
	}
	
	public void doprocess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		log.debug(uri);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF" + uri + ".jsp");
		if(req.getServletContext().getAttribute("menuList")==null) {
			MenuService ms = (MenuService)sf.getService("menu");
			ms.getMenuList(req);		
		}
		String command = URIParser.getCommand(uri, 1);
		log.debug(command);
		if(command.equals("list")) {
			uri = uri.replaceAll("/" + command,"");
			command = URIParser.getCommand(uri, 1);
			UserService s = (UserService)sf.getService(command);
			s.getUserList(req);
		}
		rd.forward(req,res);
	}
}
