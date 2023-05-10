package com.contest.greencode.onlinegame.dto;

import java.util.ArrayList;

public record GroupRecordRequest(int groupCount, ArrayList<Clan> clans) {
}
