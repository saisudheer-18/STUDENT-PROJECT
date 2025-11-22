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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@WebServlet("/DeleteByID")

public class DeleteByID extends GenericServlet {
    private static final long serialVersionUID = 1L;
    Connection con;

    public void init(ServletConfig config) throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/43r", "root", "root18");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String s1 = request.getParameter("studentId");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM students WHERE studentId=?");
            pstmt.setString(1, s1);

            int rows = pstmt.executeUpdate();

            pw.println("<html><body style='text-align:center; font-family:Arial;'>");

            if (rows > 0) {
                pw.println("<h2 style='color:green;'> Student Deleted Successfully</h2>");
                
            } else {
                pw.println("<h2 style='color:red;'>Student ID Not Found</h2>");
            }

            pw.println("<br><a href='deleteStudent.html'>Go Back</a>");
            pw.println("</body></html>");

        } catch (SQLException e) {
            e.printStackTrace();
            pw.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
