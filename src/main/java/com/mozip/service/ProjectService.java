package com.mozip.service;

import com.mozip.domain.project.ProjectRepository;
import com.mozip.dto.req.ProjectCreateDto;
import com.mozip.dto.resp.ProjectDetailDto;
import com.mozip.dto.resp.ProjectListDto;
import com.mozip.dto.resp.ProjectMemberDto;
import com.mozip.dto.resp.RecruitListDto;
import com.mozip.dto.resp.ShowListDto;
import com.mozip.handler.ex.CustomException;
import com.mozip.dto.resp.*;
import com.mozip.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.NClob;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    // 메인페이지 새로운모집글(상위 6개) 데이터 갖고오는 메서드
    public List<ProjectListDto> findNewProject() {
        // 프로젝트에서 필요 데이터를 가져온다.
        List<ProjectListDto> newProjects = projectRepository.findNewProject();

        // 다른 데이터는 프로젝트의 ID값을 통해 다른 테이블과 조인하므로 아래처럼 로직을 탄다.
        for (ProjectListDto project : newProjects) {
            // 각 project의 각 ID를 통해 북마크수, 조회수를 가져와서 추가해줘야 한다.
            project.setRoleNames(projectRepository.findRecruitRoles(project.getId()));
            project.setBookmarkCount(projectRepository.findBookmarkCount(project.getId()));
            project.setProjectInfo(Util.clobToString((NClob) project.getProjectInfo())); // NCLOB -> String 변환
        }
        return newProjects;
    }

    // 메인페이지 인기모집글(상위6개) 데이터 갖고오는 메서드
    public List<ProjectListDto> findHotProject() {
        List<ProjectListDto> hotProjects = projectRepository.findHotProject();
        // 각 project의 각 ID를 통해 북마크수, 조회수를 가져와서 추가
        for (ProjectListDto project : hotProjects) {
            project.setRoleNames(projectRepository.findRecruitRoles(project.getId()));
            project.setBookmarkCount(projectRepository.findBookmarkCount(project.getId()));
            project.setProjectInfo(Util.clobToString((NClob) project.getProjectInfo())); // NCLOB -> String 변환
        }
        return hotProjects;
    }

    // 프로젝트모집 상세페이지 데이터 갖고오는 메서드
    public ProjectDetailDto findProjectDetail(int projectId) {
        ProjectDetailDto findProject = projectRepository.findProjectDetail(projectId);

        // 프로젝트소개 타입 변경: NCLOB -> String
        findProject.setProjectInfo(Util.clobToString((NClob) findProject.getProjectInfo()));

        // 시작예정, 생성일 타입 변경
        findProject.setCreatedAt(Util.formatTimestamp(Timestamp.valueOf(findProject.getCreatedAt())));
        findProject.setExceptTime(Util.formatTimestamp(Timestamp.valueOf(findProject.getExceptTime())));

        // 프로젝트 참여자 인원 수
        findProject.setProjectMemberCount(projectRepository.findProjectMemberCount(projectId));

        List<ProjectMemberDto> projectMembers = projectRepository.findProjectMembers(projectId);
        for (ProjectMemberDto projectMember : projectMembers) {
            // 생성일 포멧 변경
            projectMember.setCreatedAt(Util.formatTimestamp(Timestamp.valueOf(projectMember.getCreatedAt())));
        }
        findProject.setMembers(projectMembers);

        // 프로젝트 모집 작성자 데이터
        findProject.setOwnerInfo(projectRepository.findOwnerInfo(findProject.getOwnerId()));

        // 프로젝트 사용 기술스택
        findProject.setSkills(projectRepository.findProjectSkills(projectId));

        // 프로젝트 모집분야
        findProject.setRecruitRoles(projectRepository.findProjectRecruitRoles(projectId));

        return findProject;
    }

    //리스트페이지 데이터 갖고오는 메서드
    public List<RecruitListDto> findAllProject() {
        List<RecruitListDto> allProjects = projectRepository.findAllProject();
        for (RecruitListDto project : allProjects) {
            project.setRoleNames(projectRepository.findRecruitRoles(project.getId()));
            project.setCreateTime(Util.formatTimestamp(Timestamp.valueOf(project.getCreateTime())));
            project.setSubscribe(projectRepository.findSubscribeCount(project.getId()));
            project.setProjectInfo(Util.clobToString((NClob) project.getProjectInfo())); // NCLOB -> String 변환
        }
        return allProjects;
    }

    // 프로젝트자랑페이지 데이터 갖고오는 메서드
    public List<ShowListDto> findAllShowProject(){
        List<ShowListDto> allShows =  projectRepository.findAllShowProject();
        for(ShowListDto show : allShows){
            show.setTeamName(projectRepository.findTeamName(show.getId()));
            show.setLikes(projectRepository.findLikeCount(show.getId()));
            show.setSkills(projectRepository.findProjectSkills(show.getId()));
        }
        return allShows;
    }

    // 프로젝트자랑페이지 인기 데이터 갖고오는 메서드
    public List<ShowListDto> findHotShow(){
        List<ShowListDto> HotShows =  projectRepository.findHotShow();
        for(ShowListDto show : HotShows) {
            show.setTeamName(projectRepository.findTeamName(show.getId()));
            show.setLikes(projectRepository.findLikeCount(show.getId()));
            show.setSkills(projectRepository.findProjectSkills(show.getId()));
        }
        return HotShows;
    }

    // 프로젝트 자랑 상세페이지(show_detail) 데이터 갖고오는 메서드
    public ShowDetailDto findShowDetail(int projectId) {
        ShowDetailDto findShowDetail = projectRepository.findShowDetail(projectId);

        // 프로젝트 소개 가져오기
        findShowDetail.setProjectInfo(Util.clobToString((NClob) findShowDetail.getProjectInfo()));

        // 좋아요 수 카운트
        findShowDetail.setLikes(projectRepository.findShowLikeCount(findShowDetail.getId()));

        // 프로젝트 참여자 인원 수
        findShowDetail.setProjectMemberCount(projectRepository.findShowMemberCount(projectId));

        // 생성일 포멧(형식) 변경
        findShowDetail.setCreatedAt(Util.formatTimestamp(Timestamp.valueOf(findShowDetail.getCreatedAt())));

        // 프로젝트 모집 작성자 데이터(우측 프로필 띄우기)
        findShowDetail.setOwnerInfo(projectRepository.findShowOwnerInfo(findShowDetail.getOwnerId(), findShowDetail.getId()));

        // 프로젝트 사용 기술스택
        findShowDetail.setSkills(projectRepository.findShowSkills(projectId));

        // 프로젝트 모집분야
        findShowDetail.setRecruitRoles(projectRepository.findShowRecruitRoles(projectId));

        return findShowDetail;
    }

    // 프로젝트작성페이지
    public int createProject(ProjectCreateDto projectCreateDto){

        // DTO 의 프로젝트네임으로 select 쿼리 날려서 값이 존재하지 않으면 아래 코드 실행
        // 존재한다면 아래 코드 실행
        String inputProjectName = projectCreateDto.getProjectName();
        String findProjectName = projectRepository.findProjectName(inputProjectName);
        if(findProjectName != null)
          throw new CustomException("프로젝트 명이 중복됩니다 !");

        // DB 실행
        projectRepository.createProject(projectCreateDto);

        // 1. DTO의 projectName으로 SELECT 쿼리를 날려서 해당 프로젝트 ID 값을 가져온다.
        String projectName = projectCreateDto.getProjectName();
        int projectId = projectRepository.findProjectId(projectName);
        System.out.println("===========================");
        System.out.println("projectId = " + projectId);
        System.out.println("===========================");

        // 2. 프로젝트 ID값으로 기술스택 테이블 데이터 세팅
        // 3. 프로젝트 ID값으로 모집역할 테이블 데이터 세팅
        List<String> skills = projectCreateDto.getSkills();
        for (String skill : skills) {
            projectRepository.createProjectSkill(skill, projectId);
        }
        List<String> roles = projectCreateDto.getRecruitRole();
        for (String role : roles) {
            projectRepository.createRecruitRole(role, projectId);
        }

        // 4. 프로젝트 ID 값을 Controller에 반환
        return projectId;
    }

    public int increaseView(int projectId) {
        return projectRepository.findViewCount(projectId);
    }
}
