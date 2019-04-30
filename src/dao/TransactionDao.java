package dao;

import model.transaction;

import java.util.ArrayList;
import java.util.List;
import resources.TransactionDaoI;

public class TransactionDao extends dbconnection_abstract {
	public transaction gettotalbyType(String type) throws Exception {
		myconnection();
		ps = con.prepareStatement(TransactionDaoI.totalByType);
		ps.setString(1, type);
		rs = ps.executeQuery();
		transaction t = new transaction();
		if(rs.next()) {
			t.setTransaction_Value(rs.getDouble(1));
			t.setCount(rs.getInt(2));
			return t;
		}		
		return null;
	}
	
	public List <transaction> getdisplayByZip(String zip, int year, int month) throws Exception {
		List<transaction> listByZip = new ArrayList <transaction>();
		
		myconnection();
		ps = con.prepareStatement(TransactionDaoI.displayByZip);
		ps.setString(1, zip);
		ps.setInt(2, year);
		ps.setInt(3, month);
		
		rs = ps.executeQuery();
		while(rs.next()) {
		
			transaction tbyz = new transaction();
			tbyz.setId(rs.getInt(1));
			tbyz.setDay(rs.getInt(2));
			tbyz.setMonth(rs.getInt(3));
			tbyz.setYear(rs.getInt(4));
			tbyz.setCardNo(rs.getString(5));
			tbyz.setSsn(rs.getInt(6));
			tbyz.setBranchCode(rs.getInt(7));
			tbyz.setType(rs.getString(8));
			tbyz.setTransaction_Value(rs.getDouble(9));
			
			listByZip.add(tbyz);
		}		
		return listByZip;
	}
	public transaction gettotalbyState(String state) throws Exception {
		myconnection();
		ps = con.prepareStatement(TransactionDaoI.displayByState);
		ps.setString(1, state);
		rs = ps.executeQuery();
		transaction t = new transaction();
		if(rs.next()) {
			t.setTransaction_Value(rs.getDouble(1));
			t.setCount(rs.getInt(2));
			
			return t;
		}		
		return null;
	}
}