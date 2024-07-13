package com.mozip.domain.member;

import lombok.*;

import java.sql.NClob;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Member {
    private int id;
    private String email;
    private String password;
    private String username;
    private String phone;
    private int career;
    private String info;
    private String position;
    private String githubLink;
    private String profileImageUrl;
    private int isModify;
    private LocalDateTime createdAt;
    private Role role;

    public Member(int id, String email, String password, String username, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.phone = phone;
    }




}
