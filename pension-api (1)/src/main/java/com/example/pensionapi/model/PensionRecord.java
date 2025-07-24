package com.example.pensionapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;


//@AllArgsConstructor
public class PensionRecord {
//    public PensionRecord(String string, String string2, String string3, String string4, String string5, double d) {
//		// TODO Auto-generated constructor stub
//
//	}


//	public PensionRecord(String firstName, String lastName, String dob, String pensionScheme, String pensionAccount, double totalDeposited) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.dob = dob;
//		this.pensionScheme = pensionScheme;
//		this.pensionAccount = pensionAccount;
//		this.totalDeposited = totalDeposited;
//	}



	private String firstName;
	private String lastName;
    private String dob;
	private String address;
	private String city;
	private String postalCode;
    private String pensionScheme;
    private String pensionAccount;
    private double totalDeposited;

	public PensionRecord( String firstName, String lastName, String dob, String address, String city, String postalCode,String pensionScheme, String pensionAccount, double totalDeposited) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.pensionAccount = pensionAccount;
		this.totalDeposited = totalDeposited;
		this.pensionScheme = pensionScheme;
	}

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public String getDob() {
		return dob;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getPensionScheme() {
		return pensionScheme;
	}

	public String getPensionAccount() {
		return pensionAccount;
	}

	public double getTotalDeposited() {
		return totalDeposited;
	}
}
