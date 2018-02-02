/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*; 

/**
 *
 * @author Krisz
 */
@WebServlet("/Login")
public class Controller extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String username = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");
           try
           {
               if(username!=null)
               {
                   Class.forName("com.mysql.jdbc.Driver").newInstance();
                   Connection conn = DriverManager.getConnection("jdbc:mysql//localhost:3306/namedb","root","admin");
                   String Query="Select * from tableLogin where username=? and password=?";
                   PreparedStatement psm = conn.prepareStatement(Query);
                   psm.setString(1, username);
                   psm.setString(1, password);
                   ResultSet rs = psm.executeQuery();
                   if(rs.next())
                   {
                       response.sendRedirect("Welcome.jsp");
                   }
                   else 
                   {
                       out.println("Acces Denied!");
                   }
               }
           }
           catch(Exception ex)
           {
               out.println("Exception: "+ex.getMessage());
           }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
