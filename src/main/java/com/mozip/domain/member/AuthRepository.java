package com.mozip.domain.member;

import com.mozip.dto.resp.JoinMemberDto;

import java.util.Optional;


public interface AuthRepository {
    // 로그인 페이지: 새로 가입한 맴버 쿼리
    void joinMember(JoinMemberDto joinMemberDto);

    // 이메일로 사용자 정보 갖고와서 로그인 검증
    Optional<Member> findLoginMember(String email);

    // Email 찾는 메서드
    String findByEmail(String email);

    // memberId로 Email 찾는 메서드
    String findById(int memberId);
}
