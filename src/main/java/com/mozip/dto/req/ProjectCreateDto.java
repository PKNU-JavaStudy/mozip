package com.mozip.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Data
public class ProjectCreateDto {
    private int id;
    private String projectName;
    private String projectType;
    private String subject;
    private String projectPurpose;
    private int projectTime;
    private int recruitCount;
    private String projectProcess;
    private int exceptDate;
    private String projectInfo;
    private String exceptTime;
    private int ownerId;

    // 조인 쿼리
    private List<String> skills;
    private List<String> recruitRole;
}
