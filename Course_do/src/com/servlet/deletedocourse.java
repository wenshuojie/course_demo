package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Servlet implementation class deletedocourse
 */
public class deletedocourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletedocourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");//设置编码
		HttpSession session=request.getSession();//session对象
		String url = "jdbc:mysql://localhost/course_do_system";
		
		String experimentid = request.getParameter("experimentid");
		String sql = "delete from experiment where 实验项目编号='"+experimentid+"'";
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动
			Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
			Statement st = con.createStatement(); //执行sql语句			
			int s=st.executeUpdate(sql);
			if(s>0){
				session.setAttribute("msg2", "删除成功");
				response.sendRedirect("deletesuccess.jsp");
			}
			else {
				session.setAttribute("msg", "删除失败");
				response.sendRedirect("error.jsp");
			}
			st.close();
			con.close();
			
		}catch(Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
