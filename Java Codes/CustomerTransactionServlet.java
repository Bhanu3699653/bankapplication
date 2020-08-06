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
 * Servlet implementation class CustomerTransactionServlet
 */
@WebServlet("/CustomerTransactionServlet")
public class CustomerTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CustomerTransactionServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor=lightblue>");
			//out.println("trying the jdbc connection<br>");
				int a  = Integer.parseInt(request.getParameter("acno"));
				HttpSession Session=request.getSession();
				Session.setAttribute("acno",a);
				try {
					
					DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
				
				try(Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "Naveenreddy@24");
						Statement myStat = myConn.createStatement()) {
					
					out.println("Connectecd successfully<br>");
					out.println("<h1>Transactions</h1><br>");
					out.println("<h3>"+"Dateoftx"+ "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+"Credit"+ "\t&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+"Withdrawl"+"</h3><br>");
					ResultSet rs = myStat.executeQuery("select dateoftx,credit,withdrawl from transactiondata where acno="+a);
					while(rs.next()) {
						//out.println("<pre>");
						out.println("<pre>"+rs.getString("dateoftx")+ "\t"+rs.getInt("credit")+ "\t&nbsp&nbsp&nbsp&nbsp"+rs.getInt("withdrawl")+"<br>");
						out.println("\n");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				out.println("<form action='/Practice/transaction.jsp'>");
				out.println("<input type='submit' value='Next'/>");
				out.println("</form></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
