
package com.example.secondaryapi;

import com.example.pensionapi.PensionResponse;

import java.util.HashMap;
import java.util.Map;

public class SecondaryApiService {
    private static final Map<String, PensionResponse> secondaryDB = new HashMap<>();

    static {
        PensionResponse record = new PensionResponse();
        record.pensionAccount = "PASS12345";
        record.pensionScheme = "SchemeB";
        record.totalDeposited = 30000.0;
        secondaryDB.put("JohnDoe1980-01-01", record);
    }

    public static PensionResponse getPensionFromSecondary(String firstName, String lastName, String dob) {
        return secondaryDB.get(firstName + lastName + dob);
    }
}
