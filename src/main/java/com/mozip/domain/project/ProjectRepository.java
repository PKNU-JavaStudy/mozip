package com.mozip.domain.project;

import com.mozip.dto.req.project.ProjectCreateDto;
import com.mozip.dto.req.project.ProjectEditDto;
import com.mozip.dto.req.project.ShowEditDto;
import com.mozip.dto.resp.project.*;
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

    // 프로젝트모집 상세페이지 : 프로젝트 모집 완료
    int recruitDoneCheck(@Param("projectId") int projectId);

    // 모집완료
    void recruitDoneSuccess(int projectId);

    // 모집완료 취소
    void recruitDoneCancle(int projectId);

    // 리스트페이지 : 전체 모집글 데이터 쿼리
    List<RecruitListDto> findAllProject(@Param("page") int page);

    // 멤버모집리스트페이지 : 모집글 신청 멤버 조회 쿼리
    int findSubscribeCount(@Param("projectId") int projectId);

    // 프로젝트자랑리스트페이지 : 전체 자랑글 데이터 쿼리
    List<ShowListDto> findAllShowProject();


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
    void createProject(@Param("dto") ProjectCreateDto dto, @Param("img") String img);

    void createProjectSkill(@Param("skill") String skill, @Param("id") int id);

    void createRecruitRole(@Param("role") String role, @Param("id") int id);

    // 프로젝트작성페이지
    int findProjectId(@Param("projectName") String projectName);

    String findProjectName(@Param("projectName") String projectName);

    // 좋아요
    int findViewCount(@Param("projectId") int projectId);

    // 프로젝트자랑페이지 : 프로젝트 삭제
    void deleteProject(@Param("projectId") int projectId);

    // 프로젝트모집 수정페이지 : 권한체크
    int findOwnerId(@Param("projectId") int projectId, @Param("memberId") int memberId);

    // 프로젝트모집 수정페이지 : 원본 데이터 가져오기
    ProjectEditDto findProjectEditDetail(@Param("projectId") int projectId);

    // 프로젝트모집 수정페이지 : 데이터 수정
    void updateRecruitProject(@Param("dto") ProjectEditDto dto);

    // 프로젝트모집 수정페이지 : 데이터 수정(프로젝트 스킬)
    void updateProjectSkills(@Param("skill") String skill, @Param("projectId") int projectId);

    // 프로젝트모집 수정페이지 : 데이터 수정(프로젝트 모집역할)
    void updateProjectRecruitRoles(@Param("role") String role, @Param("projectId") int projectId);

    // 프로젝트 스킬 삭제
    void deleteProjectSkills(@Param("projectId") int projectId);

    // 프로젝트 모집역할 삭제
    void deleteProjectRecruitRoles(@Param("projectId") int projectId);

    // 프로젝트 북마크 삭제
    void deleteProjectBookmark(@Param("projectId") int projectId);

    // 프로젝트 참여 맴버 삭제
    void deleteProjectMembers(@Param("projectId") int projectId);

    // 프로젝트 신청 목록 삭제
    void deleteProjectSubscribe(@Param("projectId") int projectId);

    // 프로젝트자랑: 좋아요 삭제
    void deleteProjectLikes(@Param("projectId") int projectId);

    // 프로젝트자랑페이지 : 프로젝트 수정전 불러오기
    ShowEditDto editSelectShow(@Param("projectId") int projectId);

    // 프로젝트자랑페이지 : 프로젝트 수정
    void updateShow(@Param("dto") ShowEditDto dto);

    void patchProject(@Param("projectId") int projectId);

    // 프로젝트모집 : 프로젝트참여
    void projectJoin(@Param("memberId") int memberId, @Param("projectId") int projectId);

    // 프로젝트모집: 프로젝트참여 멤버 1명 가져오기
    ProjectMemberDto findOneJoinMember(@Param("memberId") int memberId, @Param("projectId") int projectId);

    // 멤버모집 : 검색
    List<RecruitListDto> searchProject(@Param("keyword") String keyword);

    // 프로젝트모집 상세 : 프로젝트 참여자 ID값 데이터
    List<Integer> findProjectMemberIdList(@Param("projectId") int projectId);

    // 프로젝트모집 : 필터
    List<Integer> filterSearch(@Param("filter") String filter);

    // 프로젝트모집 : 셀렉트 필터
    List<Integer> selectFilter(@Param("filter") Integer filter);

    // 프로젝트모집 : 타입 필터
    List<Integer> projectTypeFilter(@Param("filter") String filter);

    RecruitListDto findOneRecruit(@Param("projectId") int projectId);

    // 프로젝트생성 : 기본 이미지 세팅
    void baseProjectImg(@Param("projectId") int projectId, @Param("image") String image);
}
