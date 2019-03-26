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
		
		request.setCharacterEncoding("utf-8");//���ñ���
		PrintWriter out = response.getWriter();//���������
		HttpSession session=request.getSession();//session����

		
		String url = "jdbc:mysql://localhost/course_do_system";
		
		String courseid = request.getParameter("courseid");
		String coursename = request.getParameter("coursename");
		String experimentid = request.getParameter("experimentid");
		String experimentname = request.getParameter("experimentname");
		String totalhour = request.getParameter("totalhour");
		String exhour = request.getParameter("exhour");
		String classid = request.getParameter("classid");//��ȡ����Ϣ
		
		
		if(courseid.equals("")||coursename.equals("")||experimentid.equals("")||experimentname.equals("")||totalhour.equals("")||exhour.equals("")||classid.equals("")) {
			session.setAttribute("msg", "��Ϣ��������");
			response.sendRedirect("error.jsp");
		}
		else {
			String sql2 = "insert into experiment(ʵ����Ŀ���,����,ѧʱ,�ον�ʦ���,�γ̺�,�༶���) "
						+ "values('"+experimentid+"','"+experimentname+"','"+exhour+"','"+(String)session.getAttribute("userid")+"','"+courseid+"','"+classid+"')";
			String sql3 = "select * from experiment where ʵ����Ŀ���='"+experimentid+"' and �γ̺�='"+courseid+"'";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");// ��������
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// ��������
				Statement st = con.createStatement();//ִ��sql���
				ResultSet rs = st.executeQuery(sql3);//���ؽ����
				if(rs.next()) {
					session.setAttribute("msg", "�γ�ʵ���Ѿ����ڣ�");
					response.sendRedirect("error.jsp");
				}
				else {
					int s = st.executeUpdate(sql2);
					if(s!=0) {
						session.setAttribute("msg1", "����ɹ����������ĵȴ�����Ա�ſ�");
						response.sendRedirect("application_success.jsp");
					}
					else {
						session.setAttribute("msg", "����ʧ�ܣ�������������");
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
