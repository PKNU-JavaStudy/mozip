package com.mozip.dto.resp;
import lombok.Data;

// TODO : 추후 기능 수정
@Data
public class TeamnoteListDto {
    private int id;
    private String projectSubject;
    private String projectInfo;

    public TeamnoteListDto(int id, String projectSubject, String projectInfo) {
        this.id = id;
        this.projectSubject = projectSubject;
        this.projectInfo = projectInfo;
    }
}
