package com.mozip.dto.resp.member;

import lombok.Data;

@Data
public class NewMemberListDto {
    private int id;
    private String username;
    private String position;
    private String info;
    private String profileImageUrl;
}
