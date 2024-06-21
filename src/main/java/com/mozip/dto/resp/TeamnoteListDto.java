package com.mozip.dto.resp;
// 데이터를 주고받을때 필요한 역할(잠깐 데이터가 머물러 감)
import lombok.Data;

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
