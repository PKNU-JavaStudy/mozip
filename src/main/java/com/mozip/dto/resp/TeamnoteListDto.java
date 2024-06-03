package com.mozip.dto.resp;
// 데이터를 주고받을때 필요한 역할(잠깐 데이터가 머물러 감)
import lombok.Data;

@Data
public class TeamnoteListDto {
    private int id;
    private String projectSubject;
    private Object projectInfo;

    public TeamnoteListDto(int id, String projectSubject, Object projectInfo) {
        this.id = id;
        this.projectSubject = projectSubject;
        this.projectInfo = projectInfo;
    }
}
