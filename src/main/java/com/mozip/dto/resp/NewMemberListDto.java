package com.mozip.dto.resp;

import lombok.Data;

import java.sql.NClob;

@Data
public class NewMemberListDto {
    private int id;
    private String username;
    private String position;
    private String info;
    private String profileImageUrl;
}
