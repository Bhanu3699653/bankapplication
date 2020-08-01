package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.example.model.Customer;

public class CustomerDao {
	
	public int customerdb(Customer customer) throws ClassNotFoundException {
		String str3 = "insert into transactiondata values(?,?,?,?);";
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "student", "student");
				PreparedStatement ps = myConn.prepareStatement(str3)) {
			
			//ps.setInt(1,customer.getAcno());
			
			  ps.setInt(1,customer.getAcno());
			  ps.setString(2,customer.getDateoftx());
			  ps.setInt(3,customer.getCredit());
			  ps.setInt(4,customer.getWithdraw());
			  
			 
			System.out.println(ps);
			
			result = ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}

		return result;
	}

}
