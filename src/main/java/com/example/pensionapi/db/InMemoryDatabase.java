package com.example.pensionapi.db;

import com.example.pensionapi.model.PensionRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase {
    private static final Logger logger = LoggerFactory.getLogger(InMemoryDatabase.class);
    public static List<PensionRecord> db1 = new ArrayList<>();
    public static List<PensionRecord> db2 = new ArrayList<>();

    static {
       PensionRecord p1 = new PensionRecord("John", "Doe", "1980-01-01","Street1","london","500019", "SchemeA", "ACC12345", 50000.0);
    	db1.add(p1);
    	db2.add(new PensionRecord("Jane", "Smith", "1975-05-15", "Street2", "london","500018","SchemeB", "ACC67890", 65000.0));
    }

    public static Optional<PensionRecord> findInDb1(String firstName, String lastName, String dob) {
        return db1.stream().filter(r ->
                r.getFirstName().equalsIgnoreCase(firstName) &&
                r.getLastName().equalsIgnoreCase(lastName) &&
                r.getDob().equals(dob)
        ).findFirst();
    }

    public static Optional<PensionRecord> findInDb2(String firstName, String lastName, String dob) {
        return db2.stream().filter(r ->
                r.getFirstName().equalsIgnoreCase(firstName) &&
                r.getLastName().equalsIgnoreCase(lastName) &&
                r.getDob().equals(dob)
        ).findFirst();
    }

    public Optional<PensionRecord> findRecord(String firstName, String lastName, LocalDate dob) {
        logger.info("Searching for record: firstName={}, lastName={}, dob={}", firstName, lastName, dob);
        Optional<PensionRecord> result = db2.stream().filter(r ->
                r.getFirstName().equalsIgnoreCase(firstName) &&
                r.getLastName().equalsIgnoreCase(lastName) &&
                r.getDob().equals(dob)
        ).findFirst();
        if (result.isPresent()) {
            logger.info("Record found: {}", result.get());
        } else {
            logger.warn("No record found for: firstName={}, lastName={}, dob={}", firstName, lastName, dob);
        }
        return result;
    }
}
