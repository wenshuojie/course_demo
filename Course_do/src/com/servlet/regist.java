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
		
		request.setCharacterEncoding("utf-8");//���ñ���
		PrintWriter out = response.getWriter();//���������
		HttpSession session=request.getSession();//session����
		
		String url = "jdbc:mysql://localhost/course_do_system";
		
		String teacherID = request.getParameter("teacherID");
		String username = request.getParameter("username");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String techertype = request.getParameter("techertype");//��ȡ����Ϣ
		
		if(teacherID.equals("")||username.equals("")||userid.equals("")||password.equals("")||repassword.equals("")||techertype.equals("")) {
			session.setAttribute("msg", "��Ϣ��������");
			response.sendRedirect("error.jsp");
		}
		else if(!password.equals(repassword)) {
			session.setAttribute("msg", "�������벻ƥ�䣡");
			response.sendRedirect("error.jsp");
		}
		else {
			try {
				String sql1 = "select * from teacher where �˺�='" + userid + "'";
				Class.forName("com.mysql.jdbc.Driver");// ��������
				Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// ��������
				Statement st = con.createStatement();//ִ��sql���
				ResultSet rs = st.executeQuery(sql1);//���ؽ����
				if(rs.next()) {
					session.setAttribute("msg", "�û��Ѿ����ڣ�");
					response.sendRedirect("error.jsp");
				}else {
					String sql2 = "insert into teacher(��ʦ��,����,�˺�,����,����) values('"+teacherID+"','"+username+"','"+userid+"','"+password+"','"+techertype+"')";
					int n=st.executeUpdate(sql2);
					if(n!=0) {
						session.setAttribute("msg1", "ע��ɹ�");
						response.sendRedirect("success.jsp");
					}
					else {
						session.setAttribute("msg", "ע��ʧ��");
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
