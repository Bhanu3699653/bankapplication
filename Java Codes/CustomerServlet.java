package com.nani;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao = new CustomerDao();
    /**
     * Default constructor. 
     */
    public CustomerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int acno = Integer.parseInt(request.getParameter("acno"));
		  String dateoftx = request.getParameter("dateoftx");
		  int credit = Integer.parseInt(request.getParameter("credit"));
		  int withdrawl = Integer.parseInt(request.getParameter("withdrawl"));
		  HttpSession session=request.getSession();
		  session.getAttribute("acno");
		Customer customer = new Customer();
		customer.setAcno(acno);
		customer.setDateoftx(dateoftx);
		customer.setCredit(credit);
		customer.setWithdraw(withdrawl);
		try {
			customerDao.customerdb(customer);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/transaction.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
