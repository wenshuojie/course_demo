package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class docourse
 */
public class docourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public docourse() {
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
		
		String experimentid = (String)session.getAttribute("experimentid");
		String experimentname = (String)session.getAttribute("experimentname");
		String teacherid = (String)session.getAttribute("teacherid");
		String week = request.getParameter("week");
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		String roomid = request.getParameter("roomid");
		String classid = (String)session.getAttribute("classid");
		
		if(week.equals("")||day.equals("")||time.equals("")||roomid.equals("")||classid.equals("")) {
			session.setAttribute("msg", "��Ϣ��������");
			response.sendRedirect("error.jsp");
		}
		
		try {
			String sql1 = "select * from course_do where �ܴ� = '"+week+"' and ������ = '"+day+"' and ���� = '"+time+"' and ������='"+roomid+"'";
			String sql2 = "select * from course_do where �ܴ� = '"+week+"' and ������ = '"+day+"' and ���� = '"+time+"' and �ον�ʦ���='"+teacherid+"'";
			String sql3 = "insert into course_do(ʵ����Ŀ���,����,������,�༶���,�ܴ�,������,����,�ον�ʦ���) "
						+ "values ('"+experimentid+"','"+experimentname+"','"+roomid+"','"+classid+"','"+week+"','"+day+"','"+time+"','"+teacherid+"')";
			String sql4 = "select * from course_do where �ܴ� = '"+week+"' and ������ = '"+day+"' and ���� = '"+time+"' and �༶���='"+classid+"'";
			Class.forName("com.mysql.jdbc.Driver");// ��������
			Connection con = DriverManager.getConnection(url + "?user=root&password=&characterEncoding=utf-8");// ��������
			Statement st = con.createStatement();//ִ��sql�Ķ���
			Statement st2 = con.createStatement();//ִ��sql�Ķ���
			Statement st3 = con.createStatement();//ִ��sql�Ķ���
			Statement st4 = con.createStatement();//ִ��sql�Ķ���
			ResultSet rs1 = st.executeQuery(sql1);//���ؽ����1
			ResultSet rs2 = st2.executeQuery(sql2);//���ؽ����2
			ResultSet rs3 = st4.executeQuery(sql4);//���ؽ����3
			if(rs1.next()) {
				session.setAttribute("msg", "�˻�����ʱ��α�ռ��!");
				response.sendRedirect("error.jsp");
			}
			else if(rs2.next()) {
				session.setAttribute("msg", "�˽�ʦ��ʱ����п�!");
				response.sendRedirect("error.jsp");
			}
			else if(rs3.next()) {
				session.setAttribute("msg", "�˰༶��ʱ����п�!");
				response.sendRedirect("error.jsp");
			}
			else if(!rs1.next()&&!rs2.next()&&!rs3.next()) {
				int n = st3.executeUpdate(sql3);
				if(n!=0) {
					session.setAttribute("msg2", "�ſγɹ�!");
					response.sendRedirect("deletesuccess.jsp");
				}else {
					session.setAttribute("msg", "�ſ�ʧ��!");
					response.sendRedirect("error.jsp");
				}
			}
			
			
		}catch(Exception e) {
			
		}
		
		
		
		
	}

}
