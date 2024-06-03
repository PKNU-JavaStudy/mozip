package com.mozip.dto.resp;

import lombok.Data;

import java.util.List;

@Data
public class ShowListDto {
    private int id;
    private String projectName;
    private String projectType;
    private int ownerId;
    private int views;
    // 조인 쿼리
    private String teamName;
    private int Likes;
    private List<String> skills;


    public ShowListDto(int id, String projectName, String projectType, int views) {
        this.id = id;
        this.projectName = projectName;
        this.projectType = projectType;
        this.views = views;
    }
}
