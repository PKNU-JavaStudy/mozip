package com.mozip.dto.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class ProjectEditDto {
    private int id;
    private String projectType;
    private String projectName;
    private String subject;
    private String recruitCount;
    private String projectPurpose;
    private String projectTime;
    private String projectProcess;
    private String exceptDate;
    private LocalDateTime exceptTime;
    private String projectInfo;

    private String exceptChangeTime; // LocalDateTime 을 String 으로 바꿔서 input태그(date속성)에 담을 수 있음
    private List<String> skills;
    private List<String> recruitRole;
}
