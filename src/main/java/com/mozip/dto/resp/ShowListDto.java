package com.mozip.dto.resp;

import lombok.Data;

@Data
public class ShowListDto {
    private int id;
    private String projectName;
    private String projectType;
    private int ownerId;
    private int views;

    public ShowListDto(int id, String projectName, String projectType, int ownerId, int views) {
        this.id = id;
        this.projectName = projectName;
        this.projectType = projectType;
        this.ownerId = ownerId;
        this.views = views;
    }
}
