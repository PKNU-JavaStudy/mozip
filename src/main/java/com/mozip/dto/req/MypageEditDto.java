package com.mozip.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class MypageEditDto {
    private int id;
    private String username;
    private int career;
    private String githubLink;
    private String position;
    private Object userinfo;
    private int isModify;

    public MypageEditDto(int id, String username, int career, String githubLink, String position, Object userinfo, int isModify) {
        this.id = id;
        this.username = username;
        this.career = career;
        this.githubLink = githubLink;
        this.position = position;
        this.userinfo = userinfo;
        this.isModify = isModify;
    }
    private List<String> skills;
}
