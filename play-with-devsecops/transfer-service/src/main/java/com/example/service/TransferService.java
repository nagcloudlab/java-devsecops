package com.example.service;

import com.example.dto.TransferRequest;
import com.example.dto.TransferResponse;

public interface TransferService {
    TransferResponse transfer(TransferRequest transferRequest);
}
