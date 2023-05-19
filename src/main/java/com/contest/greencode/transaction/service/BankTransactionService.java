package com.contest.greencode.transaction.service;

import com.contest.greencode.transaction.dto.Account;
import com.contest.greencode.transaction.dto.AccountRepository;
import com.contest.greencode.transaction.dto.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankTransactionService {
    private final AccountRepository repository;

    /**
     * Processes a list of transactions and generates a sorted report of all accounts.
     *
     * @param transactions a list of transactions to process.
     * @return a sorted list of accounts after transactions have been processed.
     */
    public List<Account> processTransactionsAndGenerateReport(List<Transaction> transactions) {
        processTransactions(transactions);
        return getSortedAccounts();
    }

    /**
     * Processes a list of transactions by updating the debit and credit accounts associated with each transaction.
     *
     * @param transactions a list of transactions to process.
     */
    private void processTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            Account debitAccount = repository.getAccount(transaction.debitAccount());
            Account creditAccount = repository.getAccount(transaction.creditAccount());

            updateDebitAccount(debitAccount, transaction.amount());
            updateCreditAccount(creditAccount, transaction.amount());

            repository.saveAccountInformation(debitAccount);
            repository.saveAccountInformation(creditAccount);
        }
    }

    /**
     * Retrieves a sorted list of all accounts from the repository. The accounts are sorted by their account numbers.
     *
     * @return a sorted list of accounts.
     */
    private List<Account> getSortedAccounts() {
        List<Account> sortedAccounts = repository.getAllAccounts();
        sortedAccounts.sort(Comparator.comparing(Account::getAccount));
        return sortedAccounts;
    }

    /**
     * Updates the debit count and balance for given account.
     *
     * @param debitAccount the account to update.
     * @param amount the amount to debit from the account.
     */
    private void updateDebitAccount(Account debitAccount, BigDecimal amount) {
        debitAccount.setDebitCount(debitAccount.getDebitCount() + 1);
        debitAccount.setBalance(debitAccount.getBalance().subtract(amount));
    }

    /**
     * Updates the credit count and balance for given account.
     *
     * @param creditAccount the account to update.
     * @param amount the amount to credit to the account.
     */
    private void updateCreditAccount(Account creditAccount, BigDecimal amount) {
        creditAccount.setCreditCount(creditAccount.getCreditCount() + 1);
        creditAccount.setBalance(creditAccount.getBalance().add(amount));
    }
}
