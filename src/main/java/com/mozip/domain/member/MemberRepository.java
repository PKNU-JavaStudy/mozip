package com.mozip.domain.member;

import com.mozip.dto.resp.MyBookmarkListDto;
import com.mozip.dto.resp.MyProjectDto;
import com.mozip.dto.resp.MypageDto;
import com.mozip.dto.resp.NewMemberListDto;

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
}

