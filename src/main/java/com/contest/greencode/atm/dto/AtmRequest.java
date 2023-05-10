package com.contest.greencode.atm.dto;

public record AtmRequest(int region, AtmRequestType requestType, int atmId) {

}