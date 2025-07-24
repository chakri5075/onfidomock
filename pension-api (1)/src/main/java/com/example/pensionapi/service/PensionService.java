package com.example.pensionapi.service;

import com.example.pensionapi.model.OnfidoResponse;
import com.example.pensionapi.model.PensionResponse;
import com.example.pensionapi.db.InMemoryDatabase;
import com.example.pensionapi.model.PensionRecord;
import com.example.secondaryapi.service.SecondaryPensionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PensionService {

    public PensionResponse processImageType(String imageType) {
//        if (!"NINO".equalsIgnoreCase(imageType) && !"Passport".equalsIgnoreCase(imageType)) {
//            return new PensionResponse(null,null,null,null,null,null,null,null,0.0,"Dcoument Invalid");
//        }
        Optional<PensionRecord> record = Optional.empty();
        OnfidoResponse onfidoResponse = getOnfidoMockResponse(imageType);
        if(onfidoResponse!=null){
            record = InMemoryDatabase.findInDb1(onfidoResponse.getFirstName(), onfidoResponse.getLastName(), onfidoResponse.getDob());
            if(record.isEmpty()){
                record = SecondaryPensionService.getDetailsFromSecondaryApi(onfidoResponse.getFirstName(), onfidoResponse.getLastName(), onfidoResponse.getDob(),onfidoResponse.getIdNumber(),onfidoResponse.getPostalCode());
            }
        }else{
            return new PensionResponse(null,null,null,null,null,null,null,null,0.0,"INVALID");
        }
//        String firstName = imageType.equalsIgnoreCase("NINO") ? "John" : "Jane";
//        String lastName = imageType.equalsIgnoreCase("NINO") ? "Doe" : "Smith";
//        String dob = imageType.equalsIgnoreCase("NINO") ? "1980-01-01" : "1975-05-15";
//        String address = "123 Street, City";

//        Optional<PensionRecord> record;
//        if (imageType.equalsIgnoreCase("NINO")) {
//            record = InMemoryDatabase.findInDb1(firstName, lastName, dob);
//        } else {
//            record = SecondaryPensionService.getDetailsFromSecondaryApi(firstName, lastName, dob,"12345678","500019");
//        }

        if (record.isPresent()) {
            PensionRecord r = record.get();
            return new PensionResponse(r.getFirstName(), r.getLastName(), r.getDob(), r.getAddress(),r.getCity(),r.getPostalCode(),
                    r.getPensionScheme(), r.getPensionAccount(), r.getTotalDeposited(), "Document Valid");
        }

        assert onfidoResponse != null;
        return new PensionResponse(onfidoResponse.getFirstName(), onfidoResponse.getLastName(), onfidoResponse.getDob(), onfidoResponse.getAddress(), onfidoResponse.getCity(), onfidoResponse.getPostalCode(), null, null,null, "Document Valid");
    }

    private OnfidoResponse getOnfidoMockResponse(String imageType) {
        if(imageType.equalsIgnoreCase("NINO")){
            OnfidoResponse onfidoResponse = new OnfidoResponse();
            onfidoResponse.setFirstName("John");
            onfidoResponse.setLastName("Doe");
            onfidoResponse.setDob("1980-01-01");
            onfidoResponse.setIdNumber("QQ 12 34 54 A");
            onfidoResponse.setPostalCode("SW1A 1AA");
            return onfidoResponse;
        }else if(imageType.equalsIgnoreCase("PASSPORT")){
            OnfidoResponse onfidoResponse = new OnfidoResponse();
            onfidoResponse.setFirstName("Jane");
            onfidoResponse.setLastName("Smith");
            onfidoResponse.setDob("1975-05-15");
            onfidoResponse.setIdNumber("7700225VH");
            onfidoResponse.setPostalCode("SW2B 2BB");
            return onfidoResponse;
        }else{
            return null;
        }
    }
}
