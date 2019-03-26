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
 * Servlet implementation class docourse
 */
public class docourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public docourse() {
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
		
		String experimentid = (String)session.getAttribute("experimentid");
		String experimentname = (String)session.getAttribute("experimentname");
		String teacherid = (String)session.getAttribute("teacherid");
		String week = request.getParameter("week");
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		String roomid = request.getParameter("roomid");
		String classid = (String)session.getAttribute("classid");
		
		if(week.equals("")||day.equals("")||time.equals("")||roomid.equals("")||classid.equals("")) {
			session.setAttribute("msg", "信息不完整！");
			response.sendRedirect("error.jsp");
		}
		
		try {
			String sql1 = "select * from course_do where 周次 = '"+week+"' and 星期数 = '"+day+"' and 节数 = '"+time+"' and 机房号='"+roomid+"'";
			String sql2 = "select * from course_do where 周次 = '"+week+"' and 星期数 = '"+day+"' and 节数 = '"+time+"' and 任课教师编号='"+teacherid+"'";
			String sql3 = "insert into course_do(实验项目编号,名称,机房号,班级编号,周次,星期数,节数,任课教师编号) "
						+ "values ('"+experimentid+"','"+experimentname+"','"+roomid+"','"+classid+"','"+week+"','"+day+"','"+time+"','"+teacherid+"')";
			String sql4 = "select * from course_do where 周次 = '"+week+"' and 星期数 = '"+day+"' and 节数 = '"+time+"' and 班级编号='"+classid+"'";
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动
			Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
			Statement st = con.createStatement();//执行sql的对象
			Statement st2 = con.createStatement();//执行sql的对象
			Statement st3 = con.createStatement();//执行sql的对象
			Statement st4 = con.createStatement();//执行sql的对象
			ResultSet rs1 = st.executeQuery(sql1);//返回结果集1
			ResultSet rs2 = st2.executeQuery(sql2);//返回结果集2
			ResultSet rs3 = st4.executeQuery(sql4);//返回结果集3
			if(rs1.next()) {
				session.setAttribute("msg", "此机房该时间段被占用!");
				response.sendRedirect("error.jsp");
			}
			else if(rs2.next()) {
				session.setAttribute("msg", "此教师该时间段有课!");
				response.sendRedirect("error.jsp");
			}
			else if(rs3.next()) {
				session.setAttribute("msg", "此班级该时间段有课!");
				response.sendRedirect("error.jsp");
			}
			else if(!rs1.next()&&!rs2.next()&&!rs3.next()) {
				int n = st3.executeUpdate(sql3);
				if(n!=0) {
					session.setAttribute("msg2", "排课成功!");
					response.sendRedirect("deletesuccess.jsp");
				}else {
					session.setAttribute("msg", "排课失败!");
					response.sendRedirect("error.jsp");
				}
			}
			
			
		}catch(Exception e) {
			
		}
		
		
		
		
	}

}
