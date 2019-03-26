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
			Class.forName("com.mysql.jdbc.Driver");//��������
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//of init
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");//���ñ���
		PrintWriter out = response.getWriter();//���������
		HttpSession session=request.getSession();//session����
		
		String user = request.getParameter("userid");
		String pwd = request.getParameter("password");//��ȡ�û���������
		String url = "jdbc:mysql://localhost/course_do_system";
		
		
		if(user.equals("")||pwd.equals("")) {
			session.setAttribute("msg", "�˺Ż�����Ϊ��");
			response.sendRedirect("error.jsp");
		}
		else {
			try {
				String sql = "select * from teacher where �˺�='" + user + "' and ����='" + pwd + "'";
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// ��������
				Statement st = con.createStatement();//ִ��sql���
				ResultSet rs = st.executeQuery(sql);//���ؽ����
				if(!rs.next()) {
					session.setAttribute("msg","�˺��������");
					response.sendRedirect("error.jsp");
				}
				else {
					
					session.setAttribute("user", rs.getString("����"));
					session.setAttribute("userid", rs.getString("��ʦ��"));//����¼�û�����session
					if(rs.getString("����").equals("����Ա")) {
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
