package com.mozip.domain.project;

import com.mozip.dto.resp.ProjectListDto;
import com.mozip.dto.resp.RecruitListDto;
import com.mozip.dto.resp.ShowListDto;

import java.util.List;

public interface ProjectRepository {
    // 메인페이지 : 새로운 모집글 데이터 쿼리
    List<ProjectListDto> findNewProject();

    // 메인페이지 : 새로운 모집글에서 모집역할 테이블 조인 쿼리
    List<String> findRecruitRoles(int projectId);

    // 메인페이지 : 새로운 모집글에서 북마크 갯수 조인 쿼리
    int findBookmarkCount(int projectId);

    // 메인페이지 : 인기 모집글 데이터 쿼리
    List<ProjectListDto> findHotProject();

    // 멤버모집리스트페이지 : 전체 모집글 데이터 쿼리
    List<RecruitListDto> findAllProject();

    // 멤버모집리스트페이지 : 모집글 신청 멤버 조회 쿼리
    int findSubscribeCount(int projectId);

    // 프로젝트자랑리스트페이지 : 전체 자랑글 데이터 쿼리
    List<ShowListDto> findAllShowProject();

    // 프로젝트자랑리스트페이지 : 팀네임 데이터 쿼리
    String findTeamName(int projectId);

    // 프로젝트자랑리스트페이지 : 인기 프로젝트자랑 데이터 쿼리
    List<ShowListDto> findHotShow();

    // 프로젝트자랑리스트페이지 : 좋아요 수 카운트 쿼리
    int findLikeCount(int projectId);
}
