
package com.securebank.account.controller;

import com.securebank.account.model.TransferRequest;
import com.securebank.account.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> transfer(@Valid @RequestBody TransferRequest request) {
        transferService.transfer(request.getFromAccountId(), request.getToAccountId(), request.getAmount());
        return ResponseEntity.ok("Transfer successful");
    }
}
