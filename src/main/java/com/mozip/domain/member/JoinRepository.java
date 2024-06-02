package com.mozip.domain.member;

import com.mozip.dto.resp.JoinMemberDto;


public interface JoinRepository {
    // 로그인 페이지: 새로 가입한 맴버 쿼리
    void joinMember(JoinMemberDto joinMemberDto);
}
