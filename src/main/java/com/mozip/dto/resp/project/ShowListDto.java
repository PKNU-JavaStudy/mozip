package com.mozip.dto.resp.project;

import lombok.Data;

import java.util.List;

@Data
public class ShowListDto {
    private int id;
    private String projectName;
    private String projectType;
    private int ownerId;
    private int views;
    private int isShow;
    private String imageUrl;

    // 조인 쿼리
    private String teamName;
    private int Likes;
    private List<String> skills;


    public ShowListDto(int id, String projectName, String projectType, int views, int isShow, String imageUrl) {
        this.id = id;
        this.projectName = projectName;
        this.projectType = projectType;
        this.views = views;
        this.isShow = isShow;
        this.imageUrl = imageUrl;
    }
}
