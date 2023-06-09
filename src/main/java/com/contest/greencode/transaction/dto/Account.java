package com.contest.greencode.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class Account {
    private final String account;
    private int debitCount;
    private int creditCount;
    private BigDecimal balance;
}
