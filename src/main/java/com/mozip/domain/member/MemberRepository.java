package com.mozip.domain.member;

import com.mozip.dto.resp.NewMemberListDto;

import java.util.List;

public interface MemberRepository {
    // 메인페이지: 새로운 멤버 쿼리
    List<NewMemberListDto> newMemberList();
}
