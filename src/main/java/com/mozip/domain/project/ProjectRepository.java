package com.mozip.domain.project;

import com.mozip.dto.resp.ProjectListDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProjectRepository {

    // 메인페이지 : 새로운 모집글 데이터 쿼리
    List<ProjectListDto> findNewProject();
    // 메인페이지 : 새로운 모집글에서 모집역할 테이블 조인 쿼리
    List<String> findRecruitRoles(int projectId);
    // 메인페이지 : 새로운 모집글에서 북마크 갯수 조인 쿼리
    int findBookmarkCount(int projectId);
}
