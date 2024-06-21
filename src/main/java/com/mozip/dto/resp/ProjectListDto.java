package com.mozip.dto.resp;

import lombok.Data;

import java.sql.NClob;
import java.util.List;

@Data
public class ProjectListDto {
    // 아래 5개 컬럼은 findNewProject() 의 쿼리 반환값이 담긴다.
    private int id;
    private String projectType;
    private String projectName;
    private String projectInfo;
    private int views;

    // 다른 조인쿼리를 통해 데이터를 초기화한다.
    private List<String> roleNames;
    private int bookmarkCount;

    // 쿼리 반환값이 바로 담기기 위해 생성자를 만듬.
    public ProjectListDto(int id, String projecType, String projectName, String projectInfo, int views) {
        this.id = id;
        this.projectType = projecType;
        this.projectName = projectName;
        this.projectInfo = projectInfo;
        this.views = views;
    }
}
