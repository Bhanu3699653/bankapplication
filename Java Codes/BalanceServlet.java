package com.nani;

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
 * Servlet implementation class BalanceServlet
 */
@WebServlet("/BalanceServlet")
public class BalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BalanceServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<body bgcolor=lightblue>");
		//String str1 = "select acno, sum(credit)-sum(withdrawl) as balance from transactiondata where acno="+a;
		HttpSession Session=request.getSession();
		int acno=(int) Session.getAttribute("acno");
				try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "Naveenreddy@24");
				Statement myStat = myConn.createStatement()) {
			out.println("<h1>Your Account Balance is</h1>");
			HttpSession session = request.getSession();
			ResultSet rs1 = myStat.executeQuery("select sum(credit)-sum(withdrawl) as balance from transactiondata where acno="+acno);
			while(rs1.next()) {
				out.println("<h2>"+rs1.getInt("balance")+"</h2><br>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		out.println("<form action='/Practice/transaction.jsp'>");
		out.println("<input type='submit' value='Back'/>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
