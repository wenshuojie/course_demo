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
 * Servlet implementation class alterroom
 */
public class alterroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterroom() {
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
		
		String roomid = (String)session.getAttribute("id");;
		
		String p_num = request.getParameter("p_num");
		String eq_num = request.getParameter("eq_num");
		String eq_type = request.getParameter("eq_type");//获取表单
		
		if(p_num.equals("")||eq_num.equals("")||eq_type.equals("")) {
			session.setAttribute("msg", "信息不完整！");
			response.sendRedirect("error.jsp");
		}
		else {
			try {
				String sql = "update room set 容纳人数='"+p_num+"',设备套数='"+eq_num+"',设备类型='"+eq_type+"' where 机房号='"+roomid+"'";
				Class.forName("com.mysql.jdbc.Driver");//加载驱动
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
				Statement st = con.createStatement();//执行sql语句
				int n = st.executeUpdate(sql);
				if(n>0) {
					session.setAttribute("msg3", "修改机房信息成功！");
					response.sendRedirect("roomsuccess.jsp");
				}
				else {
					session.setAttribute("msg", "修改机房信息失败！");
					response.sendRedirect("error.jsp");
				}
			}catch(Exception e) {
				
			}
		}
	}

}
