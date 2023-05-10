package com.contest.greencode.transaction.service;

import com.contest.greencode.transaction.dto.Account;
import com.contest.greencode.transaction.dto.AccountRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class AccountRepositoryImpl implements AccountRepository {
    private final ConcurrentHashMap<String, Account> repository = new ConcurrentHashMap<>();

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Account getAccount(String accountNumber) {
        return repository.getOrDefault(
                accountNumber,
                new Account(accountNumber, 0, 0, BigDecimal.ZERO)
        );
    }

    @Override
    public void saveAccountInformation(Account account) {
        repository.put(account.getAccountNumber(), account);
    }
}
