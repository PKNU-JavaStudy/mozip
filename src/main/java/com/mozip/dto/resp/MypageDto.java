package com.mozip.dto.resp;

import lombok.Data;

import java.util.List;

@Data
public class MypageDto {
    private int id;
    private String name;
    private Integer career;
    private String info;
    private String position;
    private String profileImage;
    private String githubLink;

    public MypageDto(int id, String name, Integer career, String info, String position, String profileImage, String githubLink) {
        this.id = id;
        this.name = name;
        this.career = career;
        this.info = info;
        this.position = position;
        this.profileImage = profileImage;
        this.githubLink = githubLink;

    }

    private List<String> skills; // 프로젝트 사용하는 기술스택(project_skill 테이블과 조인)
    private List<MyProjectDto> myProjectList;    // 참여 중인 프로젝트 목록(project 테이블 조인)
    private List<MyBookmarkListDto> bookmarks; // 북마크 리스트

}
