package com.mozip.dto.resp;

import lombok.Data;

import java.sql.NClob;
import java.sql.Timestamp;
import java.util.List;

@Data
public class RecruitListDto {
    // 아래 5개 컬럼은 findNewProject() 의 쿼리 반환값이 담긴다.
    private int id;
    private String projectType;
    private String projectName;
    private Object projectInfo;
    private int views;
    private int status;
    private List<String> skillName;
    private String createTime;
    private int memberCount;
    // 다른 쿼리 조인
    private List<String> roleNames;
    private int subscribe;


    // 멤버모집 리스트 페이지 생성자
    public RecruitListDto(int id, String projectType, String projectName, Object projectInfo, int views, int status, String createTime) {
        this.id = id;
        this.projectType = projectType;
        this.projectName = projectName;
        this.projectInfo = projectInfo;
        this.views = views;
        this.status = status;
        this.createTime = createTime;
    }
}
