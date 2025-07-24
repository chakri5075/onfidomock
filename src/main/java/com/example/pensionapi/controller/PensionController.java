package com.example.pensionapi.controller;

import com.example.pensionapi.model.PensionResponse;
import com.example.pensionapi.service.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/pension")
public class PensionController {
    private static final Logger logger = LoggerFactory.getLogger(PensionController.class);

    @Autowired
    private PensionService pensionService;

    @PostMapping("/details")
    public ResponseEntity<?> getPensionDetails(@RequestBody Map<String, String> request) {
        String imageType = request.get("imageType");
        logger.info("Received pension details request with imageType: {}", imageType);
        PensionResponse response = pensionService.processImageType(imageType);
        logger.info("Returning pension response: {}", response);
        return ResponseEntity.ok(response);
    }
}
