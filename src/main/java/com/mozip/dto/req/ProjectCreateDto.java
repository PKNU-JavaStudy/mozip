package com.mozip.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Data
public class ProjectCreateDto {
    private int id;

    @NotBlank(message = "프로젝트 제목은 필수입니다!")
    @Size(min = 5, max = 50)
    private String projectName;

    @NotBlank(message = "프로젝트 타입은 필수입니다!")
    private String projectType;

    @NotBlank(message = "프로젝트 주제는 필수입니다!")
    private String subject;

    @NotBlank(message = "수행목적은 필수입니다!")
    private String projectPurpose;

    @NotNull(message = "참여시간은 필수입니다!")
    private Integer projectTime;

    @NotNull(message = "모집인원은 필수입니다!")
    private Integer recruitCount;

    @NotBlank(message = "수행목적은 필수입니다!")
    private String projectProcess;

    @NotNull(message = "예상기간은 필수입니다!")
    private Integer exceptDate;

    @NotBlank(message = "프로젝트 소개는 필수입니다!")
    private String projectInfo;

    @NotBlank(message = "시작예정 선택은 필수입니다!")
    private String exceptTime;

    private int ownerId;

    // 조인 쿼리
    @NotNull(message = "기술스택은 필수입니다!")
    private List<String> skills;

    @NotNull(message = "모집분야는 필수입니다!")
    private List<String> recruitRole;
}
