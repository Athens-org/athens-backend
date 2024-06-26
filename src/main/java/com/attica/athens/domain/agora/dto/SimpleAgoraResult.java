package com.attica.athens.domain.agora.dto;

import com.attica.athens.domain.agora.dao.AgoraResult;
import com.attica.athens.domain.agora.domain.AgoraStatus;
import java.time.LocalDateTime;

public record SimpleAgoraResult(
        Long id,
        String agoraTitle,
        String agoraColor,
        SimpleParticipants participants,
        LocalDateTime createdAt,
        AgoraStatus status
) implements AgoraResult {

    @Override
    public Long id() {
        return id;
    }
}
