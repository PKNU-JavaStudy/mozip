package com.mozip.dto.resp;

import lombok.Data;

import java.sql.NClob;

@Data
public class NewMemberListDto {
    // TODO : 추후 이미지 저장 구현 후 이미지 URL 추가해야함
    private int id;
    private String username;
    private String position;
    private Object info;
}
