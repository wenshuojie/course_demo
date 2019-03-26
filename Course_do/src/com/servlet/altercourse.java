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
 * Servlet implementation class altercourse
 */
public class altercourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public altercourse() {
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
		request.setCharacterEncoding("utf-8");//���ñ���
		PrintWriter out = response.getWriter();//���������
		HttpSession session=request.getSession();//session����
		String url = "jdbc:mysql://localhost/course_do_system";
		
		String courseid = (String)session.getAttribute("courseid");
		String coursename =(String)session.getAttribute("coursename");
		String time = request.getParameter("time");
		String teacherid = request.getParameter("teacherid");
		out.println(coursename);
		if(courseid.equals("")||coursename.equals("")||time.equals("")||teacherid.equals("")) {
			session.setAttribute("msg", "��Ϣ��������");
			response.sendRedirect("error.jsp");
		}
		else {
			try {
				String sql = "update course set ��ѧʱ='"+time+"',�ον�ʦ��� = '"+teacherid+"' where �γ̺�='"+courseid+"' and �γ���='"+coursename+"'";
				Class.forName("com.mysql.jdbc.Driver");//��������
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// ��������
				Statement st = con.createStatement();//ִ��sql���
				int n = st.executeUpdate(sql);
				if(n>0) {
					session.setAttribute("msg3", "�޸Ļ�����Ϣ�ɹ���");
					response.sendRedirect("coursesuccess.jsp");
				}
				else {
					session.setAttribute("msg", "�޸Ļ�����Ϣʧ�ܣ�");
					response.sendRedirect("error.jsp");
				}
			}catch(Exception e) {
				
			}
		}
	}

}
