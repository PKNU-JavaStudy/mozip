package com.mozip.dto.resp.member;

import lombok.Data;

@Data
public class MyProjectDto {
    private int id;
    private String projectName;
    private String projectType;
    private int status;
    private int projectTime;
    private String createdAt;

    public MyProjectDto(int id, String projectName, String projectType, int status, int projectTime, String createdAt) {
        this.id = id;
        this.projectName = projectName;
        this.projectType = projectType;
        this.status = status;
        this.projectTime = projectTime;
        this.createdAt = createdAt;
    }
}

