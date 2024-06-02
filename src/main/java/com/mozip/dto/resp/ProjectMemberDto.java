package com.mozip.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProjectMemberDto {
    // 프로젝트 참여자 데이터(작성자, 참여자 혼용 가능)
    private int id;
    private String username;
    private String position;
    private int career;
}
