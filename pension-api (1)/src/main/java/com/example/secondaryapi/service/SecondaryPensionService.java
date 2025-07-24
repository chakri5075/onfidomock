package com.example.secondaryapi.service;

import com.example.pensionapi.db.InMemoryDatabase;
import com.example.pensionapi.model.CustomerPensionFormPayload;
import com.example.pensionapi.model.CustomerPensionFormResponse;
import com.example.pensionapi.model.PensionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class SecondaryPensionService {

    public static Optional<PensionRecord> getDetailsFromSecondaryApi(String firstName, String lastName, String dob,String nino, String postCode) {
      //call sri api

    RestTemplate restTemplate = new RestTemplate();
        String url="http://localhost:8081/api/customer-data/fetchpensiondetails";

        CustomerPensionFormPayload cpfl = new CustomerPensionFormPayload();
        cpfl.setFirstName(firstName);
        cpfl.setLastName(lastName);
        cpfl.setDateOfBirth(dob);
        cpfl.setNino(nino);
        cpfl.setPostcode(postCode);

        HttpHeaders headers = new HttpHeaders();
         HttpEntity<CustomerPensionFormPayload> requestEntity = new HttpEntity<>(cpfl, headers);
        ResponseEntity<CustomerPensionFormResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                CustomerPensionFormResponse.class
        );

        CustomerPensionFormResponse cpfr = response.getBody();
        return Optional.of(new PensionRecord(cpfr.getFirstName(), cpfr.getLastName(), cpfr.getDateOfBirth(), cpfr.getAddress(), "london", cpfr.getPostalcode(), cpfr.getPensionScheme(), cpfr.getAccountNumber(), Double.parseDouble(cpfr.getTotalAmountDeposited())));
//        PensionRecord pensionRecord = response.getBody();

//        return InMemoryDatabase.findInDb2(firstName, lastName, dob);
    }
}
