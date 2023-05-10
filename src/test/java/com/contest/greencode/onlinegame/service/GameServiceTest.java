package com.contest.greencode.onlinegame.service;

import com.contest.greencode.onlinegame.dto.Clan;
import com.contest.greencode.onlinegame.dto.GroupRecordRequest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GameServiceTest {
    private final GameService gameService = new GameService();

    @Test
    void testGroupCreationForEvent() {
        List<List<Clan>> result = gameService.createGroupsForEvent(createSampleGroupRecord());
        List<List<Clan>> expected = createSampleExpectedResult();
        for (int i = 0; i < expected.size(); i++) {
            List<Clan> expectedClanList = expected.get(i);
            List<Clan> resultClanList = result.get(i);
            for (int iSecond = 0; iSecond < expectedClanList.size(); iSecond++) {
                Clan expectedClan = expectedClanList.get(iSecond);
                Clan resultClan = resultClanList.get(iSecond);
                assertEquals(resultClan.getNumberOfPlayers(), expectedClan.getNumberOfPlayers());
                assertEquals(resultClan.getPoints(), expectedClan.getPoints());
            }
        }

    }

    private List<List<Clan>> createSampleExpectedResult() {
        return Arrays.asList(
                Arrays.asList(
                        new Clan(2, 70),
                        new Clan(4, 50)
                ),
                List.of(
                        new Clan(6, 60)
                ),
                Arrays.asList(
                        new Clan(3, 45),
                        new Clan(1, 15),
                        new Clan(1, 12)
                ),
                List.of(
                        new Clan(4, 40)
                ),
                List.of(
                        new Clan(5, 40)
                )
        );
    }

    private GroupRecordRequest createSampleGroupRecord() {
        ArrayList<Clan> list = new ArrayList<>();
        list.add(new Clan(4, 50));
        list.add(new Clan(2, 70));
        list.add(new Clan(6, 60));
        list.add(new Clan(1, 15));
        list.add(new Clan(5, 40));
        list.add(new Clan(3, 45));
        list.add(new Clan(1, 12));
        list.add(new Clan(4, 40));

        return new GroupRecordRequest(6, list);
    }

}