package com.example.pensionapi.model;

public class CustomerPensionFormResponse {

    private String firstName;
    private String lastName;
    private String nino;
    private String dateOfBirth;
    private String address;
    private String postalcode;
    private String accountNumber;
    private String pensionScheme;
    private String totalAmountDeposited;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getNino() { return nino; }
    public void setNino(String nino) { this.nino = nino; }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPostalcode() { return postalcode; }
    public void setPostalcode(String postalcode) { this.postalcode = postalcode; }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getPensionScheme() { return pensionScheme; }
    public void setPensionScheme(String pensionScheme) { this.pensionScheme = pensionScheme; }
    public String getTotalAmountDeposited() { return totalAmountDeposited; }
    public void setTotalAmountDeposited(String totalAmountDeposited) { this.totalAmountDeposited = totalAmountDeposited; }
}
