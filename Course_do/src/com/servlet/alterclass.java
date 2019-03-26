package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class alterclass
 */
public class alterclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterclass() {
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
		
		String classid = (String)session.getAttribute("classid");;
		String major = request.getParameter("major");
		String grade = request.getParameter("grade");
		String banji = request.getParameter("banji");
		String p_num = request.getParameter("p_num");//获取表单
		if(major.equals("")||grade.equals("")||p_num.equals("")||banji.equals("")) {
			session.setAttribute("msg", "信息不完整！");
			response.sendRedirect("error.jsp");
		}
		else {
			
			try {
				String sql = "update class set 专业='"+major+"',年级='"+grade+"',人数='"+p_num+"',班级='"+banji+"' where 班级编号='"+classid+"'";
				Class.forName("com.mysql.jdbc.Driver");//加载驱动
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
				Statement st = con.createStatement();//执行sql语句
				int n = st.executeUpdate(sql);
				if(n>0) {
					session.setAttribute("msg2", "修改班级信息成功！");
					response.sendRedirect("classsuccess.jsp");
				}
				else {
					session.setAttribute("msg", "修改班级信息失败！");
					response.sendRedirect("error.jsp");
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
