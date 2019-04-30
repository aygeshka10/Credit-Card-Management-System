package resources;

public interface CustomerDaoI {
	public final static String existingAccount ="select * from cdw_sapp_customer "
											+ "where ssn=? and credit_card_no =? ";
	
	public final static String updateExistingValue ="update cdw_sapp_customer SET ";
	
	public final static String updateToNewValue= "=? where ssn=? and credit_card_no =? ";
	
	public final static String monthlyBill = "select c.FIRST_NAME, c.LAST_NAME, sum(transaction_value) "
											+ "from cdw_sapp_creditcard cc join cdw_sapp_customer c on cc.CREDIT_CARD_NO=c.CREDIT_CARD_NO "
											+ "where cc.CREDIT_CARD_NO= ?and MONTH = ? and YEAR = ?";
	
	public final static String betweenTwoDates ="SELECT * FROM cdw_sapp_creditcard " 
											+ "WHERE cust_ssn=? " 
											+ "AND credit_card_no=? AND str_to_date(CONCAT(month,'.',day,'.',year), GET_FORMAT(DATE, 'USA')) " 
											+ "BETWEEN str_to_date(?,GET_FORMAT(DATE, 'USA')) AND str_to_date(?,GET_FORMAT(DATE, 'USA')) " 
											+ "ORDER BY year, month, day ";


}
