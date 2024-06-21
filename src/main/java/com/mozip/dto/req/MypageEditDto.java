package com.mozip.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class MypageEditDto {
    private int id;
    private String email;
    private String username;
    private int career;
    private String info;
    private String githubLink;
    private String profileImage;
    private String position;

    private List<String> skills;


    public MypageEditDto(int id, String email, String username, int career, String info, String githubLink, String profileImage, String position) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.career = career;
        this.info = info;
        this.githubLink = githubLink;
        this.profileImage = profileImage;
        this.position = position;
    }
    public MypageEditDto() {

    }
}
