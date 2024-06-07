package com.mozip.domain.project;

import com.mozip.dto.req.ProjectCreateDto;
import com.mozip.dto.req.ProjectLikeDto;
import com.mozip.dto.resp.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectRepository {
    // 메인페이지 : 새로운 모집글 데이터 쿼리
    List<ProjectListDto> findNewProject();

    // 메인페이지 : 새로운 모집글에서 모집역할 테이블 조인 쿼리
    List<String> findRecruitRoles(@Param("projectId") int projectId);

    // 메인페이지 : 새로운 모집글에서 북마크 갯수 조인 쿼리
    int findBookmarkCount(@Param("projectId") int projectId);

    // 메인페이지 : 인기 모집글 데이터 쿼리
    List<ProjectListDto> findHotProject();

    // 프로젝트모집 상세페이지 : 프로젝트 정보 데이터 쿼리
    ProjectDetailDto findProjectDetail(@Param("projectId") int projectId);

    // 프로젝트모집 상세페이지 : 프로젝트 참여인원수 쿼리
    int findProjectMemberCount(@Param("projectId") int projectId);

    // 프로젝트모집 상세페이지 : 프로젝트 지원자 명단 쿼리
    List<ProjectMemberDto> findProjectMembers(@Param("projectId") int projectId);

    // 프로젝트모집 상세페이지 : 프로젝트 작성자 데이터 쿼리
    ProjectMemberDto findOwnerInfo(@Param("ownerId") int ownerId);

    // 프로젝트모집 상세페이지 : 프로젝트 기술스택 쿼리
    List<String> findProjectSkills(@Param("projectId") int projectId);

    // 프로젝트모집 상세페이지 : 프로젝트 모집분야
    List<String> findProjectRecruitRoles(@Param("projectId") int projectId);

    // 리스트페이지 : 전체 모집글 데이터 쿼리
    List<RecruitListDto> findAllProject();

    // 멤버모집리스트페이지 : 모집글 신청 멤버 조회 쿼리
    int findSubscribeCount(@Param("projectId") int projectId);

    // 프로젝트자랑리스트페이지 : 전체 자랑글 데이터 쿼리
    List<ShowListDto> findAllShowProject();

    // 프로젝트자랑리스트페이지 : 팀네임 데이터 쿼리
    String findTeamName(@Param("projectId") int projectId);

    // 프로젝트자랑리스트페이지 : 인기 프로젝트자랑 데이터 쿼리
    List<ShowListDto> findHotShow();

    // 프로젝트자랑리스트페이지 : 좋아요 수 카운트 쿼리
    int findLikeCount(@Param("projectId") int projectId);


// == 프로젝트 자랑 상세페이지(show_detail) ==
    // 프로젝트 정보 모두 가져오기(진행 멤버, 진행 방식, 모집 분야, 수행목적, 시작날짜, 종료날짜, 참여 시간, 기술 스택)
    ShowDetailDto findShowDetail(@Param("projectId") int projectId);

    // 좋아요 수 카운트
    int findShowLikeCount(@Param("projectId") int projectId);

    // 프로젝트 참여 인원수
    int findShowMemberCount(@Param("projectId") int projectId);

    // 프로젝트 작성자 프로필
    ProjectMemberDto findShowOwnerInfo(@Param("ownerId") int ownerId, @Param("projectId") int projectId);

    // 프로젝트 기술스택
    List<String> findShowSkills(@Param("projectId") int projectId);

    // 프로젝트 모집분야
    List<String> findShowRecruitRoles(@Param("projectId") int projectId);

    // 프로젝트작성페이지
    void createProject(@Param("dto") ProjectCreateDto dto);

    void createProjectSkill(@Param("skill") String skill, @Param("id") int id);

    void createRecruitRole(@Param("role") String role, @Param("id") int id);

    // 프로젝트작성페이지
    int findProjectId(@Param("projectName") String projectName);

    String findProjectName(@Param("projectName") String projectName);

    int findViewCount(@Param("projectId") int projectId);

    int findGetViewCount(int projectId);

    // 좋아요
    void addLike(@Param("dto") ProjectLikeDto dto);

    // 좋아요 취소
    void deleteLike(@Param("dto") ProjectLikeDto dto);

    // 사용자가 해당 프로젝트에 좋아요를 누른적이 있는지 체크
    int checkLike(@Param("projectId") int projectId, @Param("memberId") int memberId);

    // 프로젝트자랑페이지 : 프로젝트 삭제
    void deleteProject(@Param("projectId") int projectId);
}
