package com.mozip.service;

import com.mozip.domain.project.ProjectRepository;
import com.mozip.dto.resp.ProjectListDto;
import com.mozip.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.NClob;
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
    public List<ProjectListDto> findHotProject(){
        List<ProjectListDto> hotProjects = projectRepository.findHotProject();
        // 각 project의 각 ID를 통해 북마크수, 조회수를 가져와서 추가
        for (ProjectListDto project : hotProjects) {
            project.setRoleNames(projectRepository.findRecruitRoles(project.getId()));
            project.setBookmarkCount(projectRepository.findBookmarkCount(project.getId()));
            project.setProjectInfo(Util.clobToString((NClob) project.getProjectInfo())); // NCLOB -> String 변환
        }

        return hotProjects;
    }
}
