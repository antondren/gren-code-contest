package com.contest.greencode.transaction.dto;

import java.util.List;

public interface AccountRepository {
    List<Account> getAllAccounts();
    Account getAccount(String accountNumber);
    void saveAccountInformation(Account account);

}
