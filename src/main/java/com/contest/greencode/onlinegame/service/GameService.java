package com.contest.greencode.onlinegame.service;


import com.contest.greencode.onlinegame.dto.Clan;
import com.contest.greencode.onlinegame.dto.GroupRecordRequest;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
@NoArgsConstructor
public class GameService {

    /**
     * Creates groups of clans for the event based on the group count and clan list.
     *
     * @param groupRecordRequest A GroupRecord object containing group count and list of clans.
     * @return A list of lists of Clan objects representing the groups for the event.
     */
    public List<List<Clan>> createGroupsForEvent(GroupRecordRequest groupRecordRequest) {
        sortClans(groupRecordRequest.clans());

        List<List<Clan>> result = new ArrayList<>();
        while (!groupRecordRequest.clans().isEmpty()) {
            result.add(
                    createGroup(
                            groupRecordRequest.groupCount(),
                            groupRecordRequest.clans().iterator()
                    )
            );
        }
        return result;
    }

    /**
     * Creates a group of clans based on the group count and an iterator for the remaining clans.
     *
     * @param groupCount The maximum size of a group.
     * @param iterator   An iterator for the list of remaining clans.
     * @return A list of Clan objects representing a single group.
     */
    private List<Clan> createGroup(int groupCount, Iterator<Clan> iterator) {
        List<Clan> group = new ArrayList<>();
        int groupSize = 0;

        while (iterator.hasNext() && groupSize != groupCount) {
            Clan currentClan = iterator.next();
            if (groupSize + currentClan.getNumberOfPlayers() <= groupCount) {
                group.add(currentClan);
                groupSize += currentClan.getNumberOfPlayers();
                iterator.remove();
            }
        }
        return group;
    }

    /**
     * Sorts the list of clans based on their points and number of players.
     *
     * @param clans A list of Clan objects to be sorted.
     */
    private void sortClans(List<Clan> clans) {
        clans.sort(Comparator.comparing(Clan::getPoints)
                .reversed()
                .thenComparing(Clan::getNumberOfPlayers));
    }

}
