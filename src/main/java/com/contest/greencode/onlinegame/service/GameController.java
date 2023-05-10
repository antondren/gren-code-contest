package com.contest.greencode.onlinegame.service;

import com.contest.greencode.onlinegame.dto.Clan;
import com.contest.greencode.onlinegame.dto.GroupRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping("/onlinegame/calculate")
    public ResponseEntity<List<List<Clan>>> getGroupsForEvent(@RequestBody GroupRecordRequest groupRecordRequest) {
        return ResponseEntity.ok(gameService.createGroupsForEvent(groupRecordRequest));
    }
}
