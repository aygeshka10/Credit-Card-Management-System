package runner;


import java.util.List;
import java.util.Scanner;

import dao.TransactionDao;
import model.transaction;

public class Tranaction_runnable {
	TransactionDao td = new TransactionDao();
	Scanner sc = new Scanner(System.in);
	
	

	public void getdisplayByZip() throws Exception {	
		String zip = "";
		Integer year = 0;
		Integer month =0;
		boolean success = false;
		boolean successYear = false;
		boolean successMonth=false;
		while (success == false) {
			System.out.println("Please enter zip:");
			try {
				zip = sc.nextLine();
				Integer.parseInt(zip);
				if (zip.length()==5) {
				success = true;}
				else {throw new Exception(); }
			}catch(Exception e) {
				System.out.println("Invalid zip");
				success = false;
			}
		}
		
		while (successYear == false) {
			System.out.println("Please enter year:");
			try {
				 year = Integer.valueOf(sc.nextLine());
		
				int length = String.valueOf(year).length();
				if (length==4) {
				successYear = true;}
				else {throw new Exception(); }
			}catch(Exception e) {
				System.out.println("Invalid year! Please enter in YYYY format.");
				successYear = false;
			}
		}
		
		while (successMonth==false) {
		try {
		System.out.println("Please enter month:");
		month = Integer.valueOf(sc.nextLine());
		if (month<1||month>12) {
		
		throw new Exception();}
		else {successMonth = true;}
		} catch (Exception e) {
			System.out.println("Invalid month! Please enter from 1 to 12.");
			successMonth = false;
		}
		}
		
		
		List<transaction> mytransaction1 = td.getdisplayByZip(zip, year, month);
		
		if(mytransaction1.isEmpty()) {
			System.out.println("No output is found for these inputs:");
		}
		else {
		System.out.printf("%-10s%-10s%-10s%-10s%-20s%-20s%-20s%-20s%-20s","ID","Day", "Month","Year", "Card Number", "SSN",  "Branch Code", "Transaction Type", "Transaction Value");
		System.out.println("");
		
		for (transaction tbyz : mytransaction1) {
			System.out.printf("%-10d%-10d%-10d%-10d%-20s%-20d%-20d%-20s%-20.2f%n", tbyz.getId(), tbyz.getDay(), tbyz.getMonth(), tbyz.getYear(), tbyz.getCardNo(), tbyz.getSsn(), tbyz.getBranchCode(), tbyz.getType(), tbyz.getTransaction_Value());
		}
	
		}
	}
	
	
	public void getTotalByType() throws Exception {	
		String type="";
		
		boolean successType =false;
		while (successType==false) {
			try {
				System.out.println("Please enter transaction Type:");
				
				type = sc.nextLine();
				TransactionDao td = new TransactionDao();
				transaction mytransaction = td.gettotalbyType(type);
			
				mytransaction.getCount();
				if ( mytransaction.getCount() > 0 ) {
					System.out.println(mytransaction.getCount());
					System.out.println(mytransaction.getTransaction_Value());
					successType=true;}
				else { throw new NullPointerException();}
			} catch( java.lang.NullPointerException e) {
				System.out.println("The type you enter is incorrect. Please enter existing type.");
				successType=false;
			}
	}
	}
	
	public void getTotalByState() throws Exception {
		
		boolean successState=false;
		while (successState==false) {
		try {
		System.out.println("Please enter state:");
		
		String state = sc.nextLine();
		
		transaction mytransaction = td.gettotalbyState(state);
		if (mytransaction.getCount() > 0) {
		System.out.println("Number of transactions: " +mytransaction.getCount());
		System.out.println("Total values of transactions: " +mytransaction.getTransaction_Value());
		successState=true;
		}
		else {throw new Exception ();}
		}catch (Exception e) {
			System.out.println("Incorrect state! Please try again!");
			successState=false;
		}
		}
		}
	
}


	

