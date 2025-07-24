package com.example.pensionapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;


public class PensionResponse {

	private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private String city;
    private String postalCode;
    private String pensionScheme;
    private String pensionAccount;
    private Double totalDeposited;
    private String documentStatus;

    public PensionResponse(String firstName, String lastName, String dob, String address, String city, String postalCode, String pensionScheme, String pensionAccount, Double totalDeposited, String documentStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.pensionScheme = pensionScheme;
        this.pensionAccount = pensionAccount;
        this.totalDeposited = totalDeposited;
        this.documentStatus = documentStatus;
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

    public String getDocumentStatus() {
        return documentStatus;
    }
}
