package com.java;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/43r","root","root18");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=request.getParameter("studentId");
		String s2=request.getParameter("studentName");
		String s3=request.getParameter("email");
		String s4=request.getParameter("course");
		String s5=request.getParameter("age");
		
		PrintWriter pw=response.getWriter();
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into students values(?,?,?,?,?)");
			pstmt.setString(1,s1);
			pstmt.setString(2, s2);
			pstmt.setString(3,s3);
			pstmt.setString(4,s4);
			pstmt.setString(5, s5);
			pstmt.executeUpdate();
			pw.println("<body bgcolor=pink>");
			pw.println("<h1>data updated Successfully</h1>");
			pw.println("</body>");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
