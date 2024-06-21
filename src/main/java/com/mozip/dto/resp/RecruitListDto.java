package com.mozip.dto.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.NClob;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Data
public class RecruitListDto {
    // 아래 5개 컬럼은 findNewProject() 의 쿼리 반환값이 담긴다.
    private int id;
    private String projectName;
    private String projectType;
    private String projectInfo;
    private int views;
    private int status;
    private String createTime;
    // 다른 쿼리 조인
    private List<String> roleNames;
    private int subscribe;
}
