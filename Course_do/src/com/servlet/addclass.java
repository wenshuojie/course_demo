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
 * Servlet implementation class addclass
 */
public class addclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addclass() {
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
		
		String classid = request.getParameter("classid");
		String major = request.getParameter("major");
		String grade = request.getParameter("grade");
		String banji = request.getParameter("banji");
		String p_num = request.getParameter("p_num");//��ȡ��
		out.println(major);
		String sql = "select * from class where �༶���='"+classid+"'";
		
		if(classid.equals("")||major.equals("")||grade.equals("")||p_num.equals("")||banji.equals("")) {
			session.setAttribute("msg", "��Ϣ��������");
			response.sendRedirect("error.jsp");
		}
		else {
			try {
				Class.forName("com.mysql.jdbc.Driver");//��������
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// ��������
				Statement st = con.createStatement();//ִ��sql���
				ResultSet rs = st.executeQuery(sql);//���ؽ����
				
				if(rs.next()) {
					session.setAttribute("msg", "�ظ�������Ϣ��");
					response.sendRedirect("error.jsp");					
				}
				else {
					String sql2 = "insert into class(�༶���,רҵ,�꼶,����,�༶) "
							   + "values('"+classid+"','"+major+"','"+grade+"','"+p_num+"','"+banji+"')";
					int n =	st.executeUpdate(sql2);
					if(n!=0) {
						session.setAttribute("msg2", "��Ӱ༶��Ϣ�ɹ���");
						response.sendRedirect("classsuccess.jsp");
					}
					else {
						session.setAttribute("msg", "��Ӱ༶��Ϣʧ�ܣ�");
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
