<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>

<html lang="en">
    <head>
        <title>SQLite Demo</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Item No.</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
            <%
                Class.forName("org.sqlite.JDBC");
            
                Connection conn =
                     DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\sqlite-tools-win32-x86-3160200\\touchDb.db");
                Statement stat = conn.createStatement();
 
                ResultSet rs = stat.executeQuery("SELECT * FROM COMPANY;");
 
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("ID") + "</td>");
                    out.println("<td>" + rs.getString("NAME") + "</td>");
                    out.println("<td>" + rs.getString("AGE") + " kr.</td>");
                    out.println("<td>" + rs.getString("ADDRESS") + "</td>");
                    out.println("</tr>");
                }
 
                rs.close();
                conn.close();
            %>
            </tbody>
        </table>
    </body>
</html>