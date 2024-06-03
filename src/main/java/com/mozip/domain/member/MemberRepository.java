package com.mozip.domain.member;

import com.mozip.dto.resp.MypageDto;
import com.mozip.dto.resp.NewMemberListDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberRepository {
    // 메인페이지: 새로운 멤버 쿼리
    List<NewMemberListDto> newMemberList();

     //마이페이지: 정보 들고오기
    MypageDto getUserInfo(@Param("id") int id);
    // 마이페이지: 스킬
    List<String> getUserSkills(@Param("id") int id);
    // 마이페이지: 북마크
    List<String> getUserBookmarks(@Param("id") int id);
}

