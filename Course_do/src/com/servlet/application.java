package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class application
 */
public class application extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public application() {
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
		PrintWriter out = response.getWriter();//输出流对象
		HttpSession session=request.getSession();//session对象

		
		String url = "jdbc:mysql://localhost/course_do_system";
		
		String courseid = request.getParameter("courseid");
		String coursename = request.getParameter("coursename");
		String experimentid = request.getParameter("experimentid");
		String experimentname = request.getParameter("experimentname");
		String totalhour = request.getParameter("totalhour");
		String exhour = request.getParameter("exhour");
		String classid = request.getParameter("classid");//获取表单信息
		
		
		if(courseid.equals("")||coursename.equals("")||experimentid.equals("")||experimentname.equals("")||totalhour.equals("")||exhour.equals("")||classid.equals("")) {
			session.setAttribute("msg", "信息不完整！");
			response.sendRedirect("error.jsp");
		}
		else {
			String sql2 = "insert into experiment(实验项目编号,名称,学时,任课教师编号,课程号,班级编号) "
						+ "values('"+experimentid+"','"+experimentname+"','"+exhour+"','"+(String)session.getAttribute("userid")+"','"+courseid+"','"+classid+"')";
			String sql3 = "select * from experiment where 实验项目编号='"+experimentid+"' and 课程号='"+courseid+"'";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");// 加载驱动
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
				Statement st = con.createStatement();//执行sql语句
				ResultSet rs = st.executeQuery(sql3);//返回结果集
				if(rs.next()) {
					session.setAttribute("msg", "课程实验已经存在！");
					response.sendRedirect("error.jsp");
				}
				else {
					int s = st.executeUpdate(sql2);
					if(s!=0) {
						session.setAttribute("msg1", "申请成功，请您耐心等待管理员排课");
						response.sendRedirect("application_success.jsp");
					}
					else {
						session.setAttribute("msg", "申请失败，请您重新申请");
						response.sendRedirect("error.jsp");
					}
				}
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
