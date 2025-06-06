package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TransferRequest;
import com.example.dto.TransferResponse;
import com.example.service.TransferService;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    /*
     * POST /api/transfer
     * Accept : application/json
     * Content-Type : application/json
     */

    // Endpoint to handle transfer requests
    @PostMapping
    public ResponseEntity<?> handleTransfer(@RequestBody TransferRequest transferRequest) {
        TransferResponse response = transferService.transfer(transferRequest);
        if (response.getStatus().equals("success")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

}
