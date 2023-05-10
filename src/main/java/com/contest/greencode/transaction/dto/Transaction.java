package com.contest.greencode.transaction.dto;

import java.math.BigDecimal;

public record Transaction(String debitAccount, String creditAccount, BigDecimal amount) {
}
