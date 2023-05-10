package com.contest.greencode.transaction.service;

import com.contest.greencode.transaction.dto.Account;
import com.contest.greencode.transaction.dto.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BankTransactionController {
    private final BankTransactionService bankTransactionService;

    @PostMapping("/transactions/report")
    public ResponseEntity<List<Account>> processTransactionReport(@RequestBody List<Transaction> transactions) {
        return ResponseEntity.ok(bankTransactionService.processTransactionsAndGenerateReport(transactions));
    }
}
