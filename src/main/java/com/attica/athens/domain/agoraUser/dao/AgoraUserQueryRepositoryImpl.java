package com.attica.athens.domain.agoraUser.dao;

import static com.attica.athens.domain.agora.domain.QAgora.agora;
import static com.attica.athens.domain.agoraUser.domain.QAgoraUser.agoraUser;

import com.attica.athens.domain.agoraUser.domain.AgoraUserType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AgoraUserQueryRepositoryImpl implements AgoraUserQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public int countCapacityByAgoraUserType(Long agoraId, AgoraUserType type) {
        return Objects.requireNonNull(jpaQueryFactory
                        .select(agoraUser.count())
                        .from(agoraUser)
                        .where(agoraUser.type.eq(type)
                                .and(agora.id.eq(agoraId)))
                        .fetchOne())
                .intValue();
    }
}
