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
 * Servlet implementation class addroom
 */
public class addroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addroom() {
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
		
		String roomid = request.getParameter("roomid");
		
		String p_num = request.getParameter("p_num");
		String eq_num = request.getParameter("eq_num");
		String eq_type = request.getParameter("eq_type");//获取表单
		out.println(eq_type);
		String sql = "select * from room where 机房号='"+roomid+"'";
		if(roomid.equals("")||p_num.equals("")||eq_num.equals("")||eq_type.equals("")) {
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
					session.setAttribute("msg", "重复机房信息！");
					response.sendRedirect("error.jsp");					
				}
				else {
					String sql2 = "insert into room(机房号,容纳人数,设备套数,设备类型) "
							   + "values('"+roomid+"','"+p_num+"','"+eq_num+"','"+eq_type+"')";
					int n =	st.executeUpdate(sql2);
					if(n!=0) {
						session.setAttribute("msg3", "添加机房信息成功！");
						response.sendRedirect("roomsuccess.jsp");
					}
					else {
						session.setAttribute("msg", "添加机房信息失败！");
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
