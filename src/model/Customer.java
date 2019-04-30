package model;

import java.sql.Timestamp;

public class Customer {
	protected String firstName, middleName, lastName, cardNo;
	protected String apt, street, city, county, zip, email;
	protected int ssn, custPhone;
	protected String state;
	protected double value;
	protected Timestamp lastUpdated;
	
	
	public Timestamp getlastUpdated() {
		return lastUpdated;
	}
	public void setlastUpdated(Timestamp lastUpdated) {
		this.lastUpdated= lastUpdated;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		this.apt = apt;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(int custPhone) {
		this.custPhone = custPhone;
	}

	
}
