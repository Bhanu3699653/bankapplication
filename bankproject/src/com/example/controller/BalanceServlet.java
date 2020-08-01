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

@WebServlet("/BalanceServlet")
public class BalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
				PrintWriter out = response.getWriter();
		
				String str1 = "select acno, sum(credit)-sum(withdrawl) as balance from transactiondata group by acno";
				
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try(Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "student", "student");
						Statement myStat = myConn.createStatement()) {
					
					out.println("<h4>Your Account Balance is</h4>");
					ResultSet rs1 = myStat.executeQuery("select acno, sum(credit)-sum(withdrawl) as balance from transactiondata group by acno");
					while(rs1.next()) {
						out.println(rs1.getInt("acno")+ "\t"+rs1.getInt("balance"));
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				out.println("<html><body>");
				out.println("<form action='/transaction.jsp'>");
				out.println("<input type='submit' value='Next'/>");
				out.println("</form></body></head>");
				

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
