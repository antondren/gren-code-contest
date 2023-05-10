package com.contest.greencode.atm.service;


import com.contest.greencode.atm.dto.AtmRequest;
import com.contest.greencode.atm.dto.AtmResponse;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@NoArgsConstructor
public class AtmService {

    /**
     * Sorts a list of ATM requests based on the region, request type priority, and ATM ID.
     * Returns a list of distinct ATM responses.
     *
     * @param atmRequests a list of ATM requests to sort.
     * @return a sorted and distinct list of ATM responses.
     */
    public List<AtmResponse> sortRequests(List<AtmRequest> atmRequests) {
        return atmRequests
                .stream()
                .sorted(getComparator())
                .map(r ->new AtmResponse(r.region(), r.atmId()))
                .distinct()
                .toList();
    }

    /**
     * Provides a comparator that compares ATM requests based on the region, request type priority, and ATM ID.
     *
     * @return a comparator for ATM requests.
     */
    private Comparator<AtmRequest> getComparator() {
        return Comparator
                .comparing(AtmRequest::region)
                .thenComparing(atmRequest -> atmRequest.requestType().getPriority())
                .thenComparing(AtmRequest::atmId);
    }
}
