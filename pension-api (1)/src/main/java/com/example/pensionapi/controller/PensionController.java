package com.example.pensionapi.controller;

import com.example.pensionapi.model.PensionResponse;
import com.example.pensionapi.service.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pension")
public class PensionController {

    @Autowired
    private PensionService pensionService;

    @PostMapping("/details")
    public ResponseEntity<?> getPensionDetails(@RequestBody Map<String, String> request) {
        String imageType = request.get("imageType");
        PensionResponse response = pensionService.processImageType(imageType);
        return ResponseEntity.ok(response);
    }
}
