package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.CustomerDao;

@WebServlet("/CustomerTransactionServlet")
public class CustomerTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerDao customerDao = new CustomerDao();
	
    public CustomerTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
				PrintWriter out = response.getWriter();
				
				int ac = Integer.parseInt(request.getParameter("acno"));
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try(Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "student", "student");
						Statement myStat = myConn.createStatement()) {
					ResultSet rs = myStat.executeQuery("select dateoftx,credit,withdrawl from transactiondata where acno="+ac);
					while(rs.next()) {
						out.printf(rs.getInt("acno")+ "\t"+rs.getString("dateoftx")+ "\t"+rs.getInt("credit")+ "\t"+rs.getInt("withdrawl"));
						out.println();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				out.println("<html><body>");
				out.println("<form action='/transaction.jsp'>");
				out.println("<input type='submit' value='Next'/>");
				out.println("</form></body></html>");


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
