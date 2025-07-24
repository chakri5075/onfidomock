package com.example.secondaryapi.service;

import com.example.pensionapi.db.InMemoryDatabase;
import com.example.pensionapi.model.PensionRecord;

import java.util.Optional;

public class SecondaryPensionService {

    public static Optional<PensionRecord> getDetailsFromSecondaryApi(String firstName, String lastName, String dob) {
      //call sri api
        
        return InMemoryDatabase.findInDb2(firstName, lastName, dob);
    }
}
