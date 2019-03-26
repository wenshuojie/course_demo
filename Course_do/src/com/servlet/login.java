package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class login
 */

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//of init
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");//设置编码
		PrintWriter out = response.getWriter();//输出流对象
		HttpSession session=request.getSession();//session对象
		
		String user = request.getParameter("userid");
		String pwd = request.getParameter("password");//获取用户名及密码
		String url = "jdbc:mysql://localhost/course_do_system";
		
		
		if(user.equals("")||pwd.equals("")) {
			session.setAttribute("msg", "账号或密码为空");
			response.sendRedirect("error.jsp");
		}
		else {
			try {
				String sql = "select * from teacher where 账号='" + user + "' and 密码='" + pwd + "'";
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
				Statement st = con.createStatement();//执行sql语句
				ResultSet rs = st.executeQuery(sql);//返回结果集
				if(!rs.next()) {
					session.setAttribute("msg","账号密码错误");
					response.sendRedirect("error.jsp");
				}
				else {
					
					session.setAttribute("user", rs.getString("姓名"));
					session.setAttribute("userid", rs.getString("教师号"));//将登录用户放入session
					if(rs.getString("类型").equals("管理员")) {
						response.sendRedirect("admin.jsp");
					}
					else {
						response.sendRedirect("teacher.jsp");
					}
				}
				rs.close();
				st.close();
				con.close();
			}catch(Exception e) {
				
			}
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
