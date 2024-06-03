package com.mozip.domain.member;

import com.mozip.dto.resp.JoinMemberDto;

import java.util.Optional;


public interface AuthRepository {
    // 로그인 페이지: 새로 가입한 맴버 쿼리
    void joinMember(JoinMemberDto joinMemberDto);

    Optional<Member> findLoginMember(String email);

    String findByEmail(String email);
}
