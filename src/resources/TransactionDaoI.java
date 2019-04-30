package resources;
import java.sql.SQLException;
import java.util.List;

import model.transaction;

public interface TransactionDaoI {
	
		public final static String displayByZip="select transaction_id, day, month, year, cc.CREDIT_CARD_NO, cust_ssn, branch_Code, transaction_type, transaction_value " +
												"from cdw_sapp_creditcard cc join cdw_sapp_customer c on cc.cust_ssn=c.ssn " +
												"where CUST_ZIP = ? and year=? and month=? " +									
												"order by day desc";
				
		public final static String totalByType = "select sum(transaction_value), count(*)" +
												"from cdw_sapp_creditcard " +
												"where TRANSACTION_TYPE = ? " +
												"GROUP by TRANSACTION_TYPE";
		
		public final static String displayByState="select sum(transaction_value), count(transaction_id), BRANCH_STATE " +
												"from cdw_sapp_creditcard cc "
												+ "join cdw_sapp_branch b on cc.BRANCH_CODE=b.BRANCH_CODE "+
												"where BRANCH_STATE =?";
												
											
				
		List <transaction> getdisplayByZip() throws SQLException;
	}



