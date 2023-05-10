package com.contest.greencode.atm.service;

import com.contest.greencode.atm.dto.AtmRequest;
import com.contest.greencode.atm.dto.AtmRequestType;
import com.contest.greencode.atm.dto.AtmResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class AtmServiceTest {
    private final AtmService atmService = new AtmService();

    @Test
    void testSorting() {
        List<AtmResponse> sortedRequests = atmService.sortRequests(createAtmRequests());
        assertEquals(sortedRequests, createAtmResponsesForCheck());
    }

    private List<AtmRequest> createAtmRequests() {
        List<AtmRequest> atmRequests = new ArrayList<>();

        atmRequests.add(new AtmRequest(4, AtmRequestType.STANDARD, 1));
        atmRequests.add(new AtmRequest(1, AtmRequestType.STANDARD, 1));
        atmRequests.add(new AtmRequest(2, AtmRequestType.STANDARD, 1));
        atmRequests.add(new AtmRequest(3, AtmRequestType.PRIORITY, 2));
        atmRequests.add(new AtmRequest(3, AtmRequestType.STANDARD, 1));
        atmRequests.add(new AtmRequest(2, AtmRequestType.SIGNAL_LOW, 1));
        atmRequests.add(new AtmRequest(5, AtmRequestType.STANDARD, 2));
        atmRequests.add(new AtmRequest(5, AtmRequestType.FAILURE_RESTART, 1));

        return atmRequests;
    }

    private List<AtmResponse> createAtmResponsesForCheck() {
        List<AtmResponse> atmResponses = new ArrayList<>();

        atmResponses.add(new AtmResponse(1, 1));
        atmResponses.add(new AtmResponse(2, 1));
        atmResponses.add(new AtmResponse(3, 2));
        atmResponses.add(new AtmResponse(3, 1));
        atmResponses.add(new AtmResponse(4, 1));
        atmResponses.add(new AtmResponse(5, 1));
        atmResponses.add(new AtmResponse(5, 2));

        return atmResponses;
    }

}