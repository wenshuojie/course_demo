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
 * Servlet implementation class addcourse
 */
public class addcourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");//设置编码
		PrintWriter out = response.getWriter();//输出流对象
		HttpSession session=request.getSession();//session对象
		String url = "jdbc:mysql://localhost/course_do_system";
		
		String courseid = request.getParameter("courseid");
		String coursename = request.getParameter("coursename");
		String time = request.getParameter("time");
		String teacherid = request.getParameter("teacherid");//获取表单
		
		String sql = "select * from course where 课程号='"+courseid+"' and 任课教师编号 = '"+teacherid+"'";
		if(courseid.equals("")||coursename.equals("")||time.equals("")||teacherid.equals("")) {
			session.setAttribute("msg", "信息不完整！");
			response.sendRedirect("error.jsp");
		}
		else {
			try {
				Class.forName("com.mysql.jdbc.Driver");//加载驱动
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
				Statement st = con.createStatement();//执行sql语句
				ResultSet rs = st.executeQuery(sql);//返回结果集
				
				if(rs.next()) {
					session.setAttribute("msg", "重复课程信息！");
					response.sendRedirect("error.jsp");					
				}
				else {
					String sql2 = "insert into course(课程号,课程名,总学时,任课教师编号) "
							   + "values('"+courseid+"','"+coursename+"','"+time+"','"+teacherid+"')";
					int n =	st.executeUpdate(sql2);
					if(n!=0) {
						session.setAttribute("msg3", "添加课程信息成功！");
						response.sendRedirect("coursesuccess.jsp");
					}
					else {
						session.setAttribute("msg", "添加课程信息失败！");
						response.sendRedirect("error.jsp");			
					}					
				}
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e) {
				
			}
		}

	}
}
