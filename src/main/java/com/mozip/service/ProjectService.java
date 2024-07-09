package com.mozip.service;

import com.mozip.domain.project.ProjectRepository;
import com.mozip.dto.req.project.ProjectCreateDto;
import com.mozip.dto.req.project.ProjectEditDto;
import com.mozip.dto.req.project.ShowEditDto;
import com.mozip.dto.resp.project.*;
import com.mozip.handler.ex.CustomException;
import com.mozip.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    /**
     * <h3>메인페이지 - 새로운모집글 데이터 갖고오는 메서드</h3>
     * <li>새로운 모집글 상위 6개를 갖고와서 반환</li>
     * <li>프로젝트의 몇몇 정보는 다른 테이블과 조인이 필요하므로 for 문을 통해 데이터를 셋팅한다.</li>
     * @return List<ProjectListDto>
     */
    public List<ProjectListDto> findNewProject() {
        // 프로젝트에서 필요 데이터를 가져온다.
        List<ProjectListDto> newProjects = projectRepository.findNewProject();

        for (ProjectListDto project : newProjects) {
            project.setRoleNames(projectRepository.findRecruitRoles(project.getId()));
            project.setBookmarkCount(projectRepository.findBookmarkCount(project.getId()));
            project.setProjectInfo(project.getProjectInfo());

        }
        return newProjects;
    }

    /**
     * <h3>메인페이지 - 인기모집글 데이터 갖고오는 메서드</h3>
     * <li>프로젝트 중 조회수가 가장 많은 상위 6개의 데이터를 가져온다.</li>
     * <li>findNewProject() 와 거의 똑같은 로직</li>
     * @return List<ProjectListDto>
     */
    public List<ProjectListDto> findHotProject() {
        List<ProjectListDto> hotProjects = projectRepository.findHotProject();
        // 각 project의 각 ID를 통해 북마크수, 조회수를 가져와서 추가
        for (ProjectListDto project : hotProjects) {
            project.setRoleNames(projectRepository.findRecruitRoles(project.getId()));
            project.setBookmarkCount(projectRepository.findBookmarkCount(project.getId()));
            project.setProjectInfo(project.getProjectInfo());
        }
        return hotProjects;
    }

    /**
     * <h3>프로젝트모집 상세페이지 데이터 갖고오는 메서드</h3>
     * <li>프로젝트 ID를 통해 상세페이지에 뿌려줄 데이터를 셋팅한다.</li>
     * @param projectId
     * @return ProjectDetailDto
     */
    public ProjectDetailDto findProjectDetail(int projectId) {
        ProjectDetailDto findProject = projectRepository.findProjectDetail(projectId);

        // 프로젝트소개
        findProject.setProjectInfo(findProject.getProjectInfo());


        // 시작예정, 생성일 타입 변경
        findProject.setCreatedAt(Util.formatTimestamp(Timestamp.valueOf(findProject.getCreatedAt())));
        findProject.setExceptTime(Util.formatTimestamp(Timestamp.valueOf(findProject.getExceptTime())));

        // 프로젝트 참여자 인원 수
        findProject.setProjectMemberCount(projectRepository.findProjectMemberCount(projectId));

        // 프로젝트 참여자 데이터
        findProject.setProjectMemberIds(projectRepository.findProjectMemberIdList(projectId));

        // 프로젝트 지원자 데이터
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

    /**
     * <h3>프로젝트모집 목록 페이지 데이터 갖고오는 메서드</h3>
     * <li>목록 페이지에 뿌려줄 데이터들을 셋팅</li>
     * @return List<RecruitListDto>
     */
    public List<RecruitListDto> findAllProject(int page) {
        List<RecruitListDto> allProjects = projectRepository.findAllProject(page);
        for (RecruitListDto project : allProjects) {
            project.setRoleNames(projectRepository.findRecruitRoles(project.getId()));
            project.setCreateTime(Util.formatTimestamp(Timestamp.valueOf(project.getCreateTime())));
            project.setSubscribe(projectRepository.findSubscribeCount(project.getId()));
            project.setProjectInfo(project.getProjectInfo());
        }
        return allProjects;
    }

    /**
     * <h3>프로젝트자랑 목록 페이지 데이터 갖고오는 메서드</h3>
     * <li>프로젝트 중 프로젝트 자랑인 데이터만 셋팅하여 갖고온다.</li>
     * @return List<ShowListDto>
     */
    public List<ShowListDto> findAllShowProject() {
        List<ShowListDto> allShows = projectRepository.findAllShowProject();
        for (ShowListDto show : allShows) {
            show.setLikes(projectRepository.findLikeCount(show.getId()));
            show.setSkills(projectRepository.findProjectSkills(show.getId()));
        }
        return allShows;
    }

    /**
     * <h3>프로젝트자랑 목록 인기 프로젝트 갖고오는 메서드</h3>
     * <li>프로젝트중 프로젝트자랑인 데이터를 상위 6개 갖고온다.</li>
     * @return List<ShowListDto>
     */
    public List<ShowListDto> findHotShow() {
        List<ShowListDto> HotShows = projectRepository.findHotShow();
        for (ShowListDto show : HotShows) {
            show.setLikes(projectRepository.findLikeCount(show.getId()));
            show.setSkills(projectRepository.findProjectSkills(show.getId()));
        }
        return HotShows;
    }

    /**
     * <h3>프로젝트자랑 상세 데이터 갖고오는 메서드</h3>
     * <li>프로젝트ID값을 통해 상세페이지에 뿌려줄 데이터를 갖고온다.</li>
     * @param projectId
     * @return ShowDetailDto
     */
    public ShowDetailDto findShowDetail(int projectId) {
        ShowDetailDto findShowDetail = projectRepository.findShowDetail(projectId);

        // 프로젝트 소개 가져오기
        findShowDetail.setProjectInfo(findShowDetail.getProjectInfo());

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

    /**
     * <h3>프로젝트생성 메서드</h3>
     * <li>사용자로부터 입력받은 DTO를 통해 프로젝트를 생성한다.</li>
     * @param projectCreateDto
     * @return int
     */
    @Transactional
    public int createProject(ProjectCreateDto projectCreateDto) {

        // DTO 의 프로젝트네임으로 select 쿼리 날려서 값이 존재하지 않으면 아래 코드 실행
        // 존재한다면 아래 코드 실행
        String inputProjectName = projectCreateDto.getProjectName();
        String findProjectName = projectRepository.findProjectName(inputProjectName);
        if (findProjectName != null)
            throw new CustomException("프로젝트 명이 중복됩니다 !");

        // DB 실행
        if(projectCreateDto.getProjectType().equals("사이드 프로젝트"))
            projectRepository.createProject(projectCreateDto, "project_sample.png");
        else if(projectCreateDto.getProjectType().equals("스터디/모임"))
            projectRepository.createProject(projectCreateDto,"study_sample.png");

        // 1. DTO의 projectName으로 SELECT 쿼리를 날려서 해당 프로젝트 ID 값을 가져온다.
        String projectName = projectCreateDto.getProjectName();
        int projectId = projectRepository.findProjectId(projectName);

        // 2. 프로젝트 ID값으로 기술스택 테이블 데이터 세팅
        List<String> skills = projectCreateDto.getSkills();
        for (String skill : skills) {
            projectRepository.createProjectSkill(skill, projectId);
        }

        // 3. 프로젝트 ID값으로 모집역할 테이블 데이터 세팅
        List<String> roles = projectCreateDto.getRecruitRole();
        for (String role : roles) {
            projectRepository.createRecruitRole(role, projectId);
        }

        // 기본이미지 변경
        if(projectCreateDto.getProjectType().equals("사이드 프로젝트"))
            projectRepository.baseProjectImg(projectId,"project_sample.png");
        else
            projectRepository.baseProjectImg(projectId,"study_sample.png");

        // 4. 프로젝트 ID 값을 Controller에 반환
        return projectId;
    }

    /**
     * <h3>프로젝트 조회수 증가 메서드</h3>
     * <li>프로젝트ID값을 통해 조회수를 증가시키는 메서드</li>
     * @param projectId
     * @return int
     */
    @Transactional
    public int increaseView(int projectId) {
        return projectRepository.findViewCount(projectId);
    }

    /**
     * <h3>프로젝트 삭제 메서드</h3>
     * <li>프로젝트ID값을 통해 프로젝트를 삭제한다.</li>
     * <li>프로젝트 스킬,모집역할,북마크,좋아요,신청맴버,신청목록 삭제 추가</li>
     * @param projectId
     */
    @Transactional
    public void deleteProject(int projectId) {
        projectRepository.deleteProject(projectId);
        projectRepository.deleteProjectSkills(projectId);
        projectRepository.deleteProjectRecruitRoles(projectId);
        projectRepository.deleteProjectBookmark(projectId);
        projectRepository.deleteProjectMembers(projectId);
        projectRepository.deleteProjectSubscribe(projectId);
        projectRepository.deleteProjectLikes(projectId);
    }

    /**
     * <h3>프로젝트자랑 수정 전 기존 데이터 갖고오는 메서드</h3>
     * <li>프로젝트자랑 수정 페이지에서 해당 프로젝트의 기존 값들을 갖고온다.</li>
     * @param projectId
     * @return ShowEditDto
     */
    public ShowEditDto editSelectShow(int projectId) {
        ShowEditDto project = projectRepository.editSelectShow(projectId);

        project.setSkills(projectRepository.findProjectSkills(projectId));
        project.setRecruitRole(projectRepository.findRecruitRoles(projectId));
        project.setProjectInfo(project.getProjectInfo());
        // LocalDateTime -> String 변환
        project.setCreatedChangeAt(Util.formatTimestamp(project.getCreatedAt()));
        return project;
    }

    /**
     * <h3>프로젝트자랑 수정 메서드</h3>
     * <li>사용자로부터 입력받은 수정할 데이터와 프로젝트 ID를 통해 프로젝트를 수정한다.</li>
     * @param dto
     * @param projectId
     */
    @Transactional
    public void updateShow(ShowEditDto dto, int projectId) {
        dto.setId(projectId);
        try {
            dto.setCreatedAt(Util.stringToTimestamp(dto.getCreatedChangeAt()));
            dto.setModifiedShow(Util.stringToTimestamp(dto.getModifiedChangeAt()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        projectRepository.updateShow(dto);

        projectRepository.deleteProjectSkills(dto.getId());
        projectRepository.deleteProjectRecruitRoles(dto.getId());

        dto.getSkills().forEach(skill -> {
            projectRepository.updateProjectSkills(skill, dto.getId());
        });

        dto.getRecruitRole().forEach(role -> {
            projectRepository.updateProjectRecruitRoles(role, dto.getId());
        });
    }

    /**
     * <h3>프로젝트 모집완료 메서드</h3>
     * <li>프로젝트ID값으로 모집완료인지 모집중인지 구분하여 로직 수행</li>
     * @param projectId
     * @return int
     */
    @Transactional
    public int recruitIsDone(int projectId) {
        // 모집완료 여부 체크
        int projectStatus = projectRepository.recruitDoneCheck(projectId);
        if (projectStatus == 1) {
            // 모집완료 등록
            projectRepository.recruitDoneSuccess(projectId);
            return 1;
        } else {
            // 모집완료 해제
            projectRepository.recruitDoneCancle(projectId);
            return -1;
        }
    }

    /**
     * <h3>프로젝트 수정 권한 체크 메서드</h3>
     * <li>해당 프로젝트의 작성자(ownerId)만 수정하게 권한을 체크하는 메서드</li>
     * @param projectId
     * @param memberid
     * @return boolean
     */
    public boolean ownerCheck(int projectId, int memberid) {
        if (projectRepository.findOwnerId(projectId, memberid) != projectId)
            return false;

        return true;
    }

    /**
     * <h3>프로젝트 수정 전 기존 데이터 갖고오는 메서드</h3>
     * <li>프로젝트ID를 통해 수정 전 기존 데이터를 갖고온다.</li>
     * @param projectId
     * @return ProjectEditDto
     */
    public ProjectEditDto findOriginProjectInfo(int projectId) {
        ProjectEditDto project = projectRepository.findProjectEditDetail(projectId);
        project.setSkills(projectRepository.findProjectSkills(projectId));
        project.setRecruitRole(projectRepository.findRecruitRoles(projectId));
//        project.setProjectInfo(project.getProjectInfo());
        // LocalDateTime -> String 변환
        project.setExceptChangeTime(Util.formatTimestamp(project.getExceptTime()));

        return project;
    }

    /**
     * <h3>프로젝트 수정 메서드</h3>
     * <li>사용자로부터 입력받은 프로젝트 수정 데이터로 프로젝트를 수정 </li>
     * @param dto
     */
    @Transactional
    public void updateRecruitProject(ProjectEditDto dto) {
        try {
            dto.setExceptTime(Util.stringToTimestamp(dto.getExceptChangeTime()));
        } catch (ParseException e) {
            throw new CustomException(e.getMessage());
        }

        projectRepository.updateRecruitProject(dto);

        projectRepository.deleteProjectSkills(dto.getId());
        projectRepository.deleteProjectRecruitRoles(dto.getId());

        dto.getSkills().forEach(skill -> {
            projectRepository.updateProjectSkills(skill, dto.getId());
        });

        dto.getRecruitRole().forEach(role -> {
            projectRepository.updateProjectRecruitRoles(role, dto.getId());
        });
    }

    /**
     * <h3>프로젝트 모집 신청 메서드</h3>
     * <li>해당 프로젝트의 참여인원으로 추가된다.</li>
     * @param memberId
     * @param projectId
     * @return ProjectMemberDto
     */
    @Transactional
    public ProjectMemberDto projectJoin(int memberId, int projectId) {
        projectRepository.projectJoin(memberId, projectId);

        // 참여 완료 시 실시간으로 참가신청자 목록에 추가하기 위한 데이터
        ProjectMemberDto memberInfo = projectRepository.findOneJoinMember(memberId, projectId);
        memberInfo.setCreatedAt(Util.formatTimestamp(Timestamp.valueOf(memberInfo.getCreatedAt())));

        return memberInfo;
    }

    /**
     * <h3>프로젝트모집 검색 메서드</h3>
     * <li>프로젝트모집 목록 페이지에서 프로젝트를 검색하는 메서드</li>
     * @param keyword
     * @return List<RecruitListDto>
     */
    public List<RecruitListDto> searchProject(String keyword) {
        List<RecruitListDto> recruitListDtos = projectRepository.searchProject(keyword);
        for (RecruitListDto recruitListDto : recruitListDtos) {
            recruitListDto.setRoleNames(projectRepository.findRecruitRoles(recruitListDto.getId()));
            recruitListDto.setCreateTime(Util.formatTimestamp(Timestamp.valueOf(recruitListDto.getCreateTime())));
            recruitListDto.setSubscribe(projectRepository.findSubscribeCount(recruitListDto.getId()));
            recruitListDto.setProjectInfo(recruitListDto.getProjectInfo());
        }
        return recruitListDtos;
    }

    /**
     * <h3>프로젝트자랑 검색 메서드</h3>
     * <li>프로젝트자랑 목록 페이지에서 프로젝트를 검색하는 메서드</li>
     * @param
     * @return List<ShowListDto>
     */
    public List<ShowListDto> searchShow(String keyword) {
        List<ShowListDto> showListDtos = projectRepository.searchShow(keyword);
        for (ShowListDto showListDto : showListDtos) {
            showListDto.setLikes(projectRepository.findLikeCount(showListDto.getId()));
            showListDto.setSkills(projectRepository.findProjectSkills(showListDto.getId()));
        }
        return showListDtos;
    }

    /**
     * <h3>프로젝트모집 카테고리 필터 메서드</h3>
     * <li>프론트,백엔드,디자이너 등등 카테고리에 따른 필터된 데이터를 갖고오는 메서드이다.</li>
     * @param
     * @return List<RecruitListDto>
     */
    public List<RecruitListDto> projectFilterSearch(String filter) {
        List<Integer> projectFilterId = projectRepository.filterSearch(filter);

        List<RecruitListDto> recruitListDtos = new ArrayList<>();
        for (Integer projectId : projectFilterId) {
            recruitListDtos.add(projectRepository.findOneRecruit(projectId));
        }
        for (RecruitListDto dto : recruitListDtos) {
            dto.setRoleNames(projectRepository.findRecruitRoles(dto.getId()));
            dto.setCreateTime(Util.formatTimestamp(Timestamp.valueOf(dto.getCreateTime())));
            dto.setSubscribe(projectRepository.findSubscribeCount(dto.getId()));
            dto.setProjectInfo(dto.getProjectInfo());
        }
        return recruitListDtos;
    }

    /**
     * <h3>프로젝트모집 셀렉트 필터</h3>
     * <li>모집중/모집완료 셀렉트 버튼에 따라 필터된 데이터를 갖고오는 메서드이다.</li>
     * @param filter
     * @return List<RecruitListDto>
     */
    public List<RecruitListDto> projectSelectFilterSearch(String filter) {
        List<Integer> projectFilterId = projectRepository.selectFilter(Integer.parseInt(filter));
        List<RecruitListDto> recruitListDtos = new ArrayList<>();
        for (Integer projectId : projectFilterId) {
            recruitListDtos.add(projectRepository.findOneRecruit(projectId));
        }
        for (RecruitListDto dto : recruitListDtos) {
            dto.setRoleNames(projectRepository.findRecruitRoles(dto.getId()));
            dto.setCreateTime(Util.formatTimestamp(Timestamp.valueOf(dto.getCreateTime())));
            dto.setSubscribe(projectRepository.findSubscribeCount(dto.getId()));
            dto.setProjectInfo(dto.getProjectInfo());
        }
        return recruitListDtos;
    }

    /**
     * <h3>프로젝트 타입 필터 메서드</h3>
     * <li>프로젝트 타입(사이드프로젝트 or 스터디)에 따라 필터된 데이터를 갖고오는 메서드</li>
     * @param filter
     * @return List<RecruitListDto>
     */
    public List<RecruitListDto> projectSelectTypeFilter(String filter) {
        if (filter.equals("스터디 모임"))
            filter = "스터디/모임";

        List<Integer> projectFilterId = projectRepository.projectTypeFilter(filter);

        List<RecruitListDto> recruitListDtos = new ArrayList<>();
        for (Integer projectId : projectFilterId) {
            recruitListDtos.add(projectRepository.findOneRecruit(projectId));
        }
        for (RecruitListDto dto : recruitListDtos) {
            dto.setRoleNames(projectRepository.findRecruitRoles(dto.getId()));
            dto.setCreateTime(Util.formatTimestamp(Timestamp.valueOf(dto.getCreateTime())));
            dto.setSubscribe(projectRepository.findSubscribeCount(dto.getId()));
            dto.setProjectInfo(dto.getProjectInfo());
        }
        return recruitListDtos;
    }

    // 프로젝트자랑 기술스택 필터
    public List<ShowListDto> projectSkillFilter(String filter) {

        List<ShowListDto> allShows = projectRepository.projectSkillFilter(filter);
        for (ShowListDto show : allShows) {
            show.setLikes(projectRepository.findLikeCount(show.getId()));
            show.setSkills(projectRepository.findProjectSkills(show.getId()));
        }
        return allShows;
    }

    // 프로젝트자랑 셀렉트 필터(최신순)
    public List<ShowListDto> selectConditionFilter(String filter) {

        List<ShowListDto> filteredList;

        if (filter.equals("old")) {
            // 오래된순
            filteredList = projectRepository.oldConditionSelect();
        } else if (filter.equals("save")) {
            // 북마크순
            filteredList = projectRepository.saveConditionSelect();
        } else {
            // 기본값 최신순으로 처리
            filteredList = projectRepository.newConditionSelect();
        }
        System.out.println("=======================");
        System.out.println("filter = " + filter);
        for (ShowListDto showListDto : filteredList) {
            System.out.println("showListDto = " + showListDto);
        }
        System.out.println("=======================");

        for (ShowListDto show : filteredList) {
            show.setLikes(projectRepository.findLikeCount(show.getId()));
            show.setSkills(projectRepository.findProjectSkills(show.getId()));
        }
        return filteredList;
    }

}
