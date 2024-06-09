package com.mozip.domain.member;

import com.mozip.dto.req.MypageEditDto;
import com.mozip.dto.req.UpdateMypageEditDto;
import com.mozip.dto.resp.*;
import org.apache.ibatis.annotations.Param;

import java.nio.file.Path;
import java.util.List;

public interface MemberRepository {
    // 메인페이지: 새로운 멤버 쿼리
    List<NewMemberListDto> newMemberList();

    //마이페이지: 정보 들고오기
    MypageDto getUserInfo(int id);

    // 마이페이지: 참여중인 프로젝트
    List<MyProjectDto> getUserProject(int memberId);

    // 마이페이지: 북마크
    List<MyBookmarkListDto> getUserBookmarks(int memberId);

    // 마이페이지: 스킬목록
    List<String> getUserSkill(int memberId);

    // 마이페이지 수정: 멤버 정보
    MypageEditDto editUserInfo(int id);
    // 마이페이지 수정: 스킬목록
    List<String> findSkill(int memberId);
    // 마이페이지 수정: 수정 정보 업데이트
    void updateInfo(UpdateMypageEditDto updateMypageEditDto);
    // 마이페이지 수정: 스킬 삭제
    void deleteSkills(int memberId);
    // 마이페이지 수정: 스킬 삽입
    void insertSkills(@Param("memberId") int memberId, @Param("skill") String skill);


    void updateProfileImg(@Param("imageDir") String imageDir, @Param("memberId") int memberId);
}

