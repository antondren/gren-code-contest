package com.contest.greencode.atm.service;

import com.contest.greencode.atm.dto.AtmRequest;
import com.contest.greencode.atm.dto.AtmResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AtmController {
    private final AtmService atmService;

    @PostMapping("/atms/calculateOrder")
    public ResponseEntity<List<AtmResponse>> calculateOrder(@RequestBody List<AtmRequest> request) {
        return ResponseEntity.ok(atmService.sortRequests(request));
    }
}
