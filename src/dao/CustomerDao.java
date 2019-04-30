package dao;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.transaction;
import resources.CustomerDaoI;


public class CustomerDao extends dbconnection_abstract {

	public Customer checkExistingAccount(int ssn, String cardNo ) throws Exception {
		myconnection();
		ps = con.prepareStatement(CustomerDaoI.existingAccount);
		ps.setInt(1, ssn);
		ps.setString(2, cardNo);
		rs = ps.executeQuery();
		Customer c = new Customer();
		if(rs.next()) {
			c.setFirstName(rs.getString(1));
			c.setMiddleName(rs.getString(2));
			c.setLastName(rs.getString(3));
			c.setSsn(rs.getInt(4));
			c.setCardNo(rs.getString(5));
			c.setApt(rs.getString(6));
			c.setStreet(rs.getString(7));
			c.setCity(rs.getString(8));
			c.setState(rs.getString(9));
			c.setCounty(rs.getString(10));
			c.setZip(rs.getString(11));
			c.setCustPhone(rs.getInt(12));
			c.setEmail(rs.getString(13));
			c.setlastUpdated(rs.getTimestamp(14));
			
			return c;
		}		
		return null;
	}
	
	public Customer updateCustomerAccount(String colum_name, String new_value, int new_intValue , int ssn, String cardNo) throws Exception{
		myconnection();
		ps =con.prepareStatement((CustomerDaoI.updateExistingValue) +colum_name+(CustomerDaoI.updateToNewValue));
		if (colum_name== "cust_phone"){
				ps.setInt(1, new_intValue);
		}
		else 
			ps.setString(1, new_value);
		
		ps.setInt(2, ssn);
		ps.setString(3, cardNo);
		ps.executeUpdate();
		
		return null;
	}
	
	
	
	public Customer generateMonthlyBill(String cardNo, int month, int year) throws Exception {
		myconnection();
		ps = con.prepareStatement(CustomerDaoI.monthlyBill);
		ps.setString(1, cardNo);
		ps.setInt(2, month);
		ps.setInt(3, year);
		rs = ps.executeQuery();
		Customer c = new Customer();
		while(rs.next()) {
			c.setFirstName(rs.getString(1));
			c.setLastName(rs.getString(2));
			c.setValue(rs.getDouble(3));
			return c;
		}		
		return null;
	}
	
	public List<transaction> getTransactionBetweenDates(int ssn, String cardNo, String startDate, String endDate) throws Exception{
		List<transaction> lbd = new ArrayList <transaction>();
		myconnection();
		ps = con.prepareStatement(CustomerDaoI.betweenTwoDates);
		ps.setInt(1, ssn);
		ps.setString(2, cardNo);
		ps.setString(3, startDate);
		ps.setString(4, endDate);
		rs = ps.executeQuery();
	
		while(rs.next()) {
			transaction t =new transaction();
			t.setId(rs.getInt(1));
			t.setDay(rs.getInt(2));
			t.setMonth(rs.getInt(3));
			t.setYear(rs.getInt(4));
			t.setCardNo(rs.getString(5));
			t.setSsn(rs.getInt(6));
			t.setBranchCode(rs.getInt(7));
			t.setType(rs.getString(8));
			t.setTransaction_Value(rs.getDouble(9));
			
			lbd.add(t);
		}		
		return lbd;
	}
}
