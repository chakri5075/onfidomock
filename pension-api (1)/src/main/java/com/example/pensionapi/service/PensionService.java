package com.example.pensionapi.service;

import com.example.pensionapi.model.PensionResponse;
import com.example.pensionapi.db.InMemoryDatabase;
import com.example.pensionapi.model.PensionRecord;
import com.example.secondaryapi.service.SecondaryPensionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PensionService {

    public PensionResponse processImageType(String imageType) {
        if (!"NINO".equalsIgnoreCase(imageType) && !"Passport".equalsIgnoreCase(imageType)) {
            return new PensionResponse(null,null,null,null,null,null,null,null,0.0,"Dcoument Invalid");
        }

        String firstName = imageType.equalsIgnoreCase("NINO") ? "John" : "Jane";
        String lastName = imageType.equalsIgnoreCase("NINO") ? "Doe" : "Smith";
        String dob = imageType.equalsIgnoreCase("NINO") ? "1980-01-01" : "1975-05-15";
        String address = "123 Street, City";

        Optional<PensionRecord> record;
        if (imageType.equalsIgnoreCase("NINO")) {
            record = InMemoryDatabase.findInDb1(firstName, lastName, dob);
        } else {
            record = SecondaryPensionService.getDetailsFromSecondaryApi(firstName, lastName, dob);
        }

        if (record.isPresent()) {
            PensionRecord r = record.get();
            return new PensionResponse(r.getFirstName(), r.getLastName(), r.getDob(), r.getAddress(),r.getCity(),r.getPostalCode(),
                    r.getPensionScheme(), r.getPensionAccount(), r.getTotalDeposited(), "Document Valid");
        }

        return new PensionResponse(firstName, lastName, dob, address, null, null, null, null,0.0, "Document Valid");
    }
}
