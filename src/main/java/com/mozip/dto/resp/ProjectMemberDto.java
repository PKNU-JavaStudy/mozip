package com.mozip.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProjectMemberDto {
    // 프로젝트 참여자 데이터(작성자, 참여자 혼용 가능)
    private int id;
    private String username;
    private String position;
    private int career;
    private String createdAt;

    public ProjectMemberDto(int id, String username, String position, int career, String createdAt) {
        this.id = id;
        this.username = username;
        this.position = position;
        this.career = career;
        this.createdAt = createdAt;
    }
}
