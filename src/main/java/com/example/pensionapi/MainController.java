/*

package com.example.pensionapi;

import com.example.secondaryapi.SecondaryApiService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pension")
public class MainController {

    private static final Map<String, PensionResponse> primaryDB = new HashMap<>();

    static {
        PensionResponse record = new PensionResponse();
        record.firstName = "John";
        record.lastName = "Doe";
        record.dob = "1980-01-01";
        record.address = "123 Street, City";
        record.pensionAccount = "ACC12345";
        record.pensionScheme = "SchemeA";
        record.totalDeposited = 50000.0;
        record.address="Street1";
        record.*/
/**//*
city="london";
        record.postalCode="500019";
        primaryDB.put("JohnDoe1980-01-01", record);
    }

    @PostMapping("/details")
    public PensionResponse getPensionDetails(@RequestBody PensionRequest request) {
        PensionResponse response = new PensionResponse();

        if (request.getImageType() == null || 
            (!request.getImageType().equalsIgnoreCase("NINO") && !request.getImageType().equalsIgnoreCase("Passport"))) {
            response.document = "Document Invalid";
            response.validImageType = false;
            return response;
        }

        response.firstName = "John";
        response.lastName = "Doe";
        response.dob = "1980-01-01";
        response.address = "123 Street, City";
        response.document = "Document Valid";
        response.validImageType = true;

        String key = response.firstName + response.lastName + response.dob;

        if (request.getImageType().equalsIgnoreCase("NINO") && primaryDB.containsKey(key)) {
            PensionResponse dbRecord = primaryDB.get(key);
            response.pensionAccount = dbRecord.pensionAccount;
            response.pensionScheme = dbRecord.pensionScheme;
            response.totalDeposited = dbRecord.totalDeposited;
        } else if (request.getImageType().equalsIgnoreCase("Passport")) {
            PensionResponse secondaryData = SecondaryApiService.getPensionFromSecondary(response.firstName, response.lastName, response.dob);
            if (secondaryData != null) {
                response.pensionAccount = secondaryData.pensionAccount;
                response.pensionScheme = secondaryData.pensionScheme;
                response.totalDeposited = secondaryData.totalDeposited;
            }
        }
        return response;
    }
}
*/
