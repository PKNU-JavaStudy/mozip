package com.mozip.domain.member;

import lombok.Getter;
import lombok.ToString;

import java.sql.NClob;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@Getter
public class Member {
    private int id;
    private String email;
    private String password;
    private String username;
    private String phone;
    private List<Role> role;
    private int career;
    private NClob info;
    private String position;
    private String githubLink;
    private String profileImageUrl;
    private int isModify;
    private LocalDateTime createdAt;

    public Member(int id, String email, String password, String username, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.phone = phone;
    }


}
