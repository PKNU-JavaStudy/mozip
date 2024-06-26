package com.mozip.domain.member;

import com.mozip.dto.req.project.FindEmailDto;
import com.mozip.dto.req.member.JoinMemberDto;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;


public interface AuthRepository {
    // 로그인 페이지: 새로 가입한 맴버 쿼리
    void joinMember(@Param("dto") JoinMemberDto dto, @Param("role") String role);

    // 이메일로 사용자 정보 갖고와서 로그인 검증
    Optional<Member> findMember(@Param("email") String email);

    // Email 찾는 메서드
    String findByEmail(@Param("email") String email);

    // memberId로 Email 찾는 메서드
    String findById(@Param("memberId") int memberId);

    // memberId 로 username 찾는 메서드
    String findToUsername(@Param("memberId") int memberId);

    // 프로젝트 멤버 추가
    void projectJoin(@Param("memberId") int memberId, @Param("projectId") int projectId);

    String findMemberEmail(FindEmailDto findEmailDto);

}
