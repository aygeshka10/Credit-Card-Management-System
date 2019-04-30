package runner;

import java.lang.Exception;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dao.CustomerDao;
import model.Customer;
import model.transaction;

public class Customer_runnable {
	Scanner sc = new Scanner(System.in);
	CustomerDao cd = new CustomerDao();
	
	public void checkExistingAccount() throws Exception {	
		Integer ssn=0;
		String cardNo="";
		String ssnString="";
		boolean ssnValid=false;
		boolean cardNoValid=false;
		
		while(ssnValid==false) {
			try {
				System.out.println("Please enter customer ssn:");
				
				ssnString = sc.next();
				
				if(ssnString.length() !=9 ) {
					throw new IndexOutOfBoundsException();	
				}
				else if(!ssnString.matches("[0-9]*")) {
					throw new Exception();
				}
				else{ssnValid=true;}
				}catch(IndexOutOfBoundsException e) 
				{System.out.println("The length should be 9 digits.");
				ssnValid=false;
				
				}catch(Exception e) {
					System.out.println("Invalid ssn. Please try again.");
					ssnValid=false;
				}
		}
		
		while(cardNoValid==false) {
			try {
				System.out.println("Please enter customer card number:");
				cardNo = sc.next();
				if(cardNo.length()!=16) {
					throw new NullPointerException();
				}
				if(!cardNo.matches("[0-9]*")) {
					throw new Exception();
				}else {cardNoValid=true;}
				} catch(NullPointerException e) {
					System.out.println("Invalid card number. Card number should have 16 digits. Please try again.");
					cardNoValid=false;
				}catch(Exception e) {
					System.out.println("Invalid card number. Please try again.");
					cardNoValid=false;
				}
		}
		ssn = Integer.parseInt(ssnString);
		Customer ecustomer = cd.checkExistingAccount(ssn, cardNo);
		try {			
		System.out.println("(1) SSN: "+ecustomer.getSsn());
		System.out.println("(2) Credit Card Number: "+ecustomer.getCardNo());
		System.out.println("(3) First Name: "+ecustomer.getFirstName());
		System.out.println("(4) Middle Name: "+ecustomer.getMiddleName());
		System.out.println("(5) Last Name: "+ecustomer.getLastName());
		System.out.println("(6) Apt No: "+ecustomer.getApt());
		System.out.println("(7) Street Name: "+ecustomer.getStreet());
		System.out.println("(8) City: "+ecustomer.getCity());
		System.out.println("(9) State: "+ecustomer.getState());
		System.out.println("(10) Country: "+ecustomer.getCounty());
		System.out.println("(11) Zip: "+ecustomer.getZip());
		System.out.println("(12) Phone Number: "+ecustomer.getCustPhone());
		System.out.println("(13) Email: "+ecustomer.getEmail());
		System.out.println("(14) Last Updated: "+ecustomer.getlastUpdated());
		}catch(NullPointerException e) {System.out.println("No output is found for these inputs:");}
			
	}
	
	public void updateCustomerAccount() throws Exception{
		
		String column_name="";
		
		String new_value="";
		int new_intValue=0;
		Integer ssn=0;
		String cardNo="";
		String ssnString="";
		boolean ssnValid=false;
		boolean cardNoValid=false;
		int option = 0;
		boolean successUpdate = false;
		
		while(ssnValid==false) {
			try {
				System.out.println("Please enter customer ssn:");
				
				ssnString = sc.next();
				
				if(ssnString.length() !=9 ) {
					throw new Exception();	
				}
				else if(!ssnString.matches("[0-9]*")) {
					throw new InputMismatchException();
				}
				else{ssnValid=true;}
				}catch(InputMismatchException e) 
				{System.out.println("The length should be 9 digits.");
				ssnValid=false;
				
				}catch(Exception e) {
					System.out.println("Invalid ssn. Please try again.");
					ssnValid=false;
				}
		}
		
		while(cardNoValid==false) {
			try {
				System.out.println("Please enter customer card number:");
				cardNo = sc.next();
				if(cardNo.length()!=16) {
					throw new NullPointerException();
				}
				if(!cardNo.matches("[0-9]*")) {
					throw new Exception();
				}else {cardNoValid=true;}
				} catch(NullPointerException e) {
					System.out.println("Invalid card number. Card number should have 16 digits. Please try again.");
					cardNoValid=false;
				}catch(Exception e) {
					System.out.println("Invalid card number. Please try again.");
					cardNoValid=false;
				}
		}
		ssn = Integer.parseInt(ssnString);
		
		Customer ecustomer = cd.checkExistingAccount(ssn, cardNo);
		try {
			if(ecustomer.getFirstName().isEmpty()) {throw new Exception();}
			else {
		while (successUpdate == false) {
			try {		
				System.out.println("Which field would you like to update?");
				System.out.println("(1) First Name: "+ecustomer.getFirstName());
				System.out.println("(2) Middle Name: "+ecustomer.getMiddleName());
				System.out.println("(3) Last Name: "+ecustomer.getLastName());
				System.out.println("(4) Apt No: "+ecustomer.getApt());
				System.out.println("(5) Street Name: "+ecustomer.getStreet());
				System.out.println("(6) City: "+ecustomer.getCity());
				System.out.println("(7) State: "+ecustomer.getState());
				System.out.println("(8) Country: "+ecustomer.getCounty());
				System.out.println("(9) Zip: "+ecustomer.getZip());
				System.out.println("(10) Phone Number: "+ecustomer.getCustPhone());
				System.out.println("(11) Email: "+ecustomer.getEmail());
				
				
				
						
				option = sc.nextInt();
						
					if (option < 1 || option > 12) {
						throw new InputMismatchException(); }
					
				
			
					switch (option) {
					case 1:
						boolean nameMatch=false;
						while(nameMatch==false) {
							try {
								column_name = "FIRST_NAME";
								System.out.println("You like to update customer name to be: ");
								new_value = sc.next();
							
								if (!new_value.matches("[a-zA-Z]*")) {
									throw new Exception();}
								else if(new_value.length()>40) {
									throw new StringIndexOutOfBoundsException();}
								else {nameMatch=true;}
								
								}catch (StringIndexOutOfBoundsException e) {
									System.out.println("Your input exceeds permitted length. The input can't exceed 40 characters!");
									nameMatch=false;
								}
								catch(Exception e) {
									System.out.println("Please don't use special characters or numbers!");
									nameMatch=false;
								}
						}
						break;
						
					case 2:
						boolean middleMatch=false;
						while(middleMatch==false) {
							try {
								column_name="MIDDLE_NAME";
								System.out.println("You like to update customer middle name to be: ");
								new_value = sc.next();
								if (!new_value.matches("[a-zA-Z]*")) {
									throw new Exception();}
								else if(new_value.length()>40) {
									throw new StringIndexOutOfBoundsException();}
								else {middleMatch=true;}
								
								}catch (StringIndexOutOfBoundsException e) {
									System.out.println("Your input exceeds permitted length. The input can't exceed 40 characters!");
									middleMatch=false;
								}
								catch(Exception e) {
									System.out.println("Please don't use special characters or numbers!");
									middleMatch=false;
								}
						}
						break;
						
					case 3:
						boolean lastMatch=false;
						while(lastMatch==false) {
							try {
								column_name ="LAST_NAME";
								System.out.println("You like to update customer last name to be: ");
								new_value = sc.next();
								if(!new_value.matches("[a-zA-Z]*")) {
									throw new Exception();
									
								}
								else if(new_value.length()>40) {
										throw new StringIndexOutOfBoundsException();}
								else {lastMatch=true;}
							}catch (StringIndexOutOfBoundsException e) {
								System.out.println("Your input exceeds permitted length. The input can't exceed 40 characters!");
								lastMatch=false;
							}
									  
								catch(Exception e) {
									System.out.println("Please don't use special characters or numbers!");
									lastMatch=false;
								
								}
						}
						break;
					case 4:
						boolean aptMatch=false;
						while(aptMatch==false) {
							try {
								column_name = "APT_NO";
								System.out.println("You like to update customer Apt number to be: ");
								new_value =sc.next();
								if(new_value.matches("[a-zA-Z0-9]*")) {
									aptMatch=true;
								}
								else {
									throw new Exception();
								}
								}catch(Exception e) {
									System.out.println("Please put put your apt number as letters and numbers! Please don't use special characters!");
									lastMatch=false;
								}
						}	
						break;
					case 5:				
						boolean streetMatch=false;
						sc.nextLine();
						while(streetMatch==false){
							try {
								
								column_name ="STREET_NAME";
								System.out.println("You like to update customer street name to be: ");
								new_value=sc.nextLine();
								if(new_value.length()>30 ) {
										throw new StringIndexOutOfBoundsException();}
								else if(new_value.length()<1) {
									throw new Exception();
								}
								else {streetMatch=true;}
							}catch (StringIndexOutOfBoundsException e) {
								System.out.println("Your input exceeds permitted length. The input can't exceed 30 characters!");
								streetMatch=false;
							}
							catch(Exception e) {
								System.out.println("The street name input can't be null! Please input street name.");
								streetMatch=false;
							
							}
						}
						break;
					case 6:
						
						boolean cityMatch=false;
						sc.nextLine();
						while(cityMatch==false) {
							try {
								column_name ="CUST_CITY";
								System.out.println("You would like to update customer's city to be: ");
								new_value = sc.nextLine();
								if(!new_value.matches("[a-zA-ZS]*")) {
									throw new Exception();
									
								}
								else if(new_value.length()>30) {
										throw new StringIndexOutOfBoundsException();}
								else {
									cityMatch=true;}
							}catch (StringIndexOutOfBoundsException e) {
								System.out.println("Your input exceeds permitted length. The input can't exceed 30 characters!");
								cityMatch=false;
							}
									  
								catch(Exception e) {
									System.out.println("Please don't use special characters, numbers, or spaces!");
									cityMatch=false;
								
								}
						}
						break;
					case 7:
						boolean stateMatch=false;
						while(stateMatch==false) {
							try {
								column_name ="CUST_STATE";
								System.out.println("Please use upper case! You would like to update customer state to be: ");
								new_value = sc.next();
								if(!new_value.matches("[A-Z]*")) {
									throw new Exception();	
								}
								else if(new_value.length()>30) {
									throw new StringIndexOutOfBoundsException();}
								
								else {stateMatch=true;}
							}catch (StringIndexOutOfBoundsException e) {
								System.out.println("Your input exceeds permitted length. The input can't exceed 30 characters!");
								cityMatch=false;
							}catch(Exception e) {
									System.out.println("Please don't use special characters or numbers!");
									lastMatch=false;
								}		
						}
						break;
					case 8:
						boolean countryMatch=false;
						sc.nextLine();
						while(countryMatch==false){
							try {
								
								column_name ="CUST_COUNTRY";
								System.out.println("You like to update customer country to be: ");
								new_value=sc.nextLine();
								if(new_value.length()>30 ) {
										throw new StringIndexOutOfBoundsException();}
								else if(new_value.matches(".*\\d.*")) {
									throw new Exception();
								}
								else {countryMatch=true;}
							}catch (StringIndexOutOfBoundsException e) {
								System.out.println("Your input exceeds permitted length. The input can't exceed 30 characters!");
								countryMatch=false;									
							}catch(Exception e) {
								System.out.println("Please don't use special characters or numbers!");
								countryMatch=false;					
							}
						}
						break;
					case 9:
						boolean zipMatch=false;
						while(zipMatch==false) {
							try {
								column_name ="CUST_ZIP";
								System.out.println("You like to update customer zip to be: ");
								new_value = sc.next();
								if(!new_value.matches("[0-9]*")) {
									throw new Exception();							
								}
								else if(new_value.length()>5) {
										throw new StringIndexOutOfBoundsException();}
								else {zipMatch=true;}
							}catch (StringIndexOutOfBoundsException e) {
								System.out.println("Your input exceeds permitted length. The input can't exceed 5 numbers!");
								zipMatch=false;
							}							  
								catch(Exception e) {
									System.out.println("Please don't use special characters or letters!");
									zipMatch=false;						
								}
						}
						break;
					case 10:
						boolean phoneMatch=false;
						//sc.nextLine();
						while(phoneMatch==false) {
							try {
								column_name="cust_phone";
								System.out.println("You would like to update customer phone number to be:");
								new_intValue=Integer.valueOf(sc.next());
								phoneMatch=true;
								
								}catch(Exception e) {
									System.out.println("Not valid input. The input shuld be XXXXXXX without spaces. Please try again.");
									phoneMatch=false;
								}
						}
						break;
					case 11:
						boolean emailMatch=false;
						while(emailMatch==false) {
							try {
								column_name ="CUST_EMAIL";
								System.out.println("You would like to update customer email to be: ");
								new_value = sc.next();
								if(new_value.matches("^[a-z0-9][a-z0-9-_\\.]+@([a-z]|[a-z0-9]?[a-z0-9-]+[a-z0-9])\\.[a-z0-9]{2,10}(?:\\.[a-z]{2,10})?$")) {
									emailMatch=true;;	
								}	
								else {throw new Exception();}
							}catch(Exception e) {
									System.out.println("Please use following format aygeshka10@gmail.com!");
									emailMatch=false;
								}		
						}
						break;
					}
					
				cd.updateCustomerAccount(column_name, new_value, new_intValue, ssn, cardNo);
					
				System.out.println("Please enter following information to see an updated Customer Account: ");
				checkExistingAccount();
				successUpdate=true;
					} 
		
		catch(Exception e) {
			System.out.println("Please chooce from the following:");
			//sc.next();
			//e.printStackTrace();
			successUpdate=false;
		 } }} }catch(Exception e){System.out.println("Can't modified account that doesn't exist");}}
		
	
	public void generateMonthlyBill() throws Exception {	
		boolean cardNoValid=false;
		boolean successMonth = false;
		boolean successYear = false;
		String cardNo="";
		Integer month = 0;
		Integer year = 0;
		
		while(cardNoValid==false) {
			try {
				System.out.println("Please enter customer credit card number:");
				cardNo = sc.next();
				if(cardNo.length()!=16) {
					throw new NullPointerException();
				}
				if(!cardNo.matches("[0-9]*")) {
					throw new Exception();
				}else {cardNoValid=true;}
				} catch(NullPointerException e) {
					System.out.println("Invalid card number. Card number should have 16 digits. Please try again.");
					cardNoValid=false;
				}catch(Exception e) {
					System.out.println("Invalid card number. Please try again.");
					cardNoValid=false;
				}
		}
		
		while (successMonth==false) {
			try {
			System.out.println("Please enter month:");
			month = Integer.valueOf(sc.next());
			if (month<1||month>12) {
			
			throw new Exception();}
			else {successMonth = true;}
			} catch (Exception e) {
				System.out.println("Invalid month! Please enter from 1 to 12.");
				successMonth = false;
			}
			}
		while (successYear == false) {
			System.out.println("Please enter year:");
			try {
				 year = Integer.valueOf(sc.next());
		
				int length = String.valueOf(year).length();
				if (length==4) {
				successYear = true;}
				else {throw new Exception(); }
			}catch(Exception e) {
				System.out.println("Invalid year! Please enter in YYYY format.");
				successYear = false;
			}
		}
			
		Customer ecustomer = cd.generateMonthlyBill(cardNo, month, year);
		
		System.out.println(ecustomer.getFirstName());
		System.out.println(ecustomer.getLastName());
		System.out.println(ecustomer.getValue());
		
	}
	public void getTransactionBetweenDates() throws Exception {
		Integer ssn=0;
		String cardNo="";
		String ssnString="";
		boolean ssnValid=false;
		boolean cardNoValid=false;
		String startDate="", endDate="";
		boolean startDateValid=false;
		boolean endDateValid=false;
		String pattern = "([0-9]{2}.){2}[0-9]{4}";
		
		while(ssnValid==false) {
			try {
				System.out.println("Please enter customer ssn:");
				
				ssnString = sc.next();
				
				if(ssnString.length() !=9 ) {
					throw new IndexOutOfBoundsException();	
				}
				else if(!ssnString.matches("[0-9]*")) {
					throw new Exception();
				}
				else{ssnValid=true;}
				}catch(IndexOutOfBoundsException e) 
				{System.out.println("The length should be 9 digits.");
				ssnValid=false;
				
				}catch(Exception e) {
					System.out.println("Invalid ssn. Please try again.");
					ssnValid=false;
				}
		}
		
		while(cardNoValid==false) {
			try {
				System.out.println("Please enter customer card number:");
				cardNo = sc.next();
				if(cardNo.length()!=16) {
					throw new NullPointerException();
				}
				if(!cardNo.matches("[0-9]*")) {
					throw new Exception();
				}else {cardNoValid=true;}
				} catch(NullPointerException e) {
					System.out.println("Invalid card number. Card number should have 16 digits. Please try again.");
					cardNoValid=false;
				}catch(Exception e) {
					System.out.println("Invalid card number. Please try again.");
					cardNoValid=false;
				}
		}
		ssn = Integer.parseInt(ssnString);
		
		while(startDateValid==false) {
			try {
				System.out.println("Please enter start date as MM.dd.yyyy:");
				startDate = sc.next();
				if(!startDate.matches(pattern)) {throw new Exception();}
				else {startDateValid=true;}
				}catch(Exception e) {
					System.out.println("Date format is invalid.Please enter start date as MM.dd.yyyy: ");
					startDateValid=false;
				}
		}
		
		while(endDateValid==false) {
			try {
				System.out.println("Please enter end date as MM.dd.yyyy:");
				endDate = sc.next();
				if(!endDate.matches(pattern)) {throw new Exception();}
				else {endDateValid=true;}			
				}catch(Exception e) {
					System.out.println("Date format is invalid.Please enter start date as MM.dd.yyyy: ");
					endDateValid=false;
					}
		}
		
		List<transaction> listbd = cd.getTransactionBetweenDates(ssn, cardNo, startDate, endDate);
		if(listbd.isEmpty()) {
			System.out.println("No output is found for these inputs:");
		}
		else {
		System.out.printf("%-10s%-10s%-10s%-10s%-20s%-20s%-20s","ID","Day", "Month", "Year", "Branch Code", "Transaction Type", "Transaction Value");
		System.out.println("");
		for(transaction t : listbd) {
			System.out.printf("%-10d%-10d%-10d%-10d%-20d%-20s%-20.2f%n", t.getId(), t.getDay(), t.getMonth(), t.getYear(), t.getBranchCode(), t.getType(), t.getTransaction_Value());			
		}
		}
	
	}
	
}
