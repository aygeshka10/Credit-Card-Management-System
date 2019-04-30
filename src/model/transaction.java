package model;

public class transaction{
	protected int day, month, year, ssn, branchCode, count, id;
	protected double transaction_Value;
	protected String cardNo, type, state;
	
	public String getState() {
		return state;
	}	
	
	public void setState(String state) {
		this.state=state;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public double getTransaction_Value() {
		return transaction_Value;
	}

	public void setTransaction_Value(double transaction_Value) {
		this.transaction_Value = transaction_Value;
	}
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	public int getCount() {
		return count;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
