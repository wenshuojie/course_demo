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
		request.setCharacterEncoding("utf-8");//���ñ���
		PrintWriter out = response.getWriter();//���������
		HttpSession session=request.getSession();//session����
		String url = "jdbc:mysql://localhost/course_do_system";
		
		String classid = (String)session.getAttribute("classid");;
		String major = request.getParameter("major");
		String grade = request.getParameter("grade");
		String banji = request.getParameter("banji");
		String p_num = request.getParameter("p_num");//��ȡ��
		if(major.equals("")||grade.equals("")||p_num.equals("")||banji.equals("")) {
			session.setAttribute("msg", "��Ϣ��������");
			response.sendRedirect("error.jsp");
		}
		else {
			
			try {
				String sql = "update class set רҵ='"+major+"',�꼶='"+grade+"',����='"+p_num+"',�༶='"+banji+"' where �༶���='"+classid+"'";
				Class.forName("com.mysql.jdbc.Driver");//��������
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// ��������
				Statement st = con.createStatement();//ִ��sql���
				int n = st.executeUpdate(sql);
				if(n>0) {
					session.setAttribute("msg2", "�޸İ༶��Ϣ�ɹ���");
					response.sendRedirect("classsuccess.jsp");
				}
				else {
					session.setAttribute("msg", "�޸İ༶��Ϣʧ�ܣ�");
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
