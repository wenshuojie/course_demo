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
 * Servlet implementation class regist
 */

public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regist() {
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
		
		request.setCharacterEncoding("utf-8");//设置编码
		PrintWriter out = response.getWriter();//输出流对象
		HttpSession session=request.getSession();//session对象
		
		String url = "jdbc:mysql://localhost/course_do_system";
		
		String teacherID = request.getParameter("teacherID");
		String username = request.getParameter("username");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String techertype = request.getParameter("techertype");//获取表单信息
		
		if(teacherID.equals("")||username.equals("")||userid.equals("")||password.equals("")||repassword.equals("")||techertype.equals("")) {
			session.setAttribute("msg", "信息不完整！");
			response.sendRedirect("error.jsp");
		}
		else if(!password.equals(repassword)) {
			session.setAttribute("msg", "两次密码不匹配！");
			response.sendRedirect("error.jsp");
		}
		else {
			try {
				String sql1 = "select * from teacher where 账号='" + userid + "'";
				Class.forName("com.mysql.jdbc.Driver");// 加载驱动
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// 建立连接
				Statement st = con.createStatement();//执行sql语句
				ResultSet rs = st.executeQuery(sql1);//返回结果集
				if(rs.next()) {
					session.setAttribute("msg", "用户已经存在！");
					response.sendRedirect("error.jsp");
				}else {
					String sql2 = "insert into teacher(教师号,姓名,账号,密码,类型) values('"+teacherID+"','"+username+"','"+userid+"','"+password+"','"+techertype+"')";
					int n=st.executeUpdate(sql2);
					if(n!=0) {
						session.setAttribute("msg1", "注册成功");
						response.sendRedirect("success.jsp");
					}
					else {
						session.setAttribute("msg", "注册失败");
						response.sendRedirect("error.jsp");
					}
					rs.close();
					st.close();
					con.close();
				}
			}catch(Exception e) {
				
			}
		}
		doGet(request, response);
	}

}
