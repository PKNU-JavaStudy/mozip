package com.mozip.service;

import com.mozip.domain.project.ProjectRepository;
import com.mozip.dto.resp.ProjectDetailDto;
import com.mozip.dto.resp.ProjectListDto;
import com.mozip.dto.resp.ProjectMemberDto;
import com.mozip.dto.resp.RecruitListDto;
import com.mozip.dto.resp.ShowListDto;
import com.mozip.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.NClob;
import java.sql.Timestamp;
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

}
