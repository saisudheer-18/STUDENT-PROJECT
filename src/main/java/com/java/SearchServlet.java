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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public SearchServlet() {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	    String s1 = request.getParameter("studentId");
	    System.out.println("Received Student ID = " + s1); // debug

	    response.setContentType("text/html");
	    PrintWriter pw = response.getWriter();

	    try {
	        PreparedStatement pstmt = con.prepareStatement("select * from students where studentId=?");
	        pstmt.setString(1, s1);
	        ResultSet rs = pstmt.executeQuery();
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int colCount = rsmd.getColumnCount();
	        pw.println("<html><body bgcolor='pink'>");
	        
	        pw.println("<center>");
	        pw.println("<h1 >THE RESULT OF THE SERACH ID IS:</h1>");
	        pw.println("<table border='1' cellpadding='5' cellspacing='0'>");

	        pw.println("<tr>");
	        for (int i = 1; i <= colCount; i++) {
	            pw.println("<th>" + rsmd.getColumnName(i) + "</th>");
	        }
	        pw.println("</tr>");

	        boolean found = false;
	        while (rs.next()) {
	            found = true;
	            pw.println("<tr>");
	            for (int i = 1; i <= colCount; i++) {
	                pw.println("<td>" + rs.getString(i) + "</td>");
	            }
	            pw.println("</tr>");
	        }

	        if (!found) {
	            pw.println("<tr><td colspan='" + colCount + "'>No record found!</td></tr>");
	        }

	        pw.println("</table>");
	        pw.println("</center>");
	        pw.println("</body></html>");
	        rs.close();
	        con.close();
	        

	    } catch (SQLException e) {
	        e.printStackTrace();
	        pw.println("<h3>Error: " + e.getMessage() + "</h3>");
	    }
	}

}