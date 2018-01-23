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

import com.lest.jsp.service.MenuService;
import com.lest.jsp.service.impl.MenuServiceImpl;

/**
 * Servlet implementation class JspServlet
 */
@WebServlet("/view/*")
public class JspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JspServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	//	PrintWriter out = res.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/index.jsp");
		MenuService ms = new MenuServiceImpl();
		ms.getMenuList(req);	
		rd.forward(req,res);
	//	out.println(req.getParameter("test"));
	}
}
