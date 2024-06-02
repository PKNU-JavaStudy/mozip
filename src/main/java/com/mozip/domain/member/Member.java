package com.mozip.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.NClob;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Member {
    private int id;
    private String email;
    private String password;
    private String username;
    private String phone;
    private int career;
    private NClob info;
    private String position;
    private String githubLink;
    private String profileImageUrl;
    private int isModify;
    private LocalDateTime createdAt;
}
