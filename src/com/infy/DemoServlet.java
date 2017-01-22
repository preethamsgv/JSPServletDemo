package com.infy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet Get</h1>");
		out.println("</body>");
		out.println("</html>");
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection conn=null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\sqlite-tools-win32-x86-3160200\\touchDb.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Statement stat=null;
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        ResultSet rs=null;
		try {
			rs = stat.executeQuery("select * from COMPANY;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
			while (rs.next()) {
			    out.println("<tr>");
			    out.println("<td>" + rs.getString("ID") + "</td>");
			    out.println("<td>" + rs.getString("NAME") + "</td>");
			    out.println("<td>" + rs.getString("AGE") + " kr.</td>");
			    out.println("<td>" + rs.getString("ADDRESS") + "</td>");
			    out.println("</tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
